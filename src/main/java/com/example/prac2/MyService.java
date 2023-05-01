package com.example.prac2;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.RequiresApi;

public class MyService extends Service {
    private WindowManager wm;
    private View ov;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(){
        super.onCreate();

        Log.i("My_SERVICE", "ЗАПУСК");
        ov = LayoutInflater.from(this).inflate(R.layout.service_layout, null);
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        wm.addView(ov, params);
        params.gravity = Gravity.LEFT | Gravity.TOP;
        wm.updateViewLayout(ov, params);
        Button myButton = ov.findViewById(R.id.transfer_to_first);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.prac2");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MY_SERVICE", "ВЫПУСК");
        // Освобождаем ресурсы
        if (ov != null) {
            wm.removeView(ov);
            ov = null;
        }
    }
}
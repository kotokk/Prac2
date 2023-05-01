package com.example.prac2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";
    private static final String CHANNEL_ID = "channel";
    private NotificationManager notificationManager;
    private int NOTIFY_ID;

    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");

        Button hacks = getView().findViewById(R.id.butt_hacks);
        hacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                Log.i(TAG, "Переход к хакатонам");
                Navigation.findNavController(arg).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
        Button news = getView().findViewById(R.id.butt_news);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Переход к хакатонам");
                Bundle bundle = new Bundle();
                String info = "Очень важные данные";
                bundle.putString("data", info);
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_thirdFragment, bundle);
            }
        });
        Button notif = getView().findViewById(R.id.butt_notif);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Уведомление");
                showNotification();
            }
        });
    }

    public void showNotification(){
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setAutoCancel(false)
                .setSmallIcon(R.drawable.heart)
                .setContentTitle("УВЕДОМЛЕНИЕ")
                .setContentText("На самом деле ничего важного")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, builder.build());
    }

    public static void createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(nc);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewStateRestored");


    }
}
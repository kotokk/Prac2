package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onStop() {
        super.onStop();
        startService(new Intent(this, MyService.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        stopService(new Intent(this, MyService.class));
    }
}
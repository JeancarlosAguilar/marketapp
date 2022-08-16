package com.example.marketapp.launch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.marketapp.R;
import com.example.marketapp.SystemIndexActivityView;
import com.example.marketapp.view.SignInActivityView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, SignInActivityView.class);
            startActivity(intent);
            finish();
        }, 1000);


    }

}
package com.example.marketapp.launch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.R;
import com.example.marketapp.view.SingInActivityView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SingInActivityView.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 5000);

    }
}
package com.example.marketapp.launch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.marketapp.R;


public class SlideActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        viewPager = findViewById(R.id.viewpager);
        adapter = new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        if (isOpenAlReady()) {
            Intent intent = new Intent(SlideActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            SharedPreferences.Editor editor = getSharedPreferences("USER", MODE_PRIVATE).edit();
            editor.putBoolean("SLIDE", true);
            editor.apply();
        }

    }

    private boolean isOpenAlReady() {

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("SLIDE", false);
        return result;

    }
}
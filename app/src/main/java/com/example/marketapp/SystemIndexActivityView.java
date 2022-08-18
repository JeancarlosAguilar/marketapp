package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.databinding.ActivitySystemIndexViewBinding;


public class SystemIndexActivityView extends AppCompatActivity {

    private ActivitySystemIndexViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySystemIndexViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnr();
    }


    private void btnr() {
        //TODO - AÑADIR MVP
        binding.imgProfile.setOnClickListener(view -> {
            Intent intent = new Intent(SystemIndexActivityView.this, SystemAccActivityView.class);
            startActivity(intent);
        });
    }


}
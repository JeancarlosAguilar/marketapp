package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketapp.databinding.ActivitySignInViewBinding;
import com.example.marketapp.databinding.ActivitySystemIndexViewBinding;

public class SystemIndexActivityView extends AppCompatActivity {

    private ActivitySystemIndexViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_index_view);

        binding = ActivitySystemIndexViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

}
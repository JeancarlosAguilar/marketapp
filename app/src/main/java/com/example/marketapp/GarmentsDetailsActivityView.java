package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketapp.databinding.ActivityGarmentsDetailsViewBinding;

public class GarmentsDetailsActivityView extends AppCompatActivity {

    private ActivityGarmentsDetailsViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGarmentsDetailsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
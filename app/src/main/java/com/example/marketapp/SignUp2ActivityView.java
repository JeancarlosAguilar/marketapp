package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketapp.databinding.ActivitySignUp2ViewBinding;

public class SignUp2ActivityView extends AppCompatActivity {

    private ActivitySignUp2ViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2_view);

        binding = ActivitySignUp2ViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_back();
    }

    private void btn_back() {
        binding.imgSignup2Back.setOnClickListener(view -> finish());
    }
}
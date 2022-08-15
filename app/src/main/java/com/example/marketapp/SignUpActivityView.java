package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.marketapp.databinding.ActivitySignInViewBinding;
import com.example.marketapp.databinding.ActivitySignUpViewBinding;

public class SignUpActivityView extends AppCompatActivity {

    private ActivitySignUpViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_view);

        binding = ActivitySignUpViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_back();
    }

    private void btn_back() {
        binding.imgBack.setOnClickListener(view -> finish());
    }
}
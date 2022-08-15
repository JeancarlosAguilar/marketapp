package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.databinding.ActivitySignUp1ViewBinding;

public class SignUp1ActivityView extends AppCompatActivity {

    private ActivitySignUp1ViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1_view);

        binding = ActivitySignUp1ViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_back();
        btn_continue();
    }

    private void btn_continue() {
        binding.btnSignup1Continue.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp1ActivityView.this, SignUp2ActivityView.class);
            startActivity(intent);
        });
    }

    private void btn_back() {
        binding.imgSignup1Back.setOnClickListener(view -> finish());
    }
}
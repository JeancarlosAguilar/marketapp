package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.databinding.ActivitySignInViewBinding;

public class SignInActivityView extends AppCompatActivity {

    private ActivitySignInViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_view);

        binding = ActivitySignInViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_signup();
    }

    private void btn_signup() {
        binding.tvSigninMsg6.setOnClickListener(view -> {
            Intent intent = new Intent(SignInActivityView.this, SignUp1ActivityView.class);
            startActivity(intent);
        });
    }

}
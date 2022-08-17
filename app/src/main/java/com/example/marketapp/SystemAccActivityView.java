package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.marketapp.databinding.ActivitySystemAccViewBinding;
import com.example.marketapp.databinding.ActivitySystemIndexViewBinding;
import com.example.marketapp.view.SignInActivityView;

public class SystemAccActivityView extends AppCompatActivity {

    private ActivitySystemAccViewBinding binding;
    private SystemIndexActivityView siav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_acc_view);

        binding = ActivitySystemAccViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btn_logout();
        btn_home();
        btn_back();
    }

    public void btn_logout() { // PENDIENTE AGREGAR MVP, REF: SigInModel.class
        binding.btnLogout.setOnClickListener(view -> {
            SharedPreferences preferences = getSharedPreferences("USER", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("SESSION", false);
            editor.apply();

            Intent intent = new Intent(this, SignInActivityView.class);
            startActivity(intent);
            finish();

        });
    }

    public void btn_home() {
        binding.imgHome.setOnClickListener(view -> {
            finish();
        });
    }

    public void btn_back() {
        binding.imgSaccBack.setOnClickListener(view -> {
            finish();
        });
    }
}
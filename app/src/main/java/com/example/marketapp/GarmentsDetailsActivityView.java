package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marketapp.databinding.ActivityGarmentsDetailsViewBinding;

public class GarmentsDetailsActivityView extends AppCompatActivity {

    private ActivityGarmentsDetailsViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGarmentsDetailsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvTitle.setText(getIntent().getStringExtra("title"));

        String price = "Price: " + getIntent().getLongExtra("price", 0);
        binding.tvPrice.setText(price);

        String availableQuantity = "Available quantity: " + getIntent().getLongExtra("availableQuantity", 0);
        binding.tvAvailableQuantity.setText(availableQuantity);

        String soldQuantity = "Sold quantity: " + getIntent().getLongExtra("soldQuantity", 0);
        binding.tvSoldQuantity.setText(soldQuantity);

        String departament = "Departament: " + getIntent().getStringExtra("stateName");
        binding.tvAddressStateName.setText(departament);

        String city = "City: " + getIntent().getStringExtra("cityName");
        binding.tvAddressCityName.setText(city);

        String thumbnail = getIntent().getStringExtra("thumbnail");
        Glide.with(this)
                .load(thumbnail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imgThumbnail);

        back();
    }

    private void back() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
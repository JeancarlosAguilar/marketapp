package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.marketapp.api_files.Garments.Garments;
import com.example.marketapp.api_files.Garments.GarmentsResponse;
import com.example.marketapp.api_files.Garments.GarmentsService;
import com.example.marketapp.api_files.Garments.ListGarmentsAdapter;
import com.example.marketapp.databinding.ActivitySystemIndexViewBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SystemIndexActivityView extends AppCompatActivity {

    private static final String TAG = "GETAPI";
    private Retrofit retrofit;
    private ListGarmentsAdapter listGarmentsAdapter;
    private ActivitySystemIndexViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySystemIndexViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listGarmentsAdapter = new ListGarmentsAdapter(this);
        binding.recyclerViewGerments.setAdapter(listGarmentsAdapter);
        binding.recyclerViewGerments.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerViewGerments.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/sites/MCO/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        botenerDatos();
        btnr();
    }

    private void btnr() {
        //TODO - AÑADIR MVP
        binding.imgProfile.setOnClickListener(view -> {
            Intent intent = new Intent(SystemIndexActivityView.this, SystemAccActivityView.class);
            startActivity(intent);
        });
    }

    private void botenerDatos() {
        GarmentsService service = retrofit.create(GarmentsService.class);
        Call<GarmentsResponse> garmentsResponseCall = service.getListGarments();

        garmentsResponseCall.enqueue(new Callback<GarmentsResponse>() {
            @Override
            public void onResponse(Call<GarmentsResponse> call, Response<GarmentsResponse> response) {
                if (response.isSuccessful()) {
                    listGarmentsAdapter.addListGarments(response.body().getResults());
                } else {
                    Log.e(TAG, "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<GarmentsResponse> call, Throwable t) {
                Log.e(TAG, "onResponse: " + t.getMessage());
            }
        });
    }
}
package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.marketapp.api_files.garments.Garments;
import com.example.marketapp.api_files.garments.GarmentsResponse;
import com.example.marketapp.api_files.garments.GarmentsService;
import com.example.marketapp.api_files.garments.ListGarmentsAdapter;
import com.example.marketapp.api_files.seach.ListSearchAdapter;
import com.example.marketapp.api_files.seach.Search;
import com.example.marketapp.api_files.seach.SearchResponse;
import com.example.marketapp.api_files.seach.SearchService;
import com.example.marketapp.databinding.ActivitySearchViewBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivityView extends AppCompatActivity implements ListSearchAdapter.OnItemClickListener {

    private static final String TAG = "GETAPI";
    private Retrofit retrofit;
    private ListSearchAdapter listSearchAdapter;
    private ActivitySearchViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listSearchAdapter = new ListSearchAdapter(this, this);
        binding.recyclerViewSearch.setAdapter(listSearchAdapter);
        binding.recyclerViewSearch.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewSearch.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/sites/MCO/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        btnSearch();
    }

    private void btnSearch() {
        binding.btnSearch.setOnClickListener(view -> {
            botenerDatos(binding.etSignup1Confirmpassword.getText().toString());
        });
    }

    private void botenerDatos(String search) {
        SearchService service = retrofit.create(SearchService.class);
        Call<SearchResponse> searchResponseCall = service.find(search);

        searchResponseCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    listSearchAdapter.addListSearch(response.body().getResults());
                } else {
                    Log.e(TAG, "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e(TAG, "onResponse: " + t.getMessage());
            }
        });

    }

    @Override
    public void onItemClick(Search item) {
        Intent intent = new Intent(this, GarmentsDetailsActivityView.class);
        intent.putExtra("title", item.getTitle());
        intent.putExtra("price", item.getPrice());
        intent.putExtra("availableQuantity", item.getAvailableQuantity());
        intent.putExtra("soldQuantity", item.getSoldQuantity());
        intent.putExtra("thumbnail", item.getThumbnail());
        intent.putExtra("stateName", item.getAddress().getStateName());
        intent.putExtra("cityName", item.getAddress().getCityName());
        startActivity(intent);
    }
}

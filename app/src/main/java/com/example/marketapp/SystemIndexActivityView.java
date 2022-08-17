package com.example.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.marketapp.databinding.ActivitySystemIndexViewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class SystemIndexActivityView extends AppCompatActivity {

    private ActivitySystemIndexViewBinding binding;
    private SystemIndexAdapter systemIndexAdapter;
    private List<PopularModel> popularModelList;
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_index_view);

        binding = ActivitySystemIndexViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mService = getClientRetrofit();

        btnr();
        setAdapterPopular();
        manageResponseApi();
    }

    private void btnr() { // AÑADIR MVP
        binding.imgProfile.setOnClickListener(view -> {
            Intent intent = new Intent(SystemIndexActivityView.this, SystemAccActivityView.class);
            startActivity(intent);
        });
    }


    private void setAdapterPopular() {
        systemIndexAdapter = new SystemIndexAdapter(popularModelList);
        binding.rvPopularproduct.setAdapter(systemIndexAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        binding.rvPopularproduct.setLayoutManager(layoutManager);
    }

    public static class RetrofitClient {

        private static Retrofit retrofit = null;

        public static Retrofit getClient(String baseUrl) {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

    private static SOService getClientRetrofit() {

        return RetrofitClient.getClient("https://api.mercadolibre.com").create(SOService.class);
    }

    private interface SOService {

        @GET("/sites/MCO/search?category=MCO1574")
        Call<PopularResponse> getAnswers();

    }

    private void manageResponseApi() {
       // for (int i = 0; i < popularModelList.size(); i++) {
            mService.getAnswers().enqueue(new Callback<PopularResponse>() {
                @Override
                public void onResponse(@NonNull Call<PopularResponse> call, @NonNull Response<PopularResponse> response) {
                    if (response.isSuccessful()) {
                        systemIndexAdapter.updateAnswers(response.body().getPopularModelList());
                        Log.d("MainActivity", "posts loaded from API");
                    } else {
                        int statusCode = response.code();
                        // handle request errors depending on status code
                    }
                }

                @Override
                public void onFailure(Call<PopularResponse> call, Throwable t) {
                    Log.d("", "");
                }
            });
        //}
    }
}
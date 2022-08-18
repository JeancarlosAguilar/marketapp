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
  //  private SystemIndexAdapter systemIndexAdapter;
   // private List<PopularModel> popularModelList;
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySystemIndexViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("Data", "Hola2");

        mService = getClientRetrofit();

        btnr();
       // setAdapterPopular();
        manageResponseApi();
    }


    private void btnr() {
        //TODO AÑADIR MVP
        binding.imgProfile.setOnClickListener(view -> {
            Intent intent = new Intent(SystemIndexActivityView.this, SystemAccActivityView.class);
            startActivity(intent);
        });
    }


   /* private void setAdapterPopular() {
        systemIndexAdapter = new SystemIndexAdapter();
        binding.rvPopularproduct.setAdapter(systemIndexAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        binding.rvPopularproduct.setLayoutManager(layoutManager);
    }*/

    public static class RetrofitClient {

        private static Retrofit retrofit = null;

        public static Retrofit getClient(String baseUrl) {
            Log.e("Data", "Hola3");
            if (retrofit == null) {
                Log.e("Data", "Hola4");
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

    private static SOService getClientRetrofit() {

        Log.e("Data", "Hola5");
        return RetrofitClient.getClient("https://api.mercadolibre.com").create(SOService.class);
    }

    private interface SOService {
        @GET("/categories")
        Call<List<PopularResponse>> getAnswers();

        /*  @GET("/sites/MCO/categories")
        Call<List<PopularModel>> getAnswers();*/

    }

    private void manageResponseApi() {
        Log.e("Data", "Hola6");
       // for (int i = 0; i < popularModelList.size(); i++) {
            mService.getAnswers().enqueue(new Callback<List<PopularResponse>>() {
                @Override
                public void onResponse(@NonNull Call<List<PopularResponse>> call, @NonNull Response<List<PopularResponse>> response) {
                    if (response.isSuccessful()) {
                       // systemIndexAdapter.updateAnswers(response.body().getPopularModelList());
                        Log.e("Data", "Popular"+ response.body().get(2));
                        Log.e("Data", "Body"+ response.body());
                        Log.e("Data", "Response"+ response);
                        Log.e("Data", "Hola");
                    } else {
                        int statusCode = response.code();
                        // handle request errors depending on status code
                    }
                }

                @Override
                public void onFailure(Call<List<PopularResponse>> call, Throwable t) {
                    Log.e("Data", "Hola7" +call);
                    Log.e("Data", "Hola8" +t);
                }
            });
        //}
    }
}
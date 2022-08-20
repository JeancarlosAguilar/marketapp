package com.example.marketapp.api_files.seach;

import com.example.marketapp.api_files.garments.GarmentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SearchService { //TODO : Pendiente asignar parametros de busqueda
    @GET("search?category=MCO1430")
    Call<SearchResponse> getListSearch();
}

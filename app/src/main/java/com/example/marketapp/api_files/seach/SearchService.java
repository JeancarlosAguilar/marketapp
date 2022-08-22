package com.example.marketapp.api_files.seach;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchService {
    @GET("search")
    Call<SearchResponse> find(@Query("q") String search);
}

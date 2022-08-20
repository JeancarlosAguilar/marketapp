package com.example.marketapp.api_files.garments;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarmentsService {
    @GET("search?category=MCO1430")
    Call<GarmentsResponse> getListGarments();
}

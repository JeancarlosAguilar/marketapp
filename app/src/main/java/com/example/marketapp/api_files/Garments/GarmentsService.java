package com.example.marketapp.api_files.Garments;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarmentsService {
    @GET("search?category=MCO1430")
    Call<GarmentsResponse> getListGarments();
}

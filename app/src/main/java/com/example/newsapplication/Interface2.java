package com.example.newsapplication;

import com.example.newsapplication.parameter.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface2 {
    @GET("everything")
    Call<Headlines> geteverything(
            @Query("q") String q,
            @Query("from") String date,
            @Query("sortBy") String filter,
            @Query("apikey") String api_key

    );
}

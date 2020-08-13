package com.example.newsapplication;

import com.example.newsapplication.parameter.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  Interface3{
    @GET("top-headlines")
    Call<Headlines> getHeadlines(
            @Query("Country") String country,
            @Query("category") String category,
            @Query("apikey") String apikey

    );
}

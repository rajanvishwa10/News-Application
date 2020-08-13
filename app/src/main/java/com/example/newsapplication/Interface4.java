package com.example.newsapplication;

import com.example.newsapplication.parameter.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface4 {
    @GET("top-headlines")
    Call<Headlines> getHeadlines(
            @Query("sources") String source,
            @Query("apikey") String apikey

    );
}

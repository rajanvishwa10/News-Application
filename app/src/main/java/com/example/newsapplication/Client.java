package com.example.newsapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit;
    private static Client client;
    private Client(){
        retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized Client getInstance(){
        if(client == null){
            client = new Client();
        }
        return client;
    }
    public Interface getApi(){

        return retrofit.create(Interface.class);
    }
    public Interface2 getApi2(){
        return retrofit.create(Interface2.class);
    }
    public Interface3 getApi3(){
        return retrofit.create(Interface3.class);
    }
    public Interface4 getApi4(){
        return retrofit.create(Interface4.class);
    }
}

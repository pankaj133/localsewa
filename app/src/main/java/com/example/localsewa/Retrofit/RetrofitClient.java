package com.example.localsewa.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BaseUrl = "http://localsewa.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

}

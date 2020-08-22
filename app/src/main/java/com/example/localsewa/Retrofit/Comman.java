package com.example.localsewa.Retrofit;

public class Comman {

    public static Api getApi(){
        return  RetrofitClient.getRetrofit().create(Api.class);
    }
}

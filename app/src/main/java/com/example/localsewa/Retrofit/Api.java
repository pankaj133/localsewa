package com.example.localsewa.Retrofit;

import com.example.localsewa.models.Category;
import com.example.localsewa.models.bestsellermodels.BestSeller;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("category_api.php")
    Call<Category> getAllCategory();

    @POST("mobileapp_api/api/showPromotedList")
    Call<BestSeller> getAllbestSeller(@Body HashMap<String,String> abc);


}

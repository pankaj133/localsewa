package com.example.localsewa.Retrofit;

import com.example.localsewa.models.Category;
import com.example.localsewa.models.bestsellermodels.BestSeller;
import com.example.localsewa.models.searchmodels.SearchList;

import java.util.HashMap;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @GET("category_api.php")
    Call<Category> getAllCategory();

    @POST("mobileapp_api/api/showPromotedList")
    Call<BestSeller> getAllbestSeller(@Body HashMap<String,String> abc);

    @GET("search_api.php")
    Call<SearchList> getallsearchitems(@Query("id") String abc);


    @POST("mobileapp_api/api/showRestaurantsNew")
    Call<BestSeller> getallShopes(@Body HashMap<String,String> abc);


}

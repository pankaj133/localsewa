package com.example.localsewa.Retrofit;

import com.example.localsewa.models.Category;
import com.example.localsewa.models.account.SignInResponce;
import com.example.localsewa.models.account.SignInVerifyResponce;
import com.example.localsewa.models.account.SignUpVerifyResponce;
import com.example.localsewa.models.shopsbycategorymodels.RasturantListByCategory;
import com.example.localsewa.models.bestsellermodels.BestSeller;
import com.example.localsewa.models.searchmodels.SearchList;
import com.example.localsewa.models.account.SignUpResponce;

import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @GET("category_api.php")
    Call<Category> getAllCategory();

    @POST("mobileapp_api/api/showPromotedList")
    Call<BestSeller> getAllbestSeller(@Body HashMap<String,String> abc);

    @GET("search_api.php")
    Call<SearchList> getallsearchitems(@Query("id") String id);

   /* @POST("mobileapp_api/api/showRestaurantsNew")
    Call<BestSeller> getallShopes(@Body HashMap<String,String> abc);*/

    @GET("cat_list.php")
    Call<RasturantListByCategory> getShopsByCategory(@Query("cat_id") String cat_id
                           , @Query("city") String city, @Query("area") String area);


    @POST("signup_otp.php")
    @FormUrlEncoded
    Call<SignUpResponce> signup(@Field("mobile") String number,
                                @Field("firstname") String firstname,
                                @Field("device_toke") String device_token );



    @POST("signup_otp_verify.php")
    @FormUrlEncoded
    Call<SignUpVerifyResponce> signupverification(@Field("mobile") String mnumber,
                                                  @Field("otp") String otp);


    @POST("login_otp.php")
    @FormUrlEncoded
    Call<SignInResponce> signin(@Field("mobile") String mnumber,
                                @Field("device_token") String device_token);


    @POST("login_otp_verify.php")
    @FormUrlEncoded
    Call<SignInVerifyResponce>  signinverification(@Field("mobile") String mnumber,
                                                   @Field("otp") String otp);



}

package com.example.localsewa.Retrofit;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.shopsbycategorymodels.Msg;
import com.example.localsewa.models.shopsbycategorymodels.RasturantListByCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopsByCategoryRepo {

    private List<Msg> rasturant = new ArrayList<>();
    private MutableLiveData<List<Msg>> mutableLiveData = new MutableLiveData();

    private Context context;

    public ShopsByCategoryRepo(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Msg>> getShopsByCate(String cat_id){


        Comman.getApi().getShopsByCategory(cat_id,"10","1").enqueue(new Callback<RasturantListByCategory>() {
            @Override
            public void onResponse(Call<RasturantListByCategory> call, Response<RasturantListByCategory> response) {
                rasturant = response.body().getMsg();
                mutableLiveData.setValue(rasturant);
            }

            @Override
            public void onFailure(Call<RasturantListByCategory> call, Throwable t) {

            }
        });

        return mutableLiveData;

    }

}

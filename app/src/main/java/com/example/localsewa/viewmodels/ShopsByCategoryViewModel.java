package com.example.localsewa.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.localsewa.Retrofit.ShopsByCategoryRepo;
import com.example.localsewa.models.shopsbycategorymodels.Msg;

import java.util.List;

public class ShopsByCategoryViewModel extends AndroidViewModel {

    private ShopsByCategoryRepo shopsByCategoryRepo;
    public ShopsByCategoryViewModel(@NonNull Application application) {
        super(application);
        shopsByCategoryRepo = new ShopsByCategoryRepo(application);
    }
    public LiveData<List<Msg>> getbycategoryData(String cat_id){
        return shopsByCategoryRepo.getShopsByCate(cat_id);
    }
}

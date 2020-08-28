package com.example.localsewa.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.localsewa.Retrofit.AllShopsRepositry;
import com.example.localsewa.models.bestsellermodels.Msg;

import java.util.List;

public class AllShopesViewModel extends AndroidViewModel {


    private AllShopsRepositry allShopsRepositry;
    public AllShopesViewModel(@NonNull Application application) {
        super(application);
        allShopsRepositry  = new AllShopsRepositry(application);
    }
    public LiveData<List<Msg>> getAllShopsbyviewmodel(){
        return allShopsRepositry.getAllshops();
    }
}

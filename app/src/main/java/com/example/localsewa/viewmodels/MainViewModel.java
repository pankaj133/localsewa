package com.example.localsewa.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.localsewa.Retrofit.BestSellerRepository;
import com.example.localsewa.Retrofit.CategoryRepository;
import com.example.localsewa.models.Message;
import com.example.localsewa.models.bestsellermodels.Msg;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private CategoryRepository categoryRepository;
    private BestSellerRepository bestSellerRepository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        categoryRepository = new CategoryRepository(application);
        bestSellerRepository = new BestSellerRepository(application);
    }

    public LiveData<List<Message>> getAllcategory(){
        return categoryRepository.getCategory();
    }

    public LiveData<List<Msg>> getAllbestSeller(){
        return bestSellerRepository.getbestseller();
    }
}

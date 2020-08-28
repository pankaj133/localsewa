package com.example.localsewa.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.localsewa.Retrofit.SearchRepository;
import com.example.localsewa.models.searchmodels.Msg;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {


    private SearchRepository searchRepository;
    public SearchViewModel(@NonNull Application application) {
        super(application);
        searchRepository = new SearchRepository(application);
    }

    public LiveData<List<Msg>> getsearcheddata(String product){
        return searchRepository.getallserachitems(product);
    }
}

package com.example.localsewa.viewmodels;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.localsewa.Retrofit.SignInRepo;
import com.example.localsewa.views.SignIn;

public class SignInViewModel extends AndroidViewModel {

    public String mnumber;
    private Context context;

    private SignInRepo msignInRepo;

    public SignInViewModel(@NonNull Application application) {
        super(application);
        context = application;
        msignInRepo = new SignInRepo(application);
    }
    public boolean  onclick(){
      return !TextUtils.isEmpty(mnumber) && mnumber.length() == 10;
    }



    public LiveData<String> getsignin(String mobilenumber){
        return msignInRepo.getsignin(mobilenumber);
    }


}

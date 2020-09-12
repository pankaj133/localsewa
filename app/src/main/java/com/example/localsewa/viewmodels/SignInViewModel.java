package com.example.localsewa.viewmodels;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.localsewa.Retrofit.SignInRepo;
import com.example.localsewa.models.account.SignInMsg;
import com.example.localsewa.views.SignIn;

public class SignInViewModel extends AndroidViewModel {

    public String mnumber;
    public String signinotp;

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

    public LiveData<String> getsignin(String mobilenumber,String token){
        return msignInRepo.getsignin(mobilenumber,token);
    }

    public LiveData<SignInMsg> logininverification(String number,String otp){
        return msignInRepo.logininverification(number,otp);
    }


}

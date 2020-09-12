package com.example.localsewa.viewmodels;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.Retrofit.SignUpRepo;
import com.example.localsewa.models.account.SignUpMsg;


public class SignUpViewModel extends AndroidViewModel {

    public String mnumber;
    public String fname;
    public String lname;

    public String signupotop;


    private Context context;

    private SignUpRepo signUpRepo ;

    public SignUpViewModel(@NonNull Application application) {
        super(application);
        context = application;
        signUpRepo = new SignUpRepo(application);
    }


    public boolean  onclick() {

        return (!TextUtils.isEmpty(mnumber) && mnumber.length() == 10)
                && !TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname);

    }

    public LiveData<String> getsignup(String mnumber,String fname,String code){

        return signUpRepo.getsignup(mnumber,fname,code);
    }

    public LiveData<SignUpMsg> signupverification(String m_number,String otp){
        return signUpRepo.setSingupverification(m_number,otp);
    }



}

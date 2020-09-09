package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.account.SignInResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepo {

    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    private String respo;

    private Context context;

    public SignInRepo(Context context) {
        this.context = context;
    }


    public  MutableLiveData<String> getsignin(String mnnumber){

        Comman.getApi().signin(mnnumber).enqueue(new Callback<SignInResponce>() {
            @Override
            public void onResponse(Call<SignInResponce> call, Response<SignInResponce> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, ""+response.isSuccessful(), Toast.LENGTH_SHORT).show();
                }
                respo = response.body().getMsg();
                mutableLiveData.setValue(respo);
            }

            @Override
            public void onFailure(Call<SignInResponce> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}

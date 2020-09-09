package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.account.SignUpResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepo {

    private Context context;

    public SignUpRepo(Context context) {
        this.context = context;
    }

    private MutableLiveData<String> singup  = new MutableLiveData<>();

    private String sucess;

    public MutableLiveData<String> getsignup(String num,String fn,String dt){
        Comman.getApi().signup(num,fn,dt).enqueue(new Callback<SignUpResponce>() {
            @Override
            public void onResponse(Call<SignUpResponce> call, Response<SignUpResponce> response) {

                if(!response.isSuccessful()){

                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                }
                sucess = response.body().getScussesmsg();
                singup.setValue(sucess); }
            @Override
            public void onFailure(Call<SignUpResponce> call, Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return singup;
    }
}

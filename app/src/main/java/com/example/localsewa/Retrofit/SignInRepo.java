package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.account.SignInMsg;
import com.example.localsewa.models.account.SignInResponce;
import com.example.localsewa.models.account.SignInVerifyResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepo {

    private Context context;

    public SignInRepo(Context context) {
        this.context = context;
    }


    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
    private String respo;


    private MutableLiveData<SignInMsg> signInMsgMutableLiveData = new MutableLiveData<>();
    private SignInMsg signInMsg;



    public  MutableLiveData<String> getsignin(String mnnumber,String token){

        Comman.getApi().signin(mnnumber,token).enqueue(new Callback<SignInResponce>() {
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


    public MutableLiveData<SignInMsg> logininverification(String mobile_numbwer,String otp){

        Comman.getApi().signinverification(mobile_numbwer,otp).enqueue(new Callback<SignInVerifyResponce>() {
            @Override
            public void onResponse(Call<SignInVerifyResponce> call, Response<SignInVerifyResponce> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }

                signInMsg =  response.body().getMsg();
                signInMsgMutableLiveData.setValue(signInMsg);

            }

            @Override
            public void onFailure(Call<SignInVerifyResponce> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return signInMsgMutableLiveData;
    }
}

package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.account.SignUpMsg;
import com.example.localsewa.models.account.SignUpResponce;
import com.example.localsewa.models.account.SignUpVerifyResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepo {

    private Context context;

    public SignUpRepo(Context context) {
        this.context = context;
    }

    //start of signup
    private MutableLiveData<String> singup  = new MutableLiveData<>();
    private String sucess;
    //end of signup


    private MutableLiveData<SignUpMsg> signUpMsgMutableLiveData = new MutableLiveData<>();

    private SignUpMsg signUpMsg;

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


    public MutableLiveData<SignUpMsg> setSingupverification(String number, String otp){

        Comman.getApi().signupverification(number,otp).enqueue(new Callback<SignUpVerifyResponce>() {
            @Override
            public void onResponse(Call<SignUpVerifyResponce> call, Response<SignUpVerifyResponce> response) {

                if(!response.isSuccessful()){

                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
                signUpMsg = response.body().getSignUpMsg();
                signUpMsgMutableLiveData.setValue(signUpMsg);
            }

            @Override
            public void onFailure(Call<SignUpVerifyResponce> call, Throwable t) {


                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return signUpMsgMutableLiveData;

    }
}

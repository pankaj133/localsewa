package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.localsewa.models.bestsellermodels.BestSeller;
import com.example.localsewa.models.bestsellermodels.Msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllShopsRepositry {

    private HashMap<String,String> hashMap = new HashMap<>();
    private List<Msg> msgs = new ArrayList<>();

    private MutableLiveData<List<Msg>> mutableLiveDatamsg = new MutableLiveData<>();

    private Context context;

    public AllShopsRepositry(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Msg>> getAllshops(){

        hashMap.put("lat","28.58466");
        hashMap.put("long","77.3599159");
        hashMap.put("current_time","2020-05-24 15:26:31");
        hashMap.put("user_id","691");
        hashMap.put("loc","0");

        Comman.getApi().getallShopes(hashMap).enqueue(new Callback<BestSeller>() {
            @Override
            public void onResponse(Call<BestSeller> call, Response<BestSeller> response) {
                msgs = response.body().getMsg();
                mutableLiveDatamsg.setValue(msgs);
            }

            @Override
            public void onFailure(Call<BestSeller> call, Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveDatamsg;
    }
}

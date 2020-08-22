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

public class BestSellerRepository {

    private HashMap<String,String> hashMap = new HashMap<>();
    private Context context;

    private List<Msg> bestSellers = new ArrayList<>();
    private MutableLiveData<List<Msg>> mutablebestseller = new MutableLiveData<>();

    public BestSellerRepository(Context context) {
        this.context = context;
    }

   /* {"lat":"28.58466","long":"77.3599159","current_time":"2020-05-24 15:26:31","user_id":"691","loc":"0"}*/

    public MutableLiveData<List<Msg>> getbestseller(){

        hashMap.put("lat","28.58466");
        hashMap.put("long","77.3599159");
        hashMap.put("current_time","2020-05-24 15:26:31");
        hashMap.put("user_id","691");
        hashMap.put("loc","0");

        Comman.getApi().getAllbestSeller(hashMap).enqueue(new Callback<BestSeller>() {
            @Override
            public void onResponse(Call<BestSeller> call, Response<BestSeller> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
                bestSellers = response.body().getMsg();
                mutablebestseller.setValue(bestSellers);
            }

            @Override
            public void onFailure(Call<BestSeller> call, Throwable t) {

            }
        });
    return mutablebestseller;
    }
}

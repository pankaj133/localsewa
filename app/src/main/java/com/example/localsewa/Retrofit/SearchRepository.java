package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.example.localsewa.models.searchmodels.SearchList;
import com.example.localsewa.models.searchmodels.SearchMsg;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepository {

    private List<SearchMsg> searchlist = new ArrayList<>();
    private MutableLiveData<List<SearchMsg>> mutableLiveData = new MutableLiveData<>();

    private Context context;

    public SearchRepository(Context context) {
        this.context = context;
    }


    public  MutableLiveData<List<SearchMsg>> getallserachitems(String item){

        Comman.getApi().getallsearchitems(item).enqueue(new Callback<SearchList>() {
            @Override
            public void onResponse(Call<SearchList> call, Response<SearchList> response) {

                if(!response.isSuccessful()){

                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
                searchlist = response.body().getMsg();
                mutableLiveData.setValue(searchlist);

            }

            @Override
            public void onFailure(Call<SearchList> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}

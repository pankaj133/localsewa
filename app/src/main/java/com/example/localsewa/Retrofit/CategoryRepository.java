package com.example.localsewa.Retrofit;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.example.localsewa.models.Category;
import com.example.localsewa.models.Message;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private List<Message> msgList = new ArrayList<>();
    private MutableLiveData<List<Message>> mutableLiveData  = new MutableLiveData<>();

    private  Context context;

    public CategoryRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Message>> getCategory() {

        Comman.getApi().getAllCategory().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
                msgList =  response.body().getMsgList();
                mutableLiveData.setValue(msgList);
            }
            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return  mutableLiveData;
    }
}

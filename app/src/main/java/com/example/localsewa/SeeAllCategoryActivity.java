package com.example.localsewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.localsewa.adapters.CategoryAdapter;
import com.example.localsewa.databinding.ActivitySeeAllCategoryBinding;
import com.example.localsewa.models.Message;
import com.example.localsewa.viewmodels.MainViewHolder;

import java.util.List;

public class SeeAllCategoryActivity extends AppCompatActivity {

    private ActivitySeeAllCategoryBinding activitySeeAllCategoryBinding;
    private RecyclerView seellrecycelerview;
    private CategoryAdapter categoryAdapter;
    private MainViewHolder mainViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySeeAllCategoryBinding = DataBindingUtil.setContentView(this,R.layout.activity_see_all_category);

        seellrecycelerview = activitySeeAllCategoryBinding.seeallrecyclerview;
        seellrecycelerview.setHasFixedSize(true);
        seellrecycelerview.setLayoutManager(new GridLayoutManager(this,3));


        mainViewHolder = new ViewModelProvider(this).get(MainViewHolder.class);
        categoryAdapter = new CategoryAdapter(this);
        seellrecycelerview.setAdapter(categoryAdapter);
        getdata();

    }

    private void getdata() {

        mainViewHolder.getAllcategory().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(List<Message> msgs) {
                categoryAdapter.data(msgs);
            }
        });
    }
}
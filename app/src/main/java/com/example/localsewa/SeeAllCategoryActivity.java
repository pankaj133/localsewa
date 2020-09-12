package com.example.localsewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.localsewa.adapters.CategoryAdapter;
import com.example.localsewa.databinding.ActivitySeeAllCategoryBinding;
import com.example.localsewa.viewmodels.MainViewModel;

public class SeeAllCategoryActivity extends AppCompatActivity {

    private ActivitySeeAllCategoryBinding activitySeeAllCategoryBinding;
    private RecyclerView seellrecycelerview;
    private CategoryAdapter categoryAdapter;
    private MainViewModel mainViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySeeAllCategoryBinding = DataBindingUtil.setContentView(this,R.layout.activity_see_all_category);

        activitySeeAllCategoryBinding.backbutton.setOnClickListener(view -> {
            onBackPressed();
        });

        seellrecycelerview = activitySeeAllCategoryBinding.seeallrecyclerview;
        seellrecycelerview.setHasFixedSize(true);
        seellrecycelerview.setLayoutManager(new GridLayoutManager(this,3));


        mainViewHolder = new ViewModelProvider(this).get(MainViewModel.class);
        categoryAdapter = new CategoryAdapter(this);
        seellrecycelerview.setAdapter(categoryAdapter);
        getdata();

    }

    private void getdata() {

        mainViewHolder.getAllcategory().observe(this, messages -> {
            categoryAdapter.data(messages);
        });
    }
}
package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.localsewa.R;
import com.example.localsewa.adapters.AllShopsAdapter;
import com.example.localsewa.adapters.BestSellerAdapter;
import com.example.localsewa.databinding.ActivityAllShopsBinding;
import com.example.localsewa.databinding.ActivityMainBinding;
import com.example.localsewa.databinding.ActivitySeeAllCategoryBinding;
import com.example.localsewa.models.bestsellermodels.Msg;
import com.example.localsewa.viewmodels.AllShopesViewModel;

import java.util.List;

public class AllShops extends AppCompatActivity {

    private ActivityAllShopsBinding activityAllShops;
    private RecyclerView recyclerView;

    private AllShopesViewModel allShops;

    private AllShopsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllShops = DataBindingUtil.setContentView(this, R.layout.activity_all_shops);

        //toolbar
        activityAllShops.toolbarallshop.setTitle("");
        setSupportActionBar(activityAllShops.toolbarallshop);

        allShops =new  ViewModelProvider(this).get(AllShopesViewModel.class);

        //recyeclerview

        adapter = new AllShopsAdapter(this);
        recyclerView = activityAllShops.allshoprecycelrview;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        allShops.getAllShopsbyviewmodel().observe(this, new Observer<List<Msg>>() {
            @Override
            public void onChanged(List<Msg> msgs) {
                adapter.bestsller(msgs);
            }
        });

    }
}
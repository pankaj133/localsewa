package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.localsewa.R;
import com.example.localsewa.adapters.AllBestSellerAdapter;
import com.example.localsewa.databinding.ActivityAllShopsBinding;
import com.example.localsewa.viewmodels.MainViewModel;

public class AllShopsSellers extends AppCompatActivity {

    private ActivityAllShopsBinding activityAllShops;
    private RecyclerView recyclerView;

    private MainViewModel allShops;

    private AllBestSellerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllShops = DataBindingUtil.setContentView(this, R.layout.activity_all_shops);

        //toolbar
        activityAllShops.toolbarallshop.setTitle("");
        setSupportActionBar(activityAllShops.toolbarallshop);


        //viewmodel instance of mainviewmodel
        allShops = new  ViewModelProvider(this).get(MainViewModel.class);

        //recyeclerview
        adapter = new AllBestSellerAdapter(this);
        recyclerView = activityAllShops.allshoprecycelrview;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        allShops.getAllbestSeller().observe(this,msgs -> {

            adapter.bestsller(msgs);

        });



    }
}
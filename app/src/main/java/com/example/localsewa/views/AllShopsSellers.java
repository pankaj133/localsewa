package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.localsewa.R;
import com.example.localsewa.adapters.AllBestSellerAdapter;
import com.example.localsewa.databinding.ActivityAllShopsBinding;
import com.example.localsewa.models.bestsellermodels.Msg;
import com.example.localsewa.viewmodels.MainViewHolder;

import java.util.List;

public class AllShopsSellers extends AppCompatActivity {

    private ActivityAllShopsBinding activityAllShops;
    private RecyclerView recyclerView;

    private MainViewHolder allShops;

    private AllBestSellerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllShops = DataBindingUtil.setContentView(this, R.layout.activity_all_shops);

        //toolbar
        activityAllShops.toolbarallshop.setTitle("");
        setSupportActionBar(activityAllShops.toolbarallshop);



        allShops =new  ViewModelProvider(this).get(MainViewHolder.class);

        //recyeclerview

        adapter = new AllBestSellerAdapter(this);
        recyclerView = activityAllShops.allshoprecycelrview;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        allShops.getAllbestSeller().observe(this, new Observer<List<Msg>>() {
            @Override
            public void onChanged(List<Msg> msgs) {
                adapter.bestsller(msgs);
            }
        });

    }
}
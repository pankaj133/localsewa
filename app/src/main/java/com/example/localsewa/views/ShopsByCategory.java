package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.localsewa.MainActivity;
import com.example.localsewa.R;
import com.example.localsewa.adapters.ShopsByCategoryAdapter;
import com.example.localsewa.databinding.ActivityShopsByCategoryBinding;
import com.example.localsewa.models.shopsbycategorymodels.Msg;
import com.example.localsewa.viewmodels.ShopsByCategoryViewModel;

import java.util.List;

public class ShopsByCategory extends AppCompatActivity {

    private ShopsByCategoryViewModel shopsByCategoryViewModel;
    private RecyclerView recyclerView;
    private ActivityShopsByCategoryBinding activityShopsByCategoryBinding;
    private ShopsByCategoryAdapter shops;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityShopsByCategoryBinding = DataBindingUtil.setContentView(this, R.layout.activity_shops_by_category);

        toolbar = activityShopsByCategoryBinding.toolbat;
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        String cat_id = getIntent().getStringExtra("cat_id");
        String type = getIntent().getStringExtra("name");
        activityShopsByCategoryBinding.type.setText(type);


        shops = new ShopsByCategoryAdapter(this);

        shopsByCategoryViewModel = new ViewModelProvider(this).get(ShopsByCategoryViewModel.class);

        activityShopsByCategoryBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });


        recyclerView = activityShopsByCategoryBinding.recy;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(shops);

/*
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
*/

        shopsByCategoryViewModel.getbycategoryData(cat_id).observe(this, new Observer<List<Msg>>() {
            @Override
            public void onChanged(List<Msg> msgs) {
                shops.shopsdatabycat(msgs);
            }
        });
    }

}
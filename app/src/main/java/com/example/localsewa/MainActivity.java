package com.example.localsewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import com.example.localsewa.databinding.ActivityMainBinding;
import com.example.localsewa.fragments.CartFragment;
import com.example.localsewa.fragments.LocalSewaFragment;
import com.example.localsewa.fragments.OfferFragment;
import com.example.localsewa.fragments.OrderFragmet;
import com.example.localsewa.fragments.ProfileFragment;
import com.example.localsewa.views.AllShopsSellers;
import com.example.localsewa.views.SearchActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //setup  first  default fragment for start
         getSupportFragmentManager().
                beginTransaction().replace(R.id.fragment_container_view_tag,
                new LocalSewaFragment()).commit();

        // call setup tabbar method
        tabbar(); }
    private void tabbar() {

        tabs = activityMainBinding.tablayout;
        tabs.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#B30822"), PorterDuff.Mode.SRC_IN);


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            Fragment fragment = new LocalSewaFragment();

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.getIcon().setColorFilter(Color.parseColor("#B30822"), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()) {

                    case 0:
                        fragment = new LocalSewaFragment();
                        break;
                    case 1:
                        fragment = new OfferFragment();
                        break;
                    case 2:
                        fragment = new CartFragment();
                        break;
                    case 3:
                        fragment = new OrderFragmet();
                        break;
                    case 4:
                        fragment = new ProfileFragment();
                        break; }
                FragmentManager fm = getSupportFragmentManager();

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container_view_tag, fragment);
                ft.commit(); }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                tab.getIcon().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
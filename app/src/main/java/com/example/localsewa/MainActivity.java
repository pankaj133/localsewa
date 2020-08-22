package com.example.localsewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.localsewa.adapters.BestSellerAdapter;
import com.example.localsewa.adapters.CategoryAdapter;
import com.example.localsewa.adapters.ViewPagerAdapter;
import com.example.localsewa.databinding.ActivityMainBinding;
import com.example.localsewa.models.Message;
import com.example.localsewa.viewmodels.MainViewHolder;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    //viewpager varivles start
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView[] dots;
    private Handler handler;
    private Timer timer;
    private int CURRENT_PAGE = 0;
    // viewpager variables end


    //category variables start
    private MainViewHolder mainViewHolder;
    private RecyclerView cat_recyclerView;
    private CategoryAdapter customAdapter;
    // category variables end


    private RecyclerView bestSeller_recyclerview;

    private BestSellerAdapter bestSellerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        // toolbar setup start
        activityMainBinding.toolbar.setTitle("");
        setSupportActionBar(activityMainBinding.toolbar);
        // toolbar setup end


        //viepager method call
        viewpagersetup();


        //viewmodel
        mainViewHolder = ViewModelProviders.of(this).get(MainViewHolder.class);


        //category recyclerview
        activityMainBinding.seeall.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        cat_recyclerView = activityMainBinding.categoryrecyclerview;
        cat_recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        cat_recyclerView.setHasFixedSize(true);


        customAdapter = new CategoryAdapter(this);
        cat_recyclerView.setAdapter(customAdapter);
        getcategory();

        activityMainBinding.seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SeeAllCategoryActivity.class);
                startActivity(intent);

            }
        });

        // category end


        // bestSeller start

        bestSeller_recyclerview = activityMainBinding.bestsellerrecyclerview;
        bestSeller_recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        bestSeller_recyclerview.setHasFixedSize(true);

        bestSellerAdapter = new BestSellerAdapter(this);
        bestSeller_recyclerview.setAdapter(bestSellerAdapter);
        getallbestSellers();





    }

    private void getallbestSellers() {

        mainViewHolder.getAllbestSeller().observe(this, new Observer<List<com.example.localsewa.models.bestsellermodels.Msg>>() {
            @Override
            public void onChanged(List<com.example.localsewa.models.bestsellermodels.Msg> msgs) {
                bestSellerAdapter.bestsller(msgs);
            }
        });
    }


    private void getcategory() {
        mainViewHolder.getAllcategory().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(List<Message> msgs) {
                customAdapter.data(msgs);
            }
        });
    }



    //viewpagersetup method
    private void viewpagersetup() {

        handler = new Handler();
        viewPagerAdapter = new ViewPagerAdapter(this);
        activityMainBinding.viewpagerid.setAdapter(viewPagerAdapter);
        final int dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        // this for loop put the indicators at view pager
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);

            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_not_active_image));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(16, 0, 16, 0);
            activityMainBinding.dotslayout.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_active_image));


        // this is resposible for automatic change of viewpager images
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (CURRENT_PAGE == dotscount) {
                    CURRENT_PAGE = 0;
                }
                activityMainBinding.viewpagerid.setCurrentItem(CURRENT_PAGE++, true);
            }
        };

        timer = new Timer();// it will create the thread
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 4000);


        // this is resposible for changing the indicator dots at viewpager
        activityMainBinding.viewpagerid.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_not_active_image));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_active_image));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
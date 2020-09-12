package com.example.localsewa.fragments;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.localsewa.R;
import com.example.localsewa.SeeAllCategoryActivity;
import com.example.localsewa.adapters.BestSellerAdapter;
import com.example.localsewa.adapters.CategoryAdapter;
import com.example.localsewa.adapters.ViewPagerAdapter;
import com.example.localsewa.databinding.FragmentLocalSewaBinding;
import com.example.localsewa.utiles.ConnectionCheckup;
import com.example.localsewa.viewmodels.MainViewModel;
import com.example.localsewa.views.AllShopsSellers;
import com.example.localsewa.views.SearchActivity;
import java.util.Timer;
import java.util.TimerTask;


public class LocalSewaFragment extends Fragment {

    private FragmentLocalSewaBinding fragment;

    //viewpager varivles start
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView[] dots;
    private Handler handler;
    private Timer timer;
    private int CURRENT_PAGE = 0;
    // viewpager variables end

    //context start
 /*   private Context context;*/
    private View view;
    //context end

    private  AppCompatActivity appCompatActivity;

    private MainViewModel mainViewHolder;
    private RecyclerView category_recyclerview;
    private CategoryAdapter catAdapter;


    //bestseller
    private RecyclerView bestseller_recyclerView;
    private BestSellerAdapter bestSellerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //activity
        appCompatActivity = (AppCompatActivity) getActivity();

        fragment = DataBindingUtil.inflate(LayoutInflater.from(appCompatActivity),
                R.layout.fragment_local_sewa, container, false);


        //istance
        mainViewHolder = new ViewModelProvider(this).get(MainViewModel.class);

        // toolbar setup start
        fragment.tool.toolbar.setTitle("");

        appCompatActivity.setSupportActionBar(fragment.tool.toolbar);
        // toolbar setup end

        //viewpagercall
        viewpagersetup();

        fragment.nointernet.tryagain.setOnClickListener( view1 -> {
            getallbestSellers();
            getcategory();
        });

        //under in sell all
        fragment.seeall.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        fragment.allbestsellers.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);


        //category work
        category_recyclerview = fragment.categoryrecyclerview;
        category_recyclerview.setHasFixedSize(true);
        category_recyclerview.setLayoutManager(new
                LinearLayoutManager(appCompatActivity,LinearLayoutManager.HORIZONTAL,false));
        catAdapter = new CategoryAdapter(appCompatActivity);
        category_recyclerview.setAdapter(catAdapter);
        getcategory();


        fragment.seeall.setOnClickListener(view1 -> {
            Intent categortintent  = new Intent(appCompatActivity, SeeAllCategoryActivity.class);
            startActivity(categortintent); });

        //category end


        //start bestsellerRecyclerView
        bestseller_recyclerView = fragment.bestsellerrecyclerview;
        bestseller_recyclerView.setNestedScrollingEnabled(false);
        bestseller_recyclerView.setLayoutManager(new GridLayoutManager(appCompatActivity,2));
        bestseller_recyclerView.setHasFixedSize(true);

        bestSellerAdapter = new BestSellerAdapter(appCompatActivity);
        bestseller_recyclerView.setAdapter(bestSellerAdapter);

        getallbestSellers();

        fragment.allbestsellers.setOnClickListener(view1 -> {
            Intent bestsellerintent = new Intent(appCompatActivity, AllShopsSellers.class);
            startActivity(bestsellerintent);

        });

        //bestseller end


        fragment.tool.searchimageview.setOnClickListener(view1 -> {
            Intent  searchintent = new Intent(appCompatActivity, SearchActivity.class);
            startActivity(searchintent);
        });


        checkinternet();

        return fragment.getRoot(); }

    //observe bestseller
    private void getallbestSellers() {
        checkinternet();

        mainViewHolder.getAllbestSeller().observe(appCompatActivity,msgs -> {
            bestSellerAdapter.bestsller(msgs);
            fragment.loadinglayout.loading.setVisibility(View.GONE);
            fragment.content.setVisibility(View.VISIBLE);


        }); }

    //observ category
    private void getcategory(){
        checkinternet();

        mainViewHolder.getAllcategory().observe(appCompatActivity,messages -> {
            catAdapter.data(messages);
            fragment.loadinglayout.loading.setVisibility(View.GONE);
            fragment.content.setVisibility(View.VISIBLE); });

    }

    //viewpagersetup method
    private void viewpagersetup() {

        handler = new Handler();
        viewPagerAdapter = new ViewPagerAdapter(appCompatActivity);
        fragment.viewpagerid.setAdapter(viewPagerAdapter);
        final int dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        // this for loop put the indicators at view pager
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(appCompatActivity);

            dots[i].setImageDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.slider_not_active_image));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(16, 0, 16, 0);
            fragment.dotslayout.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.slider_active_image));


        // this is resposible for automatic change of viewpager images
        final Runnable update = () -> {
            if (CURRENT_PAGE == dotscount) {
                CURRENT_PAGE = 0;
            }
            fragment.viewpagerid.setCurrentItem(CURRENT_PAGE++, true);

        };

        timer = new Timer();// it will create the thread
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 4000);


        // this is resposible for changing the indicator dots at viewpager
        fragment.viewpagerid.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.slider_not_active_image));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.slider_active_image));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //function for internetcheing
    public void checkinternet() {
        if (!ConnectionCheckup.check(appCompatActivity)) {
            fragment.content.setVisibility(View.GONE);
            fragment.nointernet.notNet.setVisibility(View.VISIBLE);
            return;
        } else {
            fragment.nointernet.notNet.setVisibility(View.GONE);
            fragment.loadinglayout.loading.setVisibility(View.VISIBLE);
            fragment.content.setVisibility(View.GONE);
        } }

}
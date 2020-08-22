package com.example.localsewa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.localsewa.R;
import com.example.localsewa.databinding.ActivityMainBinding;
import com.example.localsewa.databinding.ViewPagerCustomLayoutBinding;

public class ViewPagerAdapter extends PagerAdapter {

    int[] image = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

    private Context context;
    private LayoutInflater inflater ;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewPagerCustomLayoutBinding viewPagerCustomLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.view_pager_custom_layout,container,false);
        viewPagerCustomLayoutBinding.viewpagerimage.setImageResource(image[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(viewPagerCustomLayoutBinding.getRoot(),0);

       View view =  viewPagerCustomLayoutBinding.getRoot();

        return viewPagerCustomLayoutBinding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}

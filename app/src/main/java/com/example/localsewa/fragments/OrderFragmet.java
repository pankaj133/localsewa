package com.example.localsewa.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.localsewa.R;
import com.example.localsewa.databinding.FragmentOrderFragmetBinding;

public class OrderFragmet extends Fragment {


    private AppCompatActivity context;
    private FragmentOrderFragmetBinding fragmentOrderFragmetBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = (AppCompatActivity) getActivity();
        fragmentOrderFragmetBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.fragment_order_fragmet, container, false);


        return fragmentOrderFragmetBinding.getRoot();
    }
}
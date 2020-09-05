package com.example.localsewa.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.localsewa.R;
import com.example.localsewa.databinding.FragmentOfferBinding;

public class OfferFragment extends Fragment {


    private AppCompatActivity context;
    private FragmentOfferBinding offerBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = (AppCompatActivity) getActivity();
        offerBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.fragment_offer,container,false);
        return offerBinding.getRoot();
    }
}
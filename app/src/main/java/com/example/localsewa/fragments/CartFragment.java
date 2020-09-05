package com.example.localsewa.fragments;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.localsewa.R;
import com.example.localsewa.databinding.FragmentCartBinding;
import com.example.localsewa.databinding.FragmentOfferBinding;

public class CartFragment extends Fragment {



    private AppCompatActivity context;
    private FragmentCartBinding cartBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = (AppCompatActivity) getActivity();

        cartBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),R.layout.fragment_cart,container,false);

        return cartBinding.getRoot();
    }
}
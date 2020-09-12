package com.example.localsewa.fragments;



import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.localsewa.R;
import com.example.localsewa.databinding.FragmentProfileBinding;
import com.example.localsewa.views.SignIn;
import com.example.localsewa.views.SignUp;


public class ProfileFragment extends Fragment {


    private AppCompatActivity context;
    private FragmentProfileBinding profileBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = (AppCompatActivity) getActivity();
        profileBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.fragment_profile, container, false);

        profileBinding.profiletoolbar.setTitle("");
        context.setSupportActionBar(profileBinding.profiletoolbar);

        profileBinding.signinlayout.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(),SignIn.class);
            startActivity(intent);
        });

        profileBinding.signuplayout.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), SignUp.class);
            startActivity(intent);
        });

        profileBinding.accountinfo.setVisibility(View.GONE);
        profileBinding.addressinfo.setVisibility(View.GONE);
        profileBinding.logoutlayout.setVisibility(View.GONE);


        return profileBinding.getRoot();
    }






}
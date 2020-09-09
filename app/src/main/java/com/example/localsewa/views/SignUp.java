package com.example.localsewa.views;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.localsewa.R;
import com.example.localsewa.databinding.ActivitySignUpBinding;
import com.example.localsewa.databinding.AlterdailoguiforsignupBinding;
import com.example.localsewa.viewmodels.SignUpViewModel;

public class SignUp extends AppCompatActivity {

    private ActivitySignUpBinding SignUpBinding;
    private SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        //toolbar setup
        SignUpBinding.signuptoolbar.setTitle("");
        setSupportActionBar(SignUpBinding.signuptoolbar);

        //back to privous activity
        SignUpBinding.back.setOnClickListener(view -> {
            onBackPressed();
        });

        //viewmodel instrance
        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        //binding of viewmodel to layout
        SignUpBinding.setSignup(signUpViewModel);
        SignUpBinding.executePendingBindings();


        SignUpBinding.signupbutton.setOnClickListener((view) -> {
            if (signUpViewModel.onclick()) {

                String mobilenumber = signUpViewModel.mnumber;
                String fname = signUpViewModel.fname;
                String token = "hell";
                showdailog(mobilenumber, fname, token);

            } else {
                Toast.makeText(this, "Please fill deatil carefully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //dialog of signup
    private void showdailog(String mumber, String fname, String token) {

        signUpViewModel.getsignup(mumber, fname, token).observe(this, s -> {

            Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show(); });


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlterdailoguiforsignupBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.alterdailoguiforsignup, null, false);
        View view = binding.getRoot();
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        binding.backbutton.setOnClickListener(view1 -> {
            alertDialog.dismiss();
        });
        binding.verify.setOnClickListener(view1 -> {
            Toast.makeText(this, "verify", Toast.LENGTH_SHORT).show();
        });
        alertDialog.show();

    }

}
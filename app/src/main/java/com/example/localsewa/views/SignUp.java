package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.localsewa.R;
import com.example.localsewa.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {

    private ActivitySignUpBinding activitySignUpBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        activitySignUpBinding.signuptoolbar.setTitle("");
        setSupportActionBar(activitySignUpBinding.signuptoolbar);

        activitySignUpBinding.back.setOnClickListener(view -> {
           onBackPressed();
        });

}
}
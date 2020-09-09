package com.example.localsewa.views;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.localsewa.R;
import com.example.localsewa.databinding.ActivitySignInBinding;
import com.example.localsewa.databinding.AlterdailoguiforsigninBinding;
import com.example.localsewa.viewmodels.SignInViewModel;

public class SignIn extends AppCompatActivity {

    private ActivitySignInBinding SignInBinding;
    private SignInViewModel msignInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        //toolbar
        SignInBinding.signintoolbar.setTitle("");
        setSupportActionBar(SignInBinding.signintoolbar);
        SignInBinding.back.setOnClickListener(view -> {
            onBackPressed();
        });
        //toolbar

        //viewmodel instrance
        msignInViewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        //it is listner to back to the  signup activity
        SignInBinding.tosignup.setOnClickListener(view -> {

            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });

        //viewmodel of signin
        SignInBinding.setSignin(msignInViewModel);
        SignInBinding.executePendingBindings();

        //login button for
        SignInBinding.login.setOnClickListener((view) -> {
            if (msignInViewModel.onclick()) {
                String number = msignInViewModel.mnumber;
                showdailog(number);
            } else {
                Toast.makeText(this, "hvjhvj", Toast.LENGTH_SHORT).show();
            }
        }); }
    //dialog method
    private void showdailog(String num) {

        msignInViewModel.getsignin(num).observe(this, s -> {
            Toast.makeText(this, "" + s, Toast.LENGTH_LONG).show();

        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlterdailoguiforsigninBinding alert = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.alterdailoguiforsignin, null, false);

        builder.setView(alert.getRoot());
        AlertDialog alertDialog = builder.create();

        //back button of dialog of box in signin
        alert.backbutton.setOnClickListener(view -> {
            alertDialog.dismiss();
        });
        //verify button of signin dialog
        alert.verfity.setOnClickListener(view -> {
            Toast.makeText(this, "verify", Toast.LENGTH_SHORT).show();
        });

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
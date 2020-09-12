package com.example.localsewa.views;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.provider.Settings;
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
    private   String device_token;

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

        device_token = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);
        

        SignUpBinding.signupbutton.setOnClickListener((view) -> {
            if (signUpViewModel.onclick()) {

                String mobilenumber = signUpViewModel.mnumber;
                String fname = signUpViewModel.fname;
                String token = device_token;
                showdailog(mobilenumber, fname, token);
                //Toast.makeText(this, ""+device_token, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Please fill deatil carefully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //dialog of signup
    private void showdailog(String mumber, String fname, String token) {

        signUpViewModel.getsignup(mumber, fname, token).observe(this, s -> {

            if(s.contains("success")){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                AlterdailoguiforsignupBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this),
                        R.layout.alterdailoguiforsignup, null, false);
                View view = binding.getRoot();
                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);

                binding.setSignup(signUpViewModel);
                binding.executePendingBindings();

                binding.backbutton.setOnClickListener(view1 -> {
                    alertDialog.dismiss();
                });
                binding.verify.setOnClickListener(view1 -> {

                    signUpViewModel.signupverification(mumber,signUpViewModel.signupotop).observe(this,signUpMsg -> {

                        Toast.makeText(this, "pankaj", Toast.LENGTH_SHORT).show();
                    });

                });
                alertDialog.show();

            }
            else{
                Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            }

        });



    }

}
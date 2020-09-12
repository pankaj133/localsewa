package com.example.localsewa.views;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.widget.EditText;
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
                String device_toke = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);
                showdailog(number,device_toke);
            } else {
                Toast.makeText(this, "problem", Toast.LENGTH_SHORT).show();
            }
        }); }
    //dialog method
    private void showdailog(String num,String token) {

        msignInViewModel.getsignin(num,token).observe(this, s -> {

            if(s.contains("success")){

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                AlterdailoguiforsigninBinding signinBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                        R.layout.alterdailoguiforsignin, null, false);

                builder.setView(signinBinding.getRoot());
                AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);


                signinBinding.setSigninviewmodel(msignInViewModel);
                signinBinding.executePendingBindings();

                //back button of dialog of box in signin
                signinBinding.backbutton.setOnClickListener(view -> {
                    alertDialog.dismiss();
                });
                //verify button of signin dialog
                signinBinding.verfity.setOnClickListener(view -> {

                    msignInViewModel.logininverification(num,msignInViewModel.signinotp).observe(this,signInMsg -> {

                        Toast.makeText(this, ""+signInMsg.getFirstName(), Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    });
                    Toast.makeText(this, "verify", Toast.LENGTH_SHORT).show();
                });
                alertDialog.show();

            }
            else{
                Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            }

        });


    }
}
package com.example.booking_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.example.booking_hotel.activity.test_login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;




public class Login extends AppCompatActivity {
CallbackManager callbackManager = CallbackManager.Factory.create();
    ImageView sun, dayland, nightland,moon;
    View daysky, nightsky;
   DayNightSwitch dayNightSwitch;

    TextView btn_login, btn_dangky, btn_quenmk;

    Button btn_login1;
    LinearLayout formlogin, formlogup;
    TextView dangnhap, dangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);

        sun = findViewById(R.id.sun);
        moon = findViewById(R.id.moon);
        dayland = findViewById(R.id.day_landscape);
        nightland = findViewById(R.id.night_landscape);
        daysky = findViewById(R.id.bg_day);
        nightsky = findViewById(R.id.bg_night);
        dayNightSwitch = findViewById(R.id.day_night_switch);
//        btn_login = findViewById(R.id.btn_login);
//        btn_dangky = findViewById(R.id.btn_dangky);
//        btn_quenmk = findViewById(R.id.btn_quenmk);
        btn_login1 = findViewById(R.id.btn_login1);
        dangky = findViewById(R.id.dangKy1);
        dangnhap = findViewById(R.id.login1);
        formlogin = findViewById(R.id.layoutLogin);
        formlogup = findViewById(R.id.layoutLoginUp);


        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
     //   loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        printHashKey(Login.this);
        //
        sun.setTranslationY(-110);
        moon.setTranslationY(-110);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night){
                    //mặt trời lặn
                    sun.animate().translationY(2000).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                    //mặt trăng mọc
                    moon.animate().translationY(-2590).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                }else {
                    //mặt trời mọc
                    sun.animate().translationY(-110).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                    //mặt trặng lặn
                    moon.animate().translationY(2000).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                }
            }
        });



        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.GONE);
                formlogup.setVisibility(View.VISIBLE);
                btn_login1.setText("Đăng ký");
                btn_login1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Login.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.VISIBLE);
                formlogup.setVisibility(View.GONE);
                btn_login1.setText("Đăng nhập");
                btn_login1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }
                });
            }
        });
        //
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this, Home.class);
//                startActivity(intent);
//            }
//        });
//
//        btn_dangky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        btn_quenmk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(Login.this, test_login.class);
////                startActivity(intent);
//            }
//        });
    }
    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("TAG", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("TAG", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("TAG", "printHashKey()", e);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
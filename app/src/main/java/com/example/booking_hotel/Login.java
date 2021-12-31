package com.example.booking_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.booking_hotel.activity.test_login;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class Login extends AppCompatActivity {

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

        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }
        });

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.GONE);
                formlogup.setVisibility(View.VISIBLE);
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.VISIBLE);
                formlogup.setVisibility(View.GONE);
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
}
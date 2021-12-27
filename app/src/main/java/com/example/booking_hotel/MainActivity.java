package com.example.booking_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking_hotel.intro.OnBoarding;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;
    ImageView backgroud;
    TextView title;

    //Animations
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //hooks
        backgroud = findViewById(R.id.img_backgroud);
        title = findViewById(R.id.txt_title);
        //Animations
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        //set Animations on elements
        backgroud.setAnimation(sideAnim);
        title.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}
package com.example.booking_hotel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.booking_hotel.R;

public class Activity_Xephang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_xephang);
    }
}
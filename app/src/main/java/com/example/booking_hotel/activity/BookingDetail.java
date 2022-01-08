package com.example.booking_hotel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking_hotel.R;
import com.squareup.picasso.Picasso;

public class BookingDetail extends AppCompatActivity {
ImageView img_QR;
EditText txt_MP,txt_status,txt_tenKs;
TextView date_start1,date_end1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);
        img_QR=findViewById(R.id.img_QR);


        load();
    }
    private  void load()
    {
        Intent intent= getIntent();
        Picasso.get().load(intent.getStringExtra("QR")).into(img_QR);


    }
}
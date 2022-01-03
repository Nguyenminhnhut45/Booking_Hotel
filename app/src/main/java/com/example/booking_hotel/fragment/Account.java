package com.example.booking_hotel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking_hotel.Login;
import com.example.booking_hotel.R;
import com.example.booking_hotel.activity.profile;
import com.squareup.picasso.Picasso;


public class Account extends Fragment {


    TextView btn_profile,btn_logout;
    ImageView imgFB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        btn_profile = (TextView) view.findViewById(R.id.btn_profile);
        btn_logout = (TextView) view.findViewById(R.id.btn_logout);
        imgFB=(ImageView)view.findViewById(R.id.imgFB);

        Picasso.get().load(Login.ImgName).into(imgFB);
btn_profile.setText(Login.FacebookName);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), profile.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        return view;
    }
}
package com.example.booking_hotel.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.booking_hotel.R;

import java.util.List;


public class BookingHotel extends Fragment {

    ListView list_booking;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_booking_hotel, container, false);
        list_booking = (ListView) view.findViewById(R.id.list_booking);


        return view;
    }
}
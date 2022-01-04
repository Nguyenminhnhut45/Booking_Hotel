package com.example.booking_hotel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booking_hotel.R;
import com.example.lib.Data.Model.Room;
import com.squareup.picasso.Picasso;


public class RoomAdapter extends ArrayAdapter<Room> {
    Activity context;
    int resource;
    public RoomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);
        ImageView imgStudent = view.findViewById(R.id.img_room);
        TextView txtName = view.findViewById(R.id.txt_namehotel);
        TextView txtGia = view.findViewById(R.id.txt_gia);
        TextView txt_khuvuc=view.findViewById(R.id.txt_khuvuc);


        Room pr = getItem(position);
        Picasso.get().load(pr.getImage()).into(imgStudent);

        txtName.setText("Tên: "+pr.getIdHotelNavigation().getHotelName());
        txtGia.setText("Gia: " + pr.getPrice());

        return view;
    }
}
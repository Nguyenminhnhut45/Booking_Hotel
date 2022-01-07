package com.example.booking_hotel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booking_hotel.R;
import com.example.lib.Data.Model.FeedBackModel;
import com.example.lib.Data.Model.Room;
import com.squareup.picasso.Picasso;

public class FeedBackAdapter extends ArrayAdapter<FeedBackModel>{

    Activity context;
    int resource;
    public FeedBackAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);
        TextView rating_id1 = view.findViewById(R.id.rating_id1);
        TextView rating_star1 = view.findViewById(R.id.rating_star1);
        RatingBar rating1 = view.findViewById(R.id.rating1);
        ImageView img_feedback = view.findViewById(R.id.img_feedback);
        FeedBackModel pr = getItem(position);

        rating_id1.setText(pr.getIdcustomerNavigation().getCustomerName());
        rating_star1.setText(pr.getComment());
        rating1.setRating(pr.getAssess());
        Picasso.get().load(pr.getImageComment()).into(img_feedback);

        return view;
    }

}

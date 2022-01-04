package com.example.booking_hotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.booking_hotel.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    int image[] = {
            R.drawable.search_place,
            R.drawable.make_a_call,
            R.drawable.add_missing_place,
            R.drawable.sit_back_and_relax
    };

    int hearding[] ={
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name
    };
    int descriptions[]={
            R.string.appbar_scrolling_view_behavior,
            R.string.appbar_scrolling_view_behavior,
            R.string.appbar_scrolling_view_behavior,
            R.string.appbar_scrolling_view_behavior
    };

    @Override
    public int getCount() {
        return hearding.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slides_layout, container,false);

        ImageView imageView = view.findViewById(R.id.slides_img);
        TextView txtHeading = view.findViewById(R.id.slides_heading);
        TextView txtdescription = view.findViewById(R.id.slides_description);

        imageView.setImageResource(image[position]);
        txtHeading.setText(hearding[position]);
        txtdescription.setText(descriptions[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}

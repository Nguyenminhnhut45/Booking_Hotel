package com.example.booking_hotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking_hotel.R;
import com.example.booking_hotel.loadimg.photo;

import java.util.List;

public class photoViewpager2Adapter extends RecyclerView.Adapter<photoViewpager2Adapter.photoViewHolder> {

    private List<photo> mlistphoto;

    public photoViewpager2Adapter(List<photo> mlistphoto) {
        this.mlistphoto = mlistphoto;
    }

    @NonNull
    @Override
    public photoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img_chitietphong, parent, false);
        return new photoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull photoViewHolder holder, int position) {
        photo photo = mlistphoto.get(position);
        if (photo == null){
            return;
        }
        holder.imagePhoto.setImageResource(photo.getResourceId());
    }

    @Override
    public int getItemCount() {
        if (mlistphoto != null){
            return mlistphoto.size();
        }
        return 0;
    }

    public class photoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePhoto;


        public photoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto = itemView.findViewById(R.id.img_chitietphong);
        }
    }
}

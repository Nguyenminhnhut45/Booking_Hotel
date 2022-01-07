package com.example.booking_hotel.adapter.AdapterHome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking_hotel.R;

import java.util.ArrayList;

public class Rcv_noibatAdapter extends RecyclerView.Adapter<Rcv_noibatAdapter.Rcv_noibatViewHolder> {
    ArrayList<Rcv_noibatModel> rcv_noibatLocation;

    public Rcv_noibatAdapter(ArrayList<Rcv_noibatModel> rcv_noibatLocation) {
        this.rcv_noibatLocation = rcv_noibatLocation;
    }

    @NonNull
    @Override
    public Rcv_noibatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_load_rcv_noibat, parent, false);
        Rcv_noibatViewHolder rcv_noibatViewHolder = new Rcv_noibatViewHolder(view);
        return rcv_noibatViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Rcv_noibatViewHolder holder, int position) {
        Rcv_noibatModel rcv_noibatModel = rcv_noibatLocation.get(position);

        holder.img.setImageResource(rcv_noibatModel.getImg());
        holder.title.setText(rcv_noibatModel.getTitle());
        holder.mota.setText(rcv_noibatModel.getMota());
    }

    @Override
    public int getItemCount() {
        return rcv_noibatLocation.size();
    }

    public static class Rcv_noibatViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title, mota;
        public Rcv_noibatViewHolder(@NonNull View itemView) {
            super(itemView);

            //anh xa
            img = itemView.findViewById(R.id.img_item_noibat);
            title = itemView.findViewById(R.id.item_ten_diadiem);
            mota = itemView.findViewById(R.id.item_mota_diadiem);
        }
    }
}

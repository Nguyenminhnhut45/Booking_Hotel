package com.example.booking_hotel.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking_hotel.R;
import com.example.booking_hotel.activity.ChiTietPhong;
import com.example.lib.Data.Model.Room;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_Search extends RecyclerView.Adapter<Recyclerview_Search.ViewHolder> {
    @NonNull
    private Context mcontext;
    ArrayList<Room> list;
    ArrayList<Room> filterList;

    TiengViet xuLyChuoiTiengViet = new TiengViet();
    public Recyclerview_Search(Context mcontext, ArrayList<Room> list) {
        this.mcontext = mcontext;
        this.filterList = list;
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    public Filter getFilter() {
        return filter;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String url = filterList.get(position).getImage();
        Picasso.get().load(url).into(holder.imvHSP);
     holder.txtTSP.setText(filterList.get(position).getIdHotelNavigation().getHotelName());
     holder.Gia.setText( filterList.get(position).getPrice().toString());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mcontext, ChiTietPhong.class);
                intent.putExtra("gia",filterList.get(position).getPrice().toString());
                intent.putExtra("tenks",filterList.get(position).getIdHotelNavigation().getHotelName());
                intent.putExtra("mota",filterList.get(position).getDescription());
                intent.putExtra("diachi",filterList.get(position).getIdHotelNavigation().getAddress());
                intent.putExtra("hinh",filterList.get(position).getImage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Object coordinatorlayout;
        ImageView imvHSP;
        TextView txtTSP,Gia,Khuvuc;
        CoordinatorLayout t;

        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvHSP = itemView.findViewById(R.id.sur_pro_img);
            txtTSP = itemView.findViewById(R.id.sur_pro_title);
            Gia=itemView.findViewById(R.id.sur_pro_price);
            Khuvuc=itemView.findViewById(R.id.sur_pro_local);
            relativeLayout = itemView.findViewById(R.id.relative_item_search);
        }
    }
    private Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            /// khởi tạo biến result
            FilterResults filterResults= new FilterResults();
            String keySearch = constraint.toString();
            /// khi keysearch co gia tri
            if (keySearch != null && keySearch.toString().length() > 0) {
                /// thì mình khởi tạo list trống để add dữ liệu sao khi check vào
                ArrayList<Room> filteredList = new ArrayList<>();
                String pattrn= keySearch.toLowerCase().trim();
                for(Room item : list){
                    /// check dử liệu để add
                    if (xuLyChuoiTiengViet.ConvertString(item.getIdHotelNavigation().getHotelName().toLowerCase())
                            .contains(xuLyChuoiTiengViet.ConvertString(pattrn))) {
                        filteredList.add(item);
                    }
                }
                /// gán vào giá trị sao khi check xong
                filterResults.values = filteredList;
                filterResults.count = filteredList.size();
            }
            else{
                /// gán lại giá trị all
                filterResults.values = list;
                filterResults.count = list.size();
//                synchronized (list) {
//                    filterResults.values = list;
//                    filterResults.count = list.size();
//                }
            }
            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterList = (ArrayList<Room>) results.values;
            notifyDataSetChanged();
        }
    };
}

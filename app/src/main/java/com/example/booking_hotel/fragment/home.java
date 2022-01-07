package com.example.booking_hotel.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.booking_hotel.Home;
import com.example.booking_hotel.MainActivity;
import com.example.booking_hotel.R;
import com.example.booking_hotel.adapter.AdapterHome.Rcv_noibatAdapter;
import com.example.booking_hotel.adapter.AdapterHome.Rcv_noibatModel;
import com.example.booking_hotel.adapter.RoomAdapter;
import com.example.lib.Data.Model.Room;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home extends Fragment {
    ListView listView;
    ArrayList<Room> list;
    RoomAdapter adapter;

    RecyclerView rcv_noibat,rcv_diadiemdep,rvc_danhmuc;
    RecyclerView.Adapter rcv_adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        rcv_noibat = (RecyclerView) view.findViewById(R.id.rcv_noibat);
        rcv_diadiemdep = (RecyclerView) view.findViewById(R.id.rcv_diadiemdep);
        rvc_danhmuc = (RecyclerView) view.findViewById(R.id.rvc_danhmuc);

        // listView=view.findViewById(R.id.list_noibat); // thuận ẩn code này
//        adapter = new RoomAdapter(getContext(), R.layout.item_home_noibat);
//        getRoom();

        load_rcv_noibat();
        load_rcv_diadiemdep();
        load_rcv_danhmuc();
        return view;
    }

    public void load_rcv_noibat(){
        rcv_noibat.setHasFixedSize(true);
        rcv_noibat.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Rcv_noibatModel> rcv_noibatLocation = new ArrayList<>();

        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay3,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay2,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay4,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay5,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));

        rcv_adapter = new Rcv_noibatAdapter(rcv_noibatLocation);
        rcv_noibat.setAdapter(rcv_adapter);
    }

    public void load_rcv_diadiemdep(){
        rcv_diadiemdep.setHasFixedSize(true);
        rcv_diadiemdep.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Rcv_noibatModel> rcv_noibatLocation = new ArrayList<>();

        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay3,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay2,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay4,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay5,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay1,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay6,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay7,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay8,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));

        rcv_adapter = new Rcv_noibatAdapter(rcv_noibatLocation);
        rcv_diadiemdep.setAdapter(rcv_adapter);
    }

    public void load_rcv_danhmuc(){
        rvc_danhmuc.setHasFixedSize(true);
        rvc_danhmuc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Rcv_noibatModel> rcv_noibatLocation = new ArrayList<>();

        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay3,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay2,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay4,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay5,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay10,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay9,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));
        rcv_noibatLocation.add(new Rcv_noibatModel(R.drawable.viewhomestay7,"Đà Lạt", "Địa điểm đẹp thích hợp cho các cặp đôi"));

        rcv_adapter = new Rcv_noibatAdapter(rcv_noibatLocation);
        rvc_danhmuc.setAdapter(rcv_adapter);
    }




//    public void getRoom () {
//        Method method = ApiUtils.getSOService();
//        list = new ArrayList<>();
//        method.getRoom().enqueue(new Callback<List<Room>>() {
//            @Override
//            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
//                list = (ArrayList<Room>) response.body();
//                adapter.addAll(list);
//                listView.setAdapter(adapter);
//            //    Log.v("test",list[0])
//            }
//
//            @Override
//            public void onFailure(Call<List<Room>> call, Throwable t) {
//
//            }
//        });

//    }


}
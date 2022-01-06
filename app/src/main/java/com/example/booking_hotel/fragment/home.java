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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        listView=view.findViewById(R.id.list_noibat);
        adapter = new RoomAdapter(getContext(), R.layout.item_home_noibat);
        getRoom();
        return view;
    }
    public void getRoom () {
        Method method = ApiUtils.getSOService();
        list = new ArrayList<>();
        method.getRoom().enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {


                list = (ArrayList<Room>) response.body();
                adapter.addAll(list);
                listView.setAdapter(adapter);
            //    Log.v("test",list[0])
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {

            }
        });

    }


}
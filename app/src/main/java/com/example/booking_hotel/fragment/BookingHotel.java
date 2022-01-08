package com.example.booking_hotel.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.booking_hotel.Login;
import com.example.booking_hotel.R;
import com.example.booking_hotel.activity.BookingDetail;
import com.example.booking_hotel.adapter.HistoryBookingAdapter;
import com.example.lib.Data.Model.BookingDetailModel;
import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Model.Hotel;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingHotel extends Fragment {

    HistoryBookingAdapter historyBookingAdapter;
    ListView list_booking;
    private Method method;
    ArrayList<BookingModel> list;
    ArrayList<BookingDetailModel> list1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_booking_hotel, container, false);
        list_booking = (ListView) view.findViewById(R.id.list_booking);
        historyBookingAdapter = new HistoryBookingAdapter(getContext(), R.layout.item_load_history_booking);
        method = ApiUtils.getSOService();
        list = new ArrayList<>();

        method.GetHistoryBooking(Login.idCustomer).enqueue(new Callback<List<BookingModel>>() {
            @Override
            public void onResponse(Call<List<BookingModel>> call, Response<List<BookingModel>> response) {
                list = (ArrayList<BookingModel>) response.body();
                historyBookingAdapter.addAll(list);
                list_booking.setAdapter(historyBookingAdapter);

                list_booking.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        BookingModel his = list.get(i);
                        method.GetBookingDetail(his.getIdbooking()).enqueue(new Callback<BookingDetailModel>() {
                            @Override
                            public void onResponse(Call<BookingDetailModel> call, Response<BookingDetailModel> response) {

                              String t = response.body().getIdroom();
                              String date= response.body().getDateStart();
                              String end= response.body().getDateEnd();
                                method.getHotel(response.body().getIdroomNavigation().getIdHotel()).enqueue(new Callback<Hotel>() {
                                    @Override
                                    public void onResponse(Call<Hotel> call, Response<Hotel> response) {
                                        Intent intent= new Intent(getActivity(), BookingDetail.class);
                                        intent.putExtra("QR",list.get(i).getIqr());
                                        intent.putExtra("idroom",t);

                                        intent.putExtra("ten",response.body().getIdhotel());

                                        intent.putExtra("tenks",response.body().getHotelName());
                                        intent.putExtra("star",date);
                                        intent.putExtra("end",end);
                                        startActivity(intent);

                                    }

                                    @Override
                                    public void onFailure(Call<Hotel> call, Throwable t) {

                                    }
                                });





                            }

                            @Override
                            public void onFailure(Call<BookingDetailModel> call, Throwable t) {

                            }
                        });

                    }
                });
                Log.v("Log", "true");
            }

            @Override
            public void onFailure(Call<List<BookingModel>> call, Throwable t) {

            }
        });


        return view;
    }
}
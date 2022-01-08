package com.example.booking_hotel.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booking_hotel.R;
import com.example.lib.Data.Model.BookingDetailModel;
import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Model.Hotel;
import com.example.lib.Data.Model.ListBookingModel;
import com.example.lib.Data.Model.Room;
import com.example.lib.Data.Remote.ApiUtils;
import com.example.lib.Data.Remote.Method;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryBookingAdapter extends ArrayAdapter<BookingModel> {

    Activity context;
    int resource;
    private Method method = ApiUtils.getSOService();
    public HistoryBookingAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);
        ImageView imgQr = view.findViewById(R.id.img_qr);
        TextView txt_hotelName = view.findViewById(R.id.txt_hotelName);
        TextView txt_datetime = view.findViewById(R.id.txt_datetime);
        TextView txt_checkin = view.findViewById(R.id.txt_checkin);
        TextView txt_maphong = view.findViewById(R.id.txt_maphong);




        BookingModel his = getItem(position);
        Picasso.get().load(his.getIqr()).into(imgQr);

        String dateBooking = (his.getDateBooking().replace("T00:00:00", ""));
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dates = (Date) formatter.parse(dateBooking);
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
            String finalString = newFormat.format(dates);
            txt_datetime.setText("Ngày đặt: "+finalString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // txt_hotelName.setText("Tên: "+his.getIdbooking());
        method.GetBookingDetail(his.getIdbooking()).enqueue(new Callback<BookingDetailModel>() {
            @Override
            public void onResponse(Call<BookingDetailModel> call, Response<BookingDetailModel> response) {
                Log.v("idHotel", response.body().getIdroomNavigation().getIdHotel());
                if(response.body().getIsCheckIn()==false){
                    txt_checkin.setText("Chưa CheckIn");
                }else{
                    txt_checkin.setText("Đã CheckIn");
                }
                txt_maphong.setText("Mã phòng: "+ response.body().getIdroom());

                    method.getHotel(response.body().getIdroomNavigation().getIdHotel()).enqueue(new Callback<Hotel>() {
                    @Override
                    public void onResponse(Call<Hotel> call, Response<Hotel> response) {
                        txt_hotelName.setText(response.body().getHotelName());

                    }

                    @Override
                    public void onFailure(Call<Hotel> call, Throwable t) {
                        Log.v("Loi", "Call id Hotel");
                    }
                });
            }


            @Override
            public void onFailure(Call<BookingDetailModel> call, Throwable t) {

            }
        });



        return view;
    }
}

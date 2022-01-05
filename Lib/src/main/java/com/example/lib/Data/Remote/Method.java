package com.example.lib.Data.Remote;

import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Model.CustomerModel;
import com.example.lib.Data.Model.Room;
import com.example.lib.Data.Model.StatusModel;
import com.example.lib.Data.Model.UserModelPost;
import com.example.lib.Data.ResultModel.PostBooking;
import com.example.lib.Data.ResultModel.PostBookingDetail;
import com.example.lib.Data.ResultModel.PostCustomer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Method {
    @GET("api/User/get-user")
    Call<StatusModel> getUserLogin(@Query("username") String username, @Query("pass") String pass);

    @POST("api/User/insert-user")
    Call<UserModelPost> InsertUser(@Body UserModelPost userModelPost);

    @POST("/api/Booking/insert-booking")
    Call<PostBooking> InsertBooking(@Body BookingModel bookingModel);

    @POST ("api/Customer/insert-customergoogle")
    Call<PostCustomer> InsertCustomer (@Body CustomerModel customerModel);

    @GET ("api/Customer/{id}")
    Call<CustomerModel> GetCustomer (@Path("id") String id);

    @GET ("api/Customer/get-iduser")
    Call<CustomerModel> GetCustomerByIdUser (@Query("id") String id);

    @POST ("api/Booking/insert-bookingdetail")
    Call <PostBookingDetail> PostBookingDetail(@Query("dateStart") String dateStart, @Query("dateEnd") String dateEnd, @Query("idBooking") String idBooking,
    @Query("idroom") String idroom);



    @GET("api/Room")
    Call<List<Room>> getRoom();

}

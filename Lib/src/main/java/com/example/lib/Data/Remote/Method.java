package com.example.lib.Data.Remote;

import androidx.constraintlayout.widget.Guideline;

import com.example.lib.Data.Model.BookingDetailModel;
import com.example.lib.Data.Model.BookingModel;
import com.example.lib.Data.Model.CustomerModel;
import com.example.lib.Data.Model.FeedBackModel;
import com.example.lib.Data.Model.HistoryBooking;
import com.example.lib.Data.Model.Hotel;
import com.example.lib.Data.Model.PostFeedBackModel;
import com.example.lib.Data.Model.Room;
import com.example.lib.Data.Model.StatusModel;
import com.example.lib.Data.Model.UserModelPost;
import com.example.lib.Data.ResultModel.GetFeedBackByHotel;
import com.example.lib.Data.ResultModel.PostBooking;
import com.example.lib.Data.ResultModel.PostBookingDetail;
import com.example.lib.Data.ResultModel.PostCustomer;
import com.example.lib.Data.ResultModel.PostUserModel;

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
    Call<PostUserModel> InsertUser(@Body UserModelPost userModelPost);

    @POST("/api/Booking/insert-booking")
    Call<PostBooking> InsertBooking(@Body BookingModel bookingModel);
    @POST("/api/FeedBack")
    Call<PostFeedBackModel> InsertFeedback(@Body PostFeedBackModel feekBackModel);

    @POST ("api/Customer/insert-customergoogle")
    Call<PostCustomer> InsertCustomer (@Body CustomerModel customerModel);

    @GET ("api/Customer/{id}")
    Call<CustomerModel> GetCustomer (@Path("id") String id);

    @GET ("api/Customer/get-iduser")
    Call<CustomerModel> GetCustomerByIdUser (@Query("id") String id);

    @POST ("api/Booking/insert-bookingdetail")
    Call <PostBookingDetail> PostBookingDetail(@Query("dateStart") String dateStart, @Query("dateEnd") String dateEnd, @Query("idBooking") String idBooking,
    @Query("idroom") String idroom);

    @GET ("api/FeedBack/get-sumAssess")
    Call <GetFeedBackByHotel> GetFeedBackByHotel(@Query("idHotel") String idHotel);

    @GET ("api/FeedBack/get-hotel")
    Call <List<FeedBackModel>> GetFeedBack(@Query("idHotel") String idHotel);

    @GET("api/Room")
    Call<List<Room>> getRoom();

    /*@GET("api/Booking/get-customer")
    Call<HistoryBooking> GetHistoryBooking(@Query("idCustomer") String idCustomer);*/

    @GET("api/Booking/get-customer")
    Call<List<BookingModel>> GetHistoryBooking(@Query("idCustomer") String idCustomer);

    @GET("/api/BookingDetail/get-idbooking")
    Call<BookingDetailModel> GetBookingDetail(@Query("idBooking") String idBooking);

    @GET("api/Hotel/{idHotel}")
    Call<Hotel> getHotel (@Path("idHotel") String idHotel);

}

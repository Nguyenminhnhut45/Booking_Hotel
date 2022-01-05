package com.example.lib.Data.ResultModel;


import com.example.lib.Data.Model.BookingModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostBooking {

    @SerializedName("statusCode")
    @Expose
    private Boolean statusCode;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("booking")
    @Expose
    private BookingModel booking;

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

}
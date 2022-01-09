package com.example.lib.Data.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListBookingModel {

    @SerializedName("idbooking")
    @Expose
    private String idbooking;
    @SerializedName("idcustomer")
    @Expose
    private String idcustomer;
    @SerializedName("dateBooking")
    @Expose
    private String dateBooking;
    @SerializedName("sumMoney")
    @Expose
    private Integer sumMoney;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("iqr")
    @Expose
    private String iqr;
    @SerializedName("idcustomerNavigation")
    @Expose
    private CustomerModel idcustomerNavigation;
    @SerializedName("bookingDetails")
    @Expose
    private BookingDetailModel bookingDetails = null;

    public String getIdbooking() {
        return idbooking;
    }

    public void setIdbooking(String idbooking) {
        this.idbooking = idbooking;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public Integer getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Integer sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIqr() {
        return iqr;
    }

    public void setIqr(String iqr) {
        this.iqr = iqr;
    }

    public CustomerModel getIdcustomerNavigation() {
        return idcustomerNavigation;
    }

    public void setIdcustomerNavigation(CustomerModel idcustomerNavigation) {
        this.idcustomerNavigation = idcustomerNavigation;
    }

    public BookingDetailModel getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetailModel bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

}
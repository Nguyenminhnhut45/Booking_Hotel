package com.example.lib.Data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Room {

    @SerializedName("idroom")
    @Expose
    private String idroom;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("idHotel")
    @Expose
    private String idHotel;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("idHotelNavigation")
    @Expose
    private Hotel idHotelNavigation;
    @SerializedName("bookingDetails")
    @Expose
    private List<Object> bookingDetails = null;
    @SerializedName("detailConvenients")
    @Expose
    private List<Object> detailConvenients = null;

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Hotel getIdHotelNavigation() {
        return idHotelNavigation;
    }

    public void setIdHotelNavigation(Hotel idHotelNavigation) {
        this.idHotelNavigation = idHotelNavigation;
    }

    public List<Object> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<Object> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public List<Object> getDetailConvenients() {
        return detailConvenients;
    }

    public void setDetailConvenients(List<Object> detailConvenients) {
        this.detailConvenients = detailConvenients;
    }

}
package com.example.lib.Data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Hotel {

    @SerializedName("idhotel")
    @Expose
    private String idhotel;
    @SerializedName("hotelName")
    @Expose
    private String hotelName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("idArea")
    @Expose
    private String idArea;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("ratings")
    @Expose
    private Integer ratings;
    @SerializedName("typeOf")
    @Expose
    private Integer typeOf;
    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("bank")
    @Expose
    private Object bank;

    private Object iduserNavigation;
    @SerializedName("feedBacks")
    @Expose
    private List<Object> feedBacks = null;
    @SerializedName("rooms")
    @Expose
    private List<Object> rooms = null;

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Integer getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(Integer typeOf) {
        this.typeOf = typeOf;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public Object getBank() {
        return bank;
    }

    public void setBank(Object bank) {
        this.bank = bank;
    }



    public Object getIduserNavigation() {
        return iduserNavigation;
    }

    public void setIduserNavigation(Object iduserNavigation) {
        this.iduserNavigation = iduserNavigation;
    }

    public List<Object> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(List<Object> feedBacks) {
        this.feedBacks = feedBacks;
    }

    public List<Object> getRooms() {
        return rooms;
    }

    public void setRooms(List<Object> rooms) {
        this.rooms = rooms;
    }

}
package com.example.lib.Data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CustomerModel {

    @SerializedName("idcustomer")
    @Expose
    private String idcustomer;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("brithday")
    @Expose
    private String brithday;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("imageBackside")
    @Expose
    private String imageBackside;
    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("imageFront")
    @Expose
    private String imageFront;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("idgoogle")
    @Expose
    private String idgoogle;
    @SerializedName("idfacebook")
    @Expose
    private String idfacebook;

    @SerializedName("iduserNavigation")
    @Expose
    private UserModel iduserNavigation;

    @SerializedName("bookings")
    @Expose
    private List<Object> bookings = null;
    @SerializedName("feedBacks")
    @Expose
    private List<Object> feedBacks = null;

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageBackside() {
        return imageBackside;
    }

    public void setImageBackside(String imageBackside) {
        this.imageBackside = imageBackside;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImageFront() {
        return imageFront;
    }

    public void setImageFront(String imageFront) {
        this.imageFront = imageFront;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdgoogle() {
        return idgoogle;
    }

    public void setIdgoogle(String idgoogle) {
        this.idgoogle = idgoogle;
    }

    public String getIdfacebook() {
        return idfacebook;
    }

    public void setIdfacebook(String idfacebook) {
        this.idfacebook = idfacebook;
    }


    public UserModel getIduserNavigation() {
        return iduserNavigation;
    }

    public void setIduserNavigation(UserModel iduserNavigation) {
        this.iduserNavigation = iduserNavigation;
    }

    public List<Object> getBookings() {
        return bookings;
    }

    public void setBookings(List<Object> bookings) {
        this.bookings = bookings;
    }

    public List<Object> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(List<Object> feedBacks) {
        this.feedBacks = feedBacks;
    }



}


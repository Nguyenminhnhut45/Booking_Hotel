package com.example.lib.Data.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserModel {

    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("roles")
    @Expose
    private Integer roles;
    @SerializedName("isCustomerOwner")
    @Expose
    private String isCustomerOwner;
    @SerializedName("customers")
    @Expose
    private List<Object> customers = null;
    @SerializedName("hotels")
    @Expose
    private List<Object> hotels = null;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public String getIsCustomerOwner() {
        return isCustomerOwner;
    }

    public void setIsCustomerOwner(String isCustomerOwner) {
        this.isCustomerOwner = isCustomerOwner;
    }

    public List<Object> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Object> customers) {
        this.customers = customers;
    }

    public List<Object> getHotels() {
        return hotels;
    }

    public void setHotels(List<Object> hotels) {
        this.hotels = hotels;
    }

}
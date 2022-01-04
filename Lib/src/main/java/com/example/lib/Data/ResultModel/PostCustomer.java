package com.example.lib.Data.ResultModel;

import java.util.List;

import com.example.lib.Data.Model.CustomerModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class PostCustomer {


    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("customer1")
    @Expose
    private CustomerModel customer1;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerModel getCustomer1() {
        return customer1;
    }

    public void setCustomer1(CustomerModel customer1) {
        this.customer1 = customer1;
    }

}
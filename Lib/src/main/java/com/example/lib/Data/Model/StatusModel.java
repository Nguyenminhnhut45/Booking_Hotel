package com.example.lib.Data.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StatusModel {

    @SerializedName("statusCode")
    @Expose
    private Boolean statusCode;

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

}
package com.example.lib.Data.ResultModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingUp {

    @SerializedName("statusCode")
    @Expose
    private Boolean statusCode;
    @SerializedName("status")
    @Expose
    private String status;

    public Boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
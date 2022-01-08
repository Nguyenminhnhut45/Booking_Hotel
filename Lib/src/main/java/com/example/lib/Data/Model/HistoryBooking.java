package com.example.lib.Data.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HistoryBooking {

    @SerializedName("list")
    @Expose
    private List<ListBookingModel> list ;

    public List<ListBookingModel> getList() {
        return list;
    }

    public void setList(List<ListBookingModel> list) {
        this.list = list;
    }

}
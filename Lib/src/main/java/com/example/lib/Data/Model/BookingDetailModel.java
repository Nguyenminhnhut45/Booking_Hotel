package com.example.lib.Data.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BookingDetailModel {

    @SerializedName("idroom")
    @Expose
    private String idroom;
    @SerializedName("idbooking")
    @Expose
    private String idbooking;
    @SerializedName("dateStart")
    @Expose
    private String dateStart;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("money")
    @Expose
    private Integer money;
    @SerializedName("isCheckIn")
    @Expose
    private Boolean isCheckIn;
    @SerializedName("idbookingNavigation")
    @Expose
    private BookingModel idbookingNavigation;
    @SerializedName("idroomNavigation")
    @Expose
    private Room idroomNavigation;

    public Room getIdroomNavigation() {
        return idroomNavigation;
    }

    public void setIdroomNavigation(Room idroomNavigation) {
        this.idroomNavigation = idroomNavigation;
    }


    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }

    public String getIdbooking() {
        return idbooking;
    }

    public void setIdbooking(String idbooking) {
        this.idbooking = idbooking;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Boolean getIsCheckIn() {
        return isCheckIn;
    }

    public void setIsCheckIn(Boolean isCheckIn) {
        this.isCheckIn = isCheckIn;
    }

    public BookingModel getIdbookingNavigation() {
        return idbookingNavigation;
    }

    public void setIdbookingNavigation(BookingModel idbookingNavigation) {
        this.idbookingNavigation = idbookingNavigation;
    }

}
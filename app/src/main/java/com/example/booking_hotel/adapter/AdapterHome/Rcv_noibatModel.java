package com.example.booking_hotel.adapter.AdapterHome;

public class Rcv_noibatModel {
    int img;
    String title, mota;

    public Rcv_noibatModel(int img, String title, String mota) {
        this.img = img;
        this.title = title;
        this.mota = mota;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

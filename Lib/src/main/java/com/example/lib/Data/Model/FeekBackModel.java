package com.example.lib.Data.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FeekBackModel {

    @SerializedName("idhotel")
    @Expose
    private String idhotel;
    @SerializedName("idcustomer")
    @Expose
    private String idcustomer;
    @SerializedName("assess")
    @Expose
    private Integer assess;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("imageComment")
    @Expose
    private String imageComment;

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Integer getAssess() {
        return assess;
    }

    public void setAssess(Integer assess) {
        this.assess = assess;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImageComment() {
        return imageComment;
    }

    public void setImageComment(String imageComment) {
        this.imageComment = imageComment;
    }

}
package com.example.new_mobile_project.Models;

public class ReportModel {
    public int orderid;
    int customerid;
    int price;
    String date;

    public ReportModel(int orderid, String date,int customerid, int price ) {
        this.orderid = orderid;
        this.price = price;
        this.customerid = customerid;
        this.date = date;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

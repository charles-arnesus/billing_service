package com.charles.billing_service.models;

public class Biller {

    private String billerId;
    private String billerName;
    private String category;

    public Biller(){

    }

    public Biller(String billerId, String billerName, String category) {
        this.billerId = billerId;
        this.billerName = billerName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBillerId() {
        return billerId;
    }

    public String getBillerName() {
        return billerName;
    }
}

package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the biller")
public class Biller {

    @ApiModelProperty(notes = "The unique id of the biller")
    private String billerId;
    @ApiModelProperty(notes = "The biller's name")
    private String billerName;
    @ApiModelProperty(notes = "The biller's category")
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

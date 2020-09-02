package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "Details about the biller")
@Entity
@Table(name = "biller")
public class Biller {

    @ApiModelProperty(notes = "The unique id of the biller")
    @Id
    private String billerId;
    @ApiModelProperty(notes = "The biller's name")
    @Column(name = "biller_name")
    private String billerName;
    @ApiModelProperty(notes = "The biller's category")
    @Column(name = "category")
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

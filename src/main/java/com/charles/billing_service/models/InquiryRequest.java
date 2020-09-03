package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for inquiry request")
public class InquiryRequest {
    @ApiModelProperty(notes = "The unique id of the biller")
    private String billerId;
    @ApiModelProperty(notes = "The customer account id")
    private String userInput;

    public InquiryRequest() {

    }

    public InquiryRequest(String billerId, String userInput) {
        this.billerId = billerId;
        this.userInput = userInput;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}

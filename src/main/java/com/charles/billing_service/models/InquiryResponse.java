package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@ApiModel(description = "Model for inquiry response")
public class InquiryResponse implements Serializable {
    @ApiModelProperty(notes = "The unique id of the inquiry")
    public UUID inquiryId;
    @ApiModelProperty(notes = "The unique id of the biller")
    public String billerId;
    @ApiModelProperty(notes = "The customer account id")
    public String customerAccountId;
    @ApiModelProperty(notes = "The total amount of the bill")
    public Double totalAmount;
    @ApiModelProperty(notes = "The due date of the bill")
    public LocalDate dueDate;

    public InquiryResponse() {

    }

    public InquiryResponse(UUID inquiryId, String billerId, String customerAccountId, Double totalAmount, LocalDate dueDate) {
        this.inquiryId = inquiryId;
        this.billerId = billerId;
        this.customerAccountId = customerAccountId;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
    }

    public UUID getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(UUID inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

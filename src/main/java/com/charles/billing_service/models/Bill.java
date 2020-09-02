package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "Details about the bill")
public class Bill {
    @ApiModelProperty(notes = "The unique id of the bill")
    private String orderId;
    @ApiModelProperty(notes = "The unique id of the user")
    private String userId;
    @ApiModelProperty(notes = "The unique id of the biller")
    private String billerId;
    @ApiModelProperty(notes = "The status of the payment")
    private String status;
    @ApiModelProperty(notes = "The total amount of the bill")
    private Double totalAmount;
    @ApiModelProperty(notes = "The date and time bill created")
    private LocalDateTime createdDateTime;
    @ApiModelProperty(notes = "The date and time bill updated")
    private LocalDateTime updatedDateTime;
    @ApiModelProperty(notes = "The date and time bill updated")
    private LocalDate paymentDate;

    public Bill() {

    }

    public Bill(String orderId,
                String userId,
                String billerId,
                String status,
                Double totalAmount,
                LocalDateTime createdDateTime,
                LocalDateTime updatedDateTime,
                LocalDate paymentDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.billerId = billerId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.paymentDate = paymentDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}

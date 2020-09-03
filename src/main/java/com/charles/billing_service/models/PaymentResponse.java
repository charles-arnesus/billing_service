package com.charles.billing_service.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.UUID;

@ApiModel(description = "Model for payment response")
public class PaymentResponse {
    @ApiModelProperty(notes = "The unique id of the payment")
    private UUID paymentId;
    @ApiModelProperty(notes = "The unique id of the biller")
    private String billerId;
    @ApiModelProperty(notes = "The total amount of the bill")
    private Double totalAmount;
    @ApiModelProperty(notes = "The status of the bill")
    private String status;
    @ApiModelProperty(notes = "The customer account id")
    private String customerAccountId;
    @ApiModelProperty(notes = "The date that bill paid")
    private LocalDate paymentDate;

    public PaymentResponse() {

    }

    public PaymentResponse(
            UUID paymentId,
            String billerId,
            Double totalAmount,
            String status,
            String customerAccountId,
            LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.billerId = billerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.customerAccountId = customerAccountId;
        this.paymentDate = paymentDate;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}

package com.charles.billing_service.models;

import java.util.UUID;

public class PaymentResponse {
    private UUID paymentId;
    private String billerId;
    private Double totalAmount;
    private String status;
    private String customerAccountId;

    public PaymentResponse() {

    }

    public PaymentResponse(UUID paymentId, String billerId, Double totalAmount, String status, String customerAccountId) {
        this.paymentId = paymentId;
        this.billerId = billerId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.customerAccountId = customerAccountId;
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
}

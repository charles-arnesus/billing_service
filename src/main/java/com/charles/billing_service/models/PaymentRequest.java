package com.charles.billing_service.models;

public class PaymentRequest {
    public String billerId;
    public String customerAccountId;
    public Double totalAmount;

    public PaymentRequest() {

    }

    public PaymentRequest(String billerId, String customerAccountId, Double totalAmount) {
        this.billerId = billerId;
        this.customerAccountId = customerAccountId;
        this.totalAmount = totalAmount;
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
}

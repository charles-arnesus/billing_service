package com.charles.billing_service.models;

import java.time.LocalDate;

public class PaymentRequest {
    public String billerId;
    public String customerAccountId;
    public Double totalAmount;
    private LocalDate dueDate;

    public PaymentRequest() {

    }

    public PaymentRequest(String billerId, String customerAccountId, Double totalAmount, LocalDate dueDate) {
        this.billerId = billerId;
        this.customerAccountId = customerAccountId;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
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

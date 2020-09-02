package com.charles.billing_service.repository;

import com.charles.billing_service.models.InquiryResponse;

import java.util.Map;

public interface InquiryResponseRepository {
    void save(InquiryResponse inquiryResponse);

    Map<String, InquiryResponse> findAll();

    InquiryResponse findById(String id);

    void update(InquiryResponse inquiryResponse);

    void delete(String id);
}

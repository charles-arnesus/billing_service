package com.charles.billing_service.repository;

import com.charles.billing_service.models.InquiryResponse;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class InquiryResponseRepositoryImpl implements InquiryResponseRepository {

    private RedisTemplate<String, InquiryResponse> redisTemplate;
    private HashOperations hashOperations; //to access Redis cache

    public InquiryResponseRepositoryImpl(RedisTemplate<String, InquiryResponse> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(InquiryResponse inquiryResponse) {
        hashOperations.put("INQUIRY", inquiryResponse.getInquiryId().toString(), inquiryResponse);
    }

    @Override
    public Map<String, InquiryResponse> findAll() {
        return hashOperations.entries("INQUIRY");
    }

    @Override
    public InquiryResponse findById(String id) {
        return (InquiryResponse) hashOperations.get("INQUIRY", id);
    }

    @Override
    public void update(InquiryResponse inquiryResponse) {
        save(inquiryResponse);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("INQUIRY", id);
    }
}

package com.charles.billing_service.controllers;

import com.charles.billing_service.models.*;
import com.charles.billing_service.repository.BillerRepository;
import com.charles.billing_service.repository.InquiryResponseRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BillingServiceController {

    public static final String PDAM = "pdam";
    public static final String POSTPAID = "postpaid";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private InquiryResponseRepository inquiryResponseRepository;
    @Autowired
    private BillerRepository billerRepository;

    @GetMapping("/history/{userId}")
    @ApiOperation(value = "Retrieve all payment history by userId",
            notes = "Provide a userId to retrieve all payment history",
            response = Bills.class)
    public Bills getAllBillHistory(
            @ApiParam(value = "ID value for the payment history that need to be retrieved", required = true)
            @PathVariable("userId")
                    String userId) {
        return restTemplate.getForObject("http://billing-history-service/api/history/" + userId, Bills.class);
    }

    public Bill addBillHistory(PaymentResponse paymentResponse){
        Bill bill = new Bill();
        bill = restTemplate.postForObject(
                "http://billing-history-service/api/history/",
                paymentResponse,
                Bill.class);
        return bill;
    }

    @PostMapping("/inquiry")
    public InquiryResponse doInquiry(@RequestBody InquiryRequest inquiryRequest) {
        final String billerId = inquiryRequest.getBillerId();
        final Biller biller = billerRepository.findByBillerId(billerId);
        final String billerCategory = biller.getCategory();
        InquiryResponse response = new InquiryResponse();
        switch (billerCategory) {
            case PDAM:
                response = restTemplate.postForObject(
                        "http://billing-pdam-client/api/inquiry/",
                        inquiryRequest,
                        InquiryResponse.class);
                break;
            case POSTPAID:
                response = restTemplate.postForObject(
                        "http://billing-postpaid-client/api/inquiry/",
                        inquiryRequest,
                        InquiryResponse.class);
                break;
            default:
                break;
        }
        response.setInquiryId(UUID.randomUUID());
        inquiryResponseRepository.save(response);
        return inquiryResponseRepository.findById(response.getInquiryId().toString());
    }

    @PostMapping("/pay")
    public Bill doPayment(@RequestBody String inquiryId) throws Throwable {
        try {
            InquiryResponse inquiryResponse = inquiryResponseRepository.findById(inquiryId);
            final String billerId = inquiryResponse.getBillerId();
            final Biller biller = billerRepository.findByBillerId(billerId);
            final String billerCategory = biller.getCategory();
            final String customerAccountId = inquiryResponse.getCustomerAccountId();
            final Double totalAmount = inquiryResponse.getTotalAmount();
            final LocalDate dueDate = inquiryResponse.getDueDate();

            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setBillerId(billerId);
            paymentRequest.setCustomerAccountId(customerAccountId);
            paymentRequest.setTotalAmount(totalAmount);
            paymentRequest.setDueDate(dueDate);

            PaymentResponse response = new PaymentResponse();
            switch (billerCategory) {
                case PDAM:
                    response = restTemplate.postForObject(
                            "http://billing-pdam-client/api/pay/",
                            paymentRequest,
                            PaymentResponse.class);
                    break;
                case POSTPAID:
                    response = restTemplate.postForObject(
                            "http://billing-postpaid-client/api/pay/",
                            paymentRequest,
                            PaymentResponse.class);
                    break;
                default:
                    break;
            }
            Bill bill = addBillHistory(response);
            return bill;
        } catch (Exception e) {
            throw e.getCause();
        }
    }
}

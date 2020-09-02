package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import com.charles.billing_service.models.Bills;
import com.charles.billing_service.models.InquiryRequest;
import com.charles.billing_service.models.InquiryResponse;
import com.charles.billing_service.repository.InquiryResponseRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/biller/{billerId}")
    @ApiOperation(value = "Find Biller by billerId",
            notes = "Provide a billerId to look up specific biller",
            response = Biller.class)
    public Biller getBiller(
            @ApiParam(value = "ID value for the biller that need to be retrieved", required = true)
            @PathVariable("billerId")
                    String billerId) {
        return new Biller("halo", "Halo", "postpaid");
    }

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

    @PostMapping("/inquiry")
    public InquiryResponse doInquiry(@RequestBody InquiryRequest inquiryRequest) {
        final String billerId = inquiryRequest.getBillerId();
        final Biller biller = getBiller(billerId);
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
}

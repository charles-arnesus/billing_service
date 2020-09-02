package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import com.charles.billing_service.models.Bills;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class BillingServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/biller/{billerId}")
    @ApiOperation(value = "Find Biller by billerId",
            notes = "Provide a billerId to look up specific biller",
            response = Biller.class)
    public Biller getBiller(
            @ApiParam(value = "ID value for the biller that need to be retrieved", required = true)
            @PathVariable("billerId")
                    String billerId) {
        return new Biller("pdam_bandung", "PDAM Tirtawening", "pdam");
    }

    @GetMapping("history/{userId}")
    @ApiOperation(value = "Retrieve all payment history by userId",
            notes = "Provide a userId to retrieve all payment history",
            response = Bills.class)
    public Bills getAllBillHistory(
            @ApiParam(value = "ID value for the payment history that need to be retrieved", required = true)
            @PathVariable("userId")
                    String userId) {
        return restTemplate.getForObject("http://localhost:8082/api/history/" + userId, Bills.class);
    }
}

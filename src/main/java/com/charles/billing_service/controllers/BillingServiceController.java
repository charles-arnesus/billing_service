package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/biller")
public class BillingServiceController {

    @GetMapping("/{billerId}")
    public Biller getBiller(@PathVariable("billerId") String billerId){
        return new Biller("pdam_bandung", "PDAM Tirtawening", "pdam");
    }
}

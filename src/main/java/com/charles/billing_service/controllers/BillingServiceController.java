package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/biller")
public class BillingServiceController {

    @RequestMapping("/{billerId}")
    public List<Biller> getBiller(@PathVariable("billerId") String billerId){
        return Collections.singletonList(
                new Biller("pdam_bandung", "PDAM Tirtawening", "pdam")
        );
    }
}

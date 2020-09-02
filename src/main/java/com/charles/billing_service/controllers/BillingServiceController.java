package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillingServiceController {

    @GetMapping("/biller/{billerId}")
    @ApiOperation(value = "Find Biller by billerId",
    notes = "Provide a billerId to look up specific biller",
    response = Biller.class)
    public Biller getBiller(
            @ApiParam(value = "ID value for the biller that need to retrieve", required = true)
            @PathVariable("billerId")
                    String billerId){
        return new Biller("pdam_bandung", "PDAM Tirtawening", "pdam");
    }
}

package com.charles.billing_service.controllers;

import com.charles.billing_service.models.Biller;
import com.charles.billing_service.repository.BillerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biller")
public class BillerController {

    @Autowired
    private BillerRepository billerRepository;

    @GetMapping("/{billerId}")
    @ApiOperation(value = "Find Biller by billerId",
            notes = "Provide a billerId to look up specific biller",
            response = Biller.class)
    public Biller getBiller(
            @ApiParam(value = "ID value for the biller that need to be retrieved", required = true)
            @PathVariable("billerId")
                    String billerId) {
        return billerRepository.findByBillerId(billerId);
    }

    @PostMapping("/")
    public Biller addBiller(@RequestBody Biller biller){
        return billerRepository.save(biller);
    }

}

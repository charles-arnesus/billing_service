package com.charles.billing_service.repository;

import com.charles.billing_service.models.Biller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillerRepository extends JpaRepository<Biller, String> {
    Biller findByBillerId(String billerId);

    Biller save(Biller biller);
}

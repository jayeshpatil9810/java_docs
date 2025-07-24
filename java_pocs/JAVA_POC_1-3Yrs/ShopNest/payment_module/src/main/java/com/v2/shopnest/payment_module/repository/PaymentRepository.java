package com.v2.shopnest.payment_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2.shopnest.payment_module.model.CompletedOrder;

public interface PaymentRepository extends JpaRepository<CompletedOrder, String>{

    public CompletedOrder findByPayId(String payId);
    
}

package com.ecommerce.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.major.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{

}

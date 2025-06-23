package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}

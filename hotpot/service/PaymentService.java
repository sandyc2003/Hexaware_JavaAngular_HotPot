package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.Payment;

public interface PaymentService {
    Payment addPayment(Payment payment, Long orderId);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    Payment updatePayment(Long id, Payment payment);
    void deletePayment(Long id);

}

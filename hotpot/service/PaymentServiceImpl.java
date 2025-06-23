package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.Order;
import com.hexaware.hotpot.entities.Payment;
import com.hexaware.hotpot.repository.OrderRepository;
import com.hexaware.hotpot.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository; 
    
    @Override
    public Payment addPayment(Payment payment, Long orderId) {
    	Order existingOrder = orderRepository.findById(orderId)
    	        .orElseThrow(() -> new RuntimeException("Order not found"));

    	    payment.setOrder(existingOrder);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment existingPayment = optionalPayment.get();
            existingPayment.setPaymentMode(updatedPayment.getPaymentMode());
            existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
            existingPayment.setTransactionId(updatedPayment.getTransactionId());
            existingPayment.setPaymentTime(updatedPayment.getPaymentTime());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }
    @Override
    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found"));

        Order order = payment.getOrder();
        if (order != null) {
            order.setPayment(null);  
        }

        paymentRepository.delete(payment);
    }

    
    
}

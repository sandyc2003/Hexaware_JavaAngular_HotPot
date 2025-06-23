package com.hexaware.hotpot.dto;

import java.time.LocalDateTime;

public class PaymentDto {
    private Long id;
    private String paymentMode;
    private String paymentStatus;
    private String transactionId;
    private LocalDateTime paymentTime;
    private Long orderId;     // Only the order id, not the whole order

    public PaymentDto() {}

	public PaymentDto(Long id, String paymentMode, String paymentStatus, String transactionId,
			LocalDateTime paymentTime, Long orderId) {
		super();
		this.id = id;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.paymentTime = paymentTime;
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
    
}

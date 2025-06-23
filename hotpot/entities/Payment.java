package com.hexaware.hotpot.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Payment mode is required")
    private String paymentMode;
    @NotBlank(message = "Payment status is required")
    private String paymentStatus;  
    private String transactionId;  
    private LocalDateTime paymentTime;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, String paymentMode, String paymentStatus, String transactionId, LocalDateTime paymentTime,
			Order order) {
		super();
		this.id = id;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.paymentTime = paymentTime;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus
				+ ", transactionId=" + transactionId + ", paymentTime=" + paymentTime + ", order=" + order + "]";
	}
    
    
}

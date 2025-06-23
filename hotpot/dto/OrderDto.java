package com.hexaware.hotpot.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Long id;
    private Long userId;
    private String username;
    private Long restaurantId;
    private String restaurantName;
    private Long addressId;
    private String address; 
    private Long paymentId;
    private Double totalPrice;
    private String status;
    private LocalDateTime orderTime;
    private List<OrderItemDto> orderItems; // Use your OrderItemDto!

    public OrderDto() {}

	public OrderDto(Long id, Long userId, String username, Long restaurantId, String restaurantName, Long addressId,
			String address, Long paymentId, Double totalPrice, String status, LocalDateTime orderTime,
			List<OrderItemDto> orderItems) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.addressId = addressId;
		this.address = address;
		this.paymentId = paymentId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderTime = orderTime;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

    
}


package com.hexaware.hotpot.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "orders")
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantDetails restaurant;
    
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address shippingAddress;
    
    @OneToOne(mappedBy = "order")
    private Payment payment;


    private double totalPrice;
    @NotBlank(message = "Order status is required")
    private String status;
    private LocalDateTime orderTime;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, User user, RestaurantDetails restaurant, Address shippingAddress, Payment payment,
			double totalPrice, @NotBlank(message = "Order status is required") String status, LocalDateTime orderTime,
			List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.user = user;
		this.restaurant = restaurant;
		this.shippingAddress = shippingAddress;
		this.payment = payment;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RestaurantDetails getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDetails restaurant) {
		this.restaurant = restaurant;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
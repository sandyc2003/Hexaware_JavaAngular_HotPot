package com.hexaware.hotpot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    @Min(value = 0, message = "Price must be non-negative")
    private double price;

    
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(Long id, Order order, MenuItem menuItem, int quantity, double price) {
		super();
		this.id = id;
		this.order = order;
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.price = price;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public MenuItem getMenuItem() {
		return menuItem;
	}


	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", menuItem=" + menuItem + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}

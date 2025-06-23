package com.hexaware.hotpot.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_details")
public class RestaurantDetails {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantName;
    private String location;
    private String contact;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;
    
	public RestaurantDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDetails(Long id, String restaurantName, String location, String contact, User user,
			List<MenuItem> menuItems, List<Order> orders) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.location = location;
		this.contact = contact;
		this.user = user;
		this.menuItems = menuItems;
		this.orders = orders;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "RestaurantDetails [id=" + id + ", restaurantName=" + restaurantName + ", location=" + location
				+ ", contact=" + contact + ", user=" + user + "]";
	}
}

package com.hexaware.hotpot.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item name is required")
    private String itemName;
    private String description;
    @NotBlank(message = "Category is required")
    private String category;
    @Min(value = 1, message = "Price must be at least 1")
    private Double price;
    @NotBlank(message = "Availability time is required")
    private String availabilityTime;
    @NotBlank(message = "Dietary info is required")
    private String dietaryInfo;
    private String tasteInfo;
    private String nutritionalInfo;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantDetails restaurant;

    @OneToMany(mappedBy = "menuItem")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "menuItem")
    private List<OrderItem> orderItems;

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(Long id, String itemName, String description, String category,
			 Double price,String availabilityTime,String dietaryInfo, String tasteInfo,String nutritionalInfo, Boolean available, RestaurantDetails restaurant, List<CartItem> cartItems,
			List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.category = category;
		this.price = price;
		this.availabilityTime = availabilityTime;
		this.dietaryInfo = dietaryInfo;
		this.tasteInfo = tasteInfo;
		this.nutritionalInfo = nutritionalInfo;
		this.available = available;
		this.restaurant = restaurant;
		this.cartItems = cartItems;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAvailabilityTime() {
		return availabilityTime;
	}

	public void setAvailabilityTime(String availabilityTime) {
		this.availabilityTime = availabilityTime;
	}

	public String getDietaryInfo() {
		return dietaryInfo;
	}

	public void setDietaryInfo(String dietaryInfo) {
		this.dietaryInfo = dietaryInfo;
	}

	public String getTasteInfo() {
		return tasteInfo;
	}

	public void setTasteInfo(String tasteInfo) {
		this.tasteInfo = tasteInfo;
	}

	public String getNutritionalInfo() {
		return nutritionalInfo;
	}

	public void setNutritionalInfo(String nutritionalInfo) {
		this.nutritionalInfo = nutritionalInfo;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public RestaurantDetails getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDetails restaurant) {
		this.restaurant = restaurant;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", description=" + description + ", category="
				+ category + ", price=" + price + ", availabilityTime=" + availabilityTime + ", dietaryInfo="
				+ dietaryInfo + ", tasteInfo=" + tasteInfo + ", nutritionalInfo=" + nutritionalInfo + ", available="
				+ available + ", restaurant=" + restaurant + ", cartItems=" + cartItems + ", orderItems=" + orderItems
				+ "]";
	}
	
	

	
}

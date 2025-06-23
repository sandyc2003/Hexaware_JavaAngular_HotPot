package com.hexaware.hotpot.dto;

public class MenuItemDto {
    private Long id;
    private String itemName;
    private String description;
    private String category;
    private Double price;
    private String availabilityTime;
    private String dietaryInfo;
    private String tasteInfo;
    private String nutritionalInfo;
    private Boolean available;
    private Long restaurantId;        // Only the id of the restaurant
    private String restaurantName;    // Restaurant name
	public MenuItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuItemDto(Long id, String itemName, String description, String category, Double price,
			String availabilityTime, String dietaryInfo, String tasteInfo, String nutritionalInfo, Boolean available,
			Long restaurantId, String restaurantName) {
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
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
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
}
    
    

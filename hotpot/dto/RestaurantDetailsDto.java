package com.hexaware.hotpot.dto;

public class RestaurantDetailsDto {
    private Long id;
    private String restaurantName;
    private String location;
    private String contact;
    private String ownerUsername;
	public RestaurantDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDetailsDto(Long id, String restaurantName, String location, String contact, String ownerUsername) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.location = location;
		this.contact = contact;
		this.ownerUsername = ownerUsername;
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
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
    
    
}

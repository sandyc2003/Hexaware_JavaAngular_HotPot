package com.hexaware.hotpot.dto;

public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private Long userId;
    private String username;

    public AddressDto() {}

	public AddressDto(Long id, String street, String city, String state, String pincode, String country, Long userId,
			String username) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.userId = userId;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

    
}


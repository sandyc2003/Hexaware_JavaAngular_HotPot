package com.hexaware.hotpot.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;

public class RegisterDto {
    private String name;
    private String userName;
    private String email;
    private String password;
    @NotBlank(message="Role is required")
    private Set<String> roles;

    private String gender; // CUSTOMER only
    private String contactNumber; // CUSTOMER & RESTAURANT
    private String restaurantName; // RESTAURANT only
    private String location; // RESTAURANT only

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + ", gender=" + gender + ", contactNumber=" + contactNumber + ", restaurantName="
				+ restaurantName + ", location=" + location + "]";
	}
    
}


package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.entities.RestaurantDetails;
import com.hexaware.hotpot.service.RestaurantDetailsService;

@RestController
@RequestMapping("/api/restaurants")

public class RestaurantDetailsController {

    @Autowired
    private RestaurantDetailsService restaurantService;

    @PostMapping
    @PreAuthorize("hasRole('RESTAURANT')")
    public RestaurantDetails addRestaurant(@RequestBody RestaurantDetails restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'RESTAURANT')")
    public RestaurantDetails updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDetails restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('RESTAURANT')")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'RESTAURANT', 'CUSTOMER')")
    public RestaurantDetails getById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RESTAURANT', 'CUSTOMER')")
    public List<RestaurantDetails> getAll() {
        return restaurantService.getAllRestaurants();
    }
}

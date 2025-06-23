package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.RestaurantDetails;

public interface RestaurantDetailsService {
    RestaurantDetails addRestaurant(RestaurantDetails restaurant);
    RestaurantDetails updateRestaurant(Long id, RestaurantDetails restaurant);
    void deleteRestaurant(Long id);
    RestaurantDetails getRestaurantById(Long id);
    List<RestaurantDetails> getAllRestaurants();
}

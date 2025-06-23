package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.RestaurantDetails;
import com.hexaware.hotpot.repository.RestaurantDetailsRepository;

@Service
public class RestaurantDetailsServiceImpl implements RestaurantDetailsService {

    @Autowired
    private RestaurantDetailsRepository restaurantRepo;

    @Override
    public RestaurantDetails addRestaurant(RestaurantDetails restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public RestaurantDetails updateRestaurant(Long id, RestaurantDetails updatedData) {
        RestaurantDetails existing = restaurantRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        String currentUsername = getCurrentUsername();

        // Allow only admin or the restaurant owner
        if (!hasRole("ROLE_RESTAURANT") &&
            !existing.getUser().getUserName().equals(currentUsername)) {
            throw new AccessDeniedException("You are not authorized to update this restaurant.");
        }

        existing.setRestaurantName(updatedData.getRestaurantName());
        existing.setLocation(updatedData.getLocation());
        existing.setContact(updatedData.getContact());

        return restaurantRepo.save(existing);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteById(id);
    }

    @Override
    public RestaurantDetails getRestaurantById(Long id) {
        return restaurantRepo.findById(id).orElse(null);
    }

    @Override
    public List<RestaurantDetails> getAllRestaurants() {
        return restaurantRepo.findAll();
    }


    private String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private boolean hasRole(String roleName) {
        return SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals(roleName));
    }
}

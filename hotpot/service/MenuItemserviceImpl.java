package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.MenuItem;
import com.hexaware.hotpot.repository.MenuItemRepository;

@Service
public class MenuItemserviceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepo.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepo.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
        MenuItem existing = getMenuItemById(id);
        String currentUsername = getCurrentUsername();

        if (!hasRole("ROLE_ADMIN") &&
            !existing.getRestaurant().getUser().getUserName().equals(currentUsername)) {
            throw new AccessDeniedException("You are not authorized to update this menu item.");
        }

        if (updatedItem.getItemName() != null)
            existing.setItemName(updatedItem.getItemName());

        if (updatedItem.getDescription() != null)
            existing.setDescription(updatedItem.getDescription());

        if (updatedItem.getCategory() != null)
            existing.setCategory(updatedItem.getCategory());

        if (updatedItem.getPrice() != null)
            existing.setPrice(updatedItem.getPrice());

        if (updatedItem.getAvailabilityTime() != null)
            existing.setAvailabilityTime(updatedItem.getAvailabilityTime());

        if (updatedItem.getDietaryInfo() != null)
            existing.setDietaryInfo(updatedItem.getDietaryInfo());

        if (updatedItem.getTasteInfo() != null)
            existing.setTasteInfo(updatedItem.getTasteInfo());

        if (updatedItem.getNutritionalInfo() != null)
            existing.setNutritionalInfo(updatedItem.getNutritionalInfo());

        if (updatedItem.getAvailable() != null)
            existing.setAvailable(updatedItem.getAvailable());

        return menuItemRepo.save(existing);
    }

    @Override
    public void deleteMenuItem(Long id) {
        MenuItem existing = getMenuItemById(id);
        String currentUsername = getCurrentUsername();

        if (!hasRole("ROLE_ADMIN") &&
            !existing.getRestaurant().getUser().getUserName().equals(currentUsername)) {
            throw new AccessDeniedException("You are not authorized to delete this menu item.");
        }

        menuItemRepo.deleteById(id);
    }

  
    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    private boolean hasRole(String roleName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream()
            .anyMatch(granted -> granted.getAuthority().equals(roleName));
    }
}

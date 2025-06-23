package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.MenuItem;

public interface MenuItemService {
    MenuItem addMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Long id);
    MenuItem updateMenuItem(Long id, MenuItem updatedItem);
    void deleteMenuItem(Long id);
}


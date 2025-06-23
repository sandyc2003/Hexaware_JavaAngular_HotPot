package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.entities.MenuItem;
import com.hexaware.hotpot.service.MenuItemService;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;

	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('RESTAURANT', 'ADMIN')")
	public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem){
		MenuItem savedItem = menuItemService.addMenuItem(menuItem);
		return ResponseEntity.ok(savedItem);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
	public ResponseEntity<List<MenuItem>> getAllmenuItem(){
		return ResponseEntity.ok(menuItemService.getAllMenuItems());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(id));
    }
	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyRole('RESTAURANT', 'ADMIN')")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedItem) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(id, updatedItem));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('RESTAURANT', 'ADMIN')")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.ok("Menu item deleted successfully");
    }

}

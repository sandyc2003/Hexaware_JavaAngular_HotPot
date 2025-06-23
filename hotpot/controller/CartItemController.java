package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.CartItem;
import com.hexaware.hotpot.service.CartItemService;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public CartItem addToCart(@RequestBody CartItemDto cartItemDto) {
        return cartItemService.addToCart(cartItemDto);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUserId(userId);
    }

    @DeleteMapping("/{cartItemId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void removeItem(@PathVariable Long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }

    @DeleteMapping("/clear/{userId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void clearCart(@PathVariable Long userId) {
        cartItemService.clearCart(userId);
    }
}

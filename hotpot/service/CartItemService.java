package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.CartItem;

public interface CartItemService {
	CartItem addToCart(CartItemDto dto);
    List<CartItem> getCartItemsByUserId(Long userId);
    void removeCartItem(Long cartItemId);
    void clearCart(Long userId);
}

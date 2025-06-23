package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.CartItem;
import com.hexaware.hotpot.entities.MenuItem;
import com.hexaware.hotpot.entities.User;
import com.hexaware.hotpot.repository.CartItemRepository;
import com.hexaware.hotpot.repository.MenuItemRepository;
import com.hexaware.hotpot.repository.UserRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Override
    public CartItem addToCart(CartItemDto dto) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(dto.getQuantity());

        Optional<User> userOpt = userRepo.findById(dto.getUserId());
        userOpt.ifPresent(cartItem::setUser);

        Optional<MenuItem> menuItemOpt = menuItemRepo.findById(dto.getMenuItemId());
        menuItemOpt.ifPresent(cartItem::setMenuItem);

        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItemsByUserId(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        Optional<CartItem> itemOpt = cartItemRepository.findById(cartItemId);
        itemOpt.ifPresent(item -> cartItemRepository.deleteById(cartItemId));
    }

    @Override
    public void clearCart(Long userId) {
        List<CartItem> items = cartItemRepository.findByUserId(userId);
        cartItemRepository.deleteAll(items);
    }
}

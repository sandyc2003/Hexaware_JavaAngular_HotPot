package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.OrderItem;
import com.hexaware.hotpot.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem updatedItem) {
        Optional<OrderItem> optional = orderItemRepository.findById(id);
        if (optional.isPresent()) {
            OrderItem existing = optional.get();
            String currentUsername = getCurrentUsername();

            if (!hasRole("ROLE_ADMIN") &&
                !existing.getOrder().getUser().getUserName().equals(currentUsername)) {
                throw new AccessDeniedException("You are not authorized to update this order item.");
            }

            existing.setQuantity(updatedItem.getQuantity());
            existing.setPrice(updatedItem.getPrice());
            existing.setMenuItem(updatedItem.getMenuItem());
            existing.setOrder(updatedItem.getOrder());

            return orderItemRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(Long id) {
        Optional<OrderItem> optional = orderItemRepository.findById(id);
        if (optional.isPresent()) {
            OrderItem item = optional.get();
            String currentUsername = getCurrentUsername();

            if (!hasRole("ROLE_ADMIN") &&
                !item.getOrder().getUser().getUserName().equals(currentUsername)) {
                throw new AccessDeniedException("You are not authorized to delete this order item.");
            }

            orderItemRepository.deleteById(id);
        }
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

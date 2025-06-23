package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.Order;

public interface OrderService {
    Order placeOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
    List<Order> getAllOrders();
    Order updateOrderStatus(Long orderId, String status);
    void deleteOrder(Long orderId);
}

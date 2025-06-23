package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.OrderItem;

public interface OrderItemService {
    OrderItem addOrderItem(OrderItem orderItem);
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItemById(Long id);
    OrderItem updateOrderItem(Long id, OrderItem orderItem);
    void deleteOrderItem(Long id);
}

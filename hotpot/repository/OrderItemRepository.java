package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}

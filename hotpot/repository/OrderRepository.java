package com.hexaware.hotpot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByUserId(Long userId);

}

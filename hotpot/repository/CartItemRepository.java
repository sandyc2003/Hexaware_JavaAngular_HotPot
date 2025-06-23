package com.hexaware.hotpot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	 List<CartItem> findByUserId(Long userId);
}

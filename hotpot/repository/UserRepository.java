package com.hexaware.hotpot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName, String email);


}

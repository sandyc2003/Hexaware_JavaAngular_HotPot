package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hotpot.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}

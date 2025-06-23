package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.AddressDto;
import com.hexaware.hotpot.entities.Address;

public interface AddressService {
	Address addAddress(AddressDto dto);
	Address updateAddress(Long id, AddressDto dto);
    void deleteAddress(Long id);
    AddressDto getAddressById(Long id);
    List<AddressDto> getAllAddresses();
}

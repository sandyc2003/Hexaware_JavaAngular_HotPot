package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.AddressDto;
import com.hexaware.hotpot.entities.Address;
import com.hexaware.hotpot.entities.User;
import com.hexaware.hotpot.repository.AddressRepository;
import com.hexaware.hotpot.repository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Address addAddress(AddressDto dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPincode(dto.getPincode());
        address.setCountry(dto.getCountry());

        Optional<User> userOpt = userRepo.findById(dto.getUserId());
        userOpt.ifPresent(address::setUser);

        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, AddressDto dto) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        if (addressOpt.isPresent()) {
            Address address = addressOpt.get();
            address.setStreet(dto.getStreet());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setPincode(dto.getPincode());
            address.setCountry(dto.getCountry());

            if (dto.getUserId() != null) {
                Optional<User> userOpt = userRepo.findById(dto.getUserId());
                userOpt.ifPresent(address::setUser);
            }

            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        }
    }

    @Override
    public AddressDto getAddressById(Long id) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        return addressOpt.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Utility method to convert entity to DTO
    private AddressDto convertToDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPincode(address.getPincode());
        dto.setCountry(address.getCountry());
        if (address.getUser() != null) {
            dto.setUserId(address.getUser().getId());
        }
        return dto;
    }
}

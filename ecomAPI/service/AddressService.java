package com.ecomapi.ecomAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.ecomAPI.model.Address;
import com.ecomapi.ecomAPI.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
}

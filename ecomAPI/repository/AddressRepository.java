package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

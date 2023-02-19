package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

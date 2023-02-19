package com.ecomapi.ecomAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.ecomAPI.model.Order;
import com.ecomapi.ecomAPI.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}

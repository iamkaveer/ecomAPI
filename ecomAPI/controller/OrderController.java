package com.ecomapi.ecomAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.model.Order;
import com.ecomapi.ecomAPI.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
	    Optional<Order> optionalOrder = orderRepository.findById(id);
	    if (optionalOrder.isPresent()) {
	        return ResponseEntity.ok(optionalOrder.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@PostMapping("/create")
	public Order createOrder(@RequestBody Order order) {
	    return orderRepository.save(order);
	}

}

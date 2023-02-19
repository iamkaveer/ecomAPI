package com.ecomapi.ecomAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
}

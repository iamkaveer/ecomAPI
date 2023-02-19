package com.ecomapi.ecomAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.ecomAPI.model.Product;
import com.ecomapi.ecomAPI.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
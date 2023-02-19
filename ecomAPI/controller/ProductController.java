package com.ecomapi.ecomAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.model.Product;
import com.ecomapi.ecomAPI.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/all-products")
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}
	
	@GetMapping("/get-product//{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
	    Optional<Product> optionalProduct = productRepository.findById(id);
	    if (optionalProduct.isPresent()) {
	        return ResponseEntity.ok(optionalProduct.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/create-product")
	public Product createProduct(@RequestBody Product product) {
	    return productRepository.save(product);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
	    Optional<Product> optionalProduct = productRepository.findById(id);
	    if (optionalProduct.isPresent()) {
	        productRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping(params = "category")
	public List<Product> getProductsByCategory(@RequestParam String category) {
	    return productRepository.findByCategory(category);
	}
}

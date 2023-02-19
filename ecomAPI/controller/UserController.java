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
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.ecomAPI.model.User;
import com.ecomapi.ecomAPI.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserRepository userRepository;
	
	@GetMapping("all-users")
    public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        return ResponseEntity.ok(optionalUser.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {
	    return userRepository.save(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        userRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}

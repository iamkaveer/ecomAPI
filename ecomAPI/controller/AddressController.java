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

import com.ecomapi.ecomAPI.model.Address;
import com.ecomapi.ecomAPI.repository.AddressRepository;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/get-all")
	public List<Address> getAllAddresses() {
	    return addressRepository.findAll();
	}

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
	    Optional<Address> optionalAddress = addressRepository.findById(id);
	    if (optionalAddress.isPresent()) {
	        return ResponseEntity.ok(optionalAddress.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PostMapping("/create")
	public Address createAddress(@RequestBody Address address) {
	    return addressRepository.save(address);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
	    Optional<Address> optionalAddress = addressRepository.findById(id);
	    if (optionalAddress.isPresent()) {
	        addressRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}

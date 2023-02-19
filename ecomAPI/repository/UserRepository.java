package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

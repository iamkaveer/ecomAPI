package com.ecomapi.ecomAPI.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    
    //one customer can have many address
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ua_fkey", referencedColumnName = "id")
    private List<Address> addressList;
    
}

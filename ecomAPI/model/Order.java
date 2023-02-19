package com.ecomapi.ecomAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;

    private Integer productQuantity;

}

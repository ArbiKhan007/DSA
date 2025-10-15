package com.nearbuy.backend.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Table(name = "carts")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    double totalPrice;
    @OneToOne
    User customer;
    @OneToMany
    List<CartProduct> cartProducts;
}


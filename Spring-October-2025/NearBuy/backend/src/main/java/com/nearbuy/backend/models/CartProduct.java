package com.nearbuy.backend.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cart-products")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    UUID cartId;
    UUID productId;
    int quantity;
    double price;
}

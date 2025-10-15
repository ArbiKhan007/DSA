package com.nearbuy.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String productName;
    String productSpecification;
    String manufacturer;
    String price;
    double discount;
    @ManyToOne
    Shop shop;
    String category;
    @OneToMany
    List<ProductImageLink> productImageLinks;
}

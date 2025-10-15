package com.nearbuy.backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product-image-links")
public class ProductImageLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String imageLink;
}

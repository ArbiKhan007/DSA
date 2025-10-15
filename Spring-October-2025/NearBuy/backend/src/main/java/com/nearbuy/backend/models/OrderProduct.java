package com.nearbuy.backend.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    UUID oid;
    UUID pid;
    int quantity;
    double price;
}

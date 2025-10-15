package com.nearbuy.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int oid;
    int pid;
    int quantity;
    double price;
}

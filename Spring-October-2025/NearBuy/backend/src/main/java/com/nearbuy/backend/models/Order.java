package com.nearbuy.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    double totalPrice;
    @ManyToOne
    User customer;
    String state;
    @ManyToOne
    Shop shop;
    @ManyToOne
    User deliveryPartner;
    LocalDateTime assignedDateTime;
    LocalDateTime deliveredDateTime;
    LocalDateTime placedDateTime;
    @OneToMany
    List<OrderProduct> orderProductList;
}

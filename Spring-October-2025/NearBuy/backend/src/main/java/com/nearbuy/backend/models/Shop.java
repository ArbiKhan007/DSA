package com.nearbuy.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "shops")
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String shopName;
    private String gstNumber;
    private String state;
    private int pincode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private Long phoneNumber;
    @OneToOne
    private User shopkeeper;
}

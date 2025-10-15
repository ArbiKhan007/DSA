package com.nearbuy.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "registration-requests")
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    Shop shop;
    String shopDescription;
    @OneToMany
    List<Activity> activities;
}

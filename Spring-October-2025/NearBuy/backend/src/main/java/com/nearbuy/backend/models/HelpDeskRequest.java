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
@Table(name = "help-desk-requests")
@Entity
public class HelpDeskRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String query;
    String state;
    @ManyToOne
    User assignedTo;
    @OneToMany
    List<Activity> activities;
}

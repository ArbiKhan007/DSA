package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "subflightbookedseat")
public class SubFlightSeatBooked extends SeatBooked{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    SubFlight flight;
    @ManyToOne
    AppUser bookedBy;
}

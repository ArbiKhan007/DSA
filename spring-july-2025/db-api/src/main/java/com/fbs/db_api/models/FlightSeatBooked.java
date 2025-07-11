package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.util.UUID;

/*
This booking table we are strictly going to use for non connecting flights
 */
@Entity
@Table(name = "flightbookedseats")
public class FlightSeatBooked extends SeatBooked {
    // id	flightId	seatnum	passengerId	bookingid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Flight flight;
    @ManyToOne
    AppUser bookedBy;
}

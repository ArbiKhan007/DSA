package com.fbs.db_api.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

/*
This booking table we are strictly going to use for non connecting flights
 */
public class FlightSeatBooked {
    // id	flightId	seatnum	passengerId	bookingid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Flight flight;
    @ManyToOne
    AppUser bookedBy;
    String passengerName;
    boolean above18;
    int seatNumber;
}

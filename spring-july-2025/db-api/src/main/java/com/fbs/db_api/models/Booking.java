package com.fbs.db_api.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

/*
This class is going to represent booking details
Direct Flight -> Delhi to Mumbai (subFlight list will be empty)
Connecting Flight -> SubFlight list will have all the subflight passenger is going to cover
// Delhi to Mumbai to Chandigarh to Sikkim
// subflight - > [(Delhi to mumbai), (mumbai to chandigarh)]
 */
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    Flight flight;
    List<SubFlight> subFlights;

}

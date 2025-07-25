package com.fbs.db_api.controllers;

import com.fbs.db_api.models.Flight;
import com.fbs.db_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/flight")
public class FlightController {

    FlightRepository flightRepository;
    @Autowired
    public FlightController(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @PostMapping("/create")
    public Flight createFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return flight;
    }
}

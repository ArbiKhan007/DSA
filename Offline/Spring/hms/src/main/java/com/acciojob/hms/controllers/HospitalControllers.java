package com.acciojob.hms.controllers;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalControllers {

    // http://localhost:8080/api/v1/hospital/register
    @PostMapping("/register")


    @GetMapping("/get/{id}")
}

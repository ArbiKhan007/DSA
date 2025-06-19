package com.naukri.central_api.controller;

import com.naukri.central_api.dto.CompanyRegistrationDto;
import com.naukri.central_api.models.Company;
import com.naukri.central_api.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api/v1/central/company")
public class CompanyController {

    CompanyService companyService;
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }


    @PostMapping("/register")
    public ResponseEntity registerCompany(@RequestBody CompanyRegistrationDto companyRegistrationDto){

        // CompanyService -> To save company details to the database.
        Company company = companyService.registerCompany(companyRegistrationDto);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

}

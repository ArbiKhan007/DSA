package com.acciojob.hms.controllers;

import com.acciojob.hms.models.Hospital;
import com.acciojob.hms.models.Patient;
import com.acciojob.hms.service.HospitalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospital")
@Slf4j
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    /**
     * This function will get triggered when endpoint http://localhost:8080/api/v1/hospital/register
     * will get triggered
     * This functuion will be internally calling hospitalService registerHospital method and in which
     * we will be passing the hospital object which have recieved from the client that can be frontend or postman
     * @param hospital
     */
   @PostMapping("/register")
    public void registerHospital(@RequestBody Hospital hospital){
        log.info("Got hospital model object from the client : " + hospital);
        log.info("Calling Hospital Service");
        hospitalService.registerHospital(hospital);
    }
}

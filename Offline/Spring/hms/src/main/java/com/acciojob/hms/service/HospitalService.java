package com.acciojob.hms.service;

import com.acciojob.hms.models.Hospital;
import com.acciojob.hms.repositries.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    /**
     * Work of this function is to save hospital object in the database.
     * As it is service layer function inside this we will be calculating ID for the hospital
     * And then will be calling hospital repository to save hospital inside the database.
     * @param hospital
     */
    public void registerHospital(Hospital hospital){
        // 1st Step we need to calculate the id for this hospital.
        int id = hospitalRepository.getTotalHospital() + 1;
        hospital.setId(id);
        hospitalRepository.saveHospital(id, hospital);
    }
}

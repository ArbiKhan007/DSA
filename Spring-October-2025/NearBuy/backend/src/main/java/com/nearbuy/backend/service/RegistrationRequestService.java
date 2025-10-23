package com.nearbuy.backend.service;

import com.nearbuy.backend.models.RegistrationRequest;
import com.nearbuy.backend.repositories.RegistrationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService {

    @Autowired
    RegistrationRequestRepository registrationRequestRepository;

    public RegistrationRequest saveOrUpdate(RegistrationRequest registrationRequest){
        return registrationRequestRepository.save(registrationRequest);
    }
}

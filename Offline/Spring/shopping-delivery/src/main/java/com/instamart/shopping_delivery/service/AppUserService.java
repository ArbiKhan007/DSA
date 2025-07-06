package com.instamart.shopping_delivery.service;

import com.instamart.shopping_delivery.models.AppUser;
import com.instamart.shopping_delivery.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

   AppUserRepository appUserRepository;

   @Autowired
   public AppUserService(AppUserRepository appUserRepository){
       this.appUserRepository = appUserRepository;
   }

    public void saveUser(AppUser user){
        appUserRepository.save(user);
        appUserRepository.findAll();
        appUserRepository.delete(user);
    }
}

package com.instamart.shopping_delivery.service;

import com.instamart.shopping_delivery.exceptions.InvalidOperationException;
import com.instamart.shopping_delivery.exceptions.UserNotExistException;
import com.instamart.shopping_delivery.models.AppUser;
import com.instamart.shopping_delivery.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppUserService {

   AppUserRepository appUserRepository;

   @Autowired
   public AppUserService(AppUserRepository appUserRepository){
       this.appUserRepository = appUserRepository;
   }

   public AppUser registerCustomer(AppUser customer){
       return appUserRepository.save(customer);
   }

   public AppUser wareHouseAdminInvite(UUID userId, AppUser wareHouseAdmin){
       // 1. First verify user who is inviting is of type appadmin or not.
       AppUser admin = appUserRepository.findById(userId).orElse(null);
       if(admin == null){
           // Throw exception that user does not exist
           throw new UserNotExistException("user does not exist");
       }
       if(!admin.getUserType().equals("APP_ADMIN")){
           throw new InvalidOperationException("User is not allowed to invite warehosue admim");
       }
       wareHouseAdmin.setStatus("INACTIVE");
       return appUserRepository.save(wareHouseAdmin);
   }
}

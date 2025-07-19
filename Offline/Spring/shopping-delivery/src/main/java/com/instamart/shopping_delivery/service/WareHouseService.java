package com.instamart.shopping_delivery.service;

import com.instamart.shopping_delivery.dto.WareHouseRegistrationDto;
import com.instamart.shopping_delivery.exceptions.InvalidOperationException;
import com.instamart.shopping_delivery.models.AppUser;
import com.instamart.shopping_delivery.models.Location;
import com.instamart.shopping_delivery.models.WareHouse;
import com.instamart.shopping_delivery.repositories.WareHouseRepository;
import com.instamart.shopping_delivery.utility.MappingUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class WareHouseService {

    AppUserService appUserService;
    WareHouseRepository wareHouseRepository;
    LocationService locationService;
    MailService mailService;
    MappingUtility mappingUtility;
    @Autowired
    public WareHouseService(AppUserService appUserService,
                            WareHouseRepository wareHouseRepository,
                            LocationService locationService,
                            MappingUtility mappingUtility,
                            MailService mailService){
        this.appUserService = appUserService;
        this.wareHouseRepository = wareHouseRepository;
        this.locationService = locationService;
        this.mappingUtility = mappingUtility;
        this.mailService = mailService;
    }

    public WareHouse saveWareHouse(WareHouse wareHouse){
        return this.wareHouseRepository.save(wareHouse);
    }

    public WareHouse registerWareHouse(UUID userId,
                                  WareHouseRegistrationDto wareHouseRegistrationDto){
        // 1. Validate the Id belongs to app admin or not
        // So, we should what ?
        AppUser admin  = appUserService.isAppAdmin(userId);

        if(admin == null){
           throw new InvalidOperationException(String.format("User with id %s not allowed to register ware house", userId.toString()));
        }
        Location location = locationService.createLocation(wareHouseRegistrationDto.getLocation());
        // 2. Map details of wareHouse Registration DTO to WareHouse model.
        WareHouse wareHouse = mappingUtility.mapWareHouseToDtoToModel(wareHouseRegistrationDto, location);
        // 3. call Warehouse Repository to save warehouse in the warehouse table.
        wareHouse = this.saveWareHouse(wareHouse);
        // Notify Application admin that new warehouse got registered in your application.
        // We need mail service ->
        mailService.sendCreateWareHouseMail(wareHouse, admin);

        return wareHouse;
    }
}

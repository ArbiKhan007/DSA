package com.nearbuy.backend.service;

import com.nearbuy.backend.dto.RegisterShopDto;
import com.nearbuy.backend.models.RegistrationRequest;
import com.nearbuy.backend.models.Shop;
import com.nearbuy.backend.models.User;
import com.nearbuy.backend.repositories.ShopRepository;
import com.nearbuy.backend.utilities.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    MappingUtility mappingUtility;
    @Autowired
    UserService userService;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    RegistrationRequestService registrationRequestService;

    public Shop saveOrUpdateShop(Shop shop){
        return shopRepository.save(shop);
    }

    public void registerShop(RegisterShopDto registerShopDto){
        // We need to map RegisterShopDto to shop model and user Model
        // User Model
       User shopKeeper = mappingUtility.mapRegisterShopDtoToShopkeeper(registerShopDto);
       shopKeeper = userService.saveOrUpdateUser(shopKeeper);
       Shop shop = mappingUtility.mapRegisterShopDtoToShopModel(registerShopDto, shopKeeper);
       shop = this.saveOrUpdateShop(shop);
       RegistrationRequest registrationRequest = new RegistrationRequest();
       registrationRequest.setShop(shop);
       registrationRequest.setShopDescription("New Shop Registration Request");
       registrationRequestService.saveOrUpdate(registrationRequest);
    }

}

package com.nearbuy.backend.controllers;

import com.nearbuy.backend.dto.RegisterShopDto;
import com.nearbuy.backend.service.ShopService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/register")
    public void registerShop(@RequestBody RegisterShopDto registerShopDto){
        shopService.registerShop(registerShopDto);
    }
}

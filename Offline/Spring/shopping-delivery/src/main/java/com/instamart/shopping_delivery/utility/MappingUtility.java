package com.instamart.shopping_delivery.utility;

import com.instamart.shopping_delivery.dto.WareHouseRegistrationDto;
import com.instamart.shopping_delivery.models.Location;
import com.instamart.shopping_delivery.models.WareHouse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MappingUtility {

    public WareHouse mapWareHouseToDtoToModel(WareHouseRegistrationDto wareHouseRegistrationDto,
                                              Location location){
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(wareHouseRegistrationDto.getWareHouseName());
        wareHouse.setLocation(location);
        wareHouse.setCreatedAt(LocalDateTime.now());
        wareHouse.setUpdatedAt(LocalDateTime.now());
        return wareHouse;
    }
}

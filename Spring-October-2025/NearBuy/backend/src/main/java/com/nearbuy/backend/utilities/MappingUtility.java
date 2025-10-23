package com.nearbuy.backend.utilities;

import com.nearbuy.backend.dto.InviteAdminDto;
import com.nearbuy.backend.dto.InviteUserDto;
import com.nearbuy.backend.dto.RegisterShopDto;
import com.nearbuy.backend.enums.ShopState;
import com.nearbuy.backend.enums.UserState;
import com.nearbuy.backend.enums.UserType;
import com.nearbuy.backend.models.Shop;
import com.nearbuy.backend.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MappingUtility {

    public User mapInviteAdminDtoToUserObject(InviteUserDto inviteAdminDto){
        StackOverflowError stackOverflowError = new StackOverflowError();
        User user = new User();
        user.setName(inviteAdminDto.getName());
        user.setEmail(inviteAdminDto.getEmail());
        user.setPassword("TempPass@123");
        user.setUserType(UserType.ADMIN.toString());
        user.setPhoneNumber(inviteAdminDto.getPhoneNumber());
        user.setGender(inviteAdminDto.getGender());
        user.setAddressLine1(inviteAdminDto.getAddressLine1());
        user.setAddressLine2(inviteAdminDto.getAddressLine2());
        user.setAddressLine3(inviteAdminDto.getAddressLine3());
        user.setStatus(UserState.INVITED.toString());
        user.setPincode(inviteAdminDto.getPincode());
        return user;
    }

    public User mapRegisterShopDtoToShopkeeper(RegisterShopDto registerShopDto){
        User user = new User();
        user.setUserType(UserType.SHOPKEEPER.toString());
        user.setName(registerShopDto.getName());
        user.setEmail(registerShopDto.getEmail());
        user.setPassword(registerShopDto.getPassword());
        user.setPhoneNumber(registerShopDto.getPhoneNumber());
        user.setAddressLine1(registerShopDto.getAddressLine1());
        user.setAddressLine2(registerShopDto.getAddressLine2());
        user.setAddressLine3(registerShopDto.getAddressLine3());
        user.setPincode(registerShopDto.getPincode());
        user.setStatus(UserState.PENDING_REVIEW.toString());
        user.setGender(registerShopDto.getGender());
        return user;
    }

    public Shop mapRegisterShopDtoToShopModel(RegisterShopDto registerShopDto,
                                              User shopKeeper){
        Shop shop = new Shop();
        shop.setShopName(registerShopDto.getShopName());
        shop.setState(ShopState.PENDING_REVIEW.toString());
        shop.setGstNumber(registerShopDto.getGstNumber());
        shop.setPhoneNumber(registerShopDto.getShopPhoneNumber());
        shop.setPincode(registerShopDto.getPincode());
        shop.setAddressLine1(registerShopDto.getShopAddressLine1());
        shop.setAddressLine2(registerShopDto.getAddressLine2());
        shop.setAddressLine3(registerShopDto.getAddressLine3());
        shop.setShopkeeper(shopKeeper);
        return shop;
    }

}

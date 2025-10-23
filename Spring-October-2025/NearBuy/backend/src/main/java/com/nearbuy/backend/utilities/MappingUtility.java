package com.nearbuy.backend.utilities;

import com.nearbuy.backend.dto.InviteAdminDto;
import com.nearbuy.backend.dto.InviteUserDto;
import com.nearbuy.backend.enums.UserState;
import com.nearbuy.backend.enums.UserType;
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

}

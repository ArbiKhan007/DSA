package com.nearbuy.backend.service;

import com.nearbuy.backend.dto.InviteCordinatorDto;
import com.nearbuy.backend.enums.UserType;
import com.nearbuy.backend.exceptions.NotAuthorizedException;
import com.nearbuy.backend.models.User;
import com.nearbuy.backend.utilities.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CordinatorService {

    UserService userService;
    MappingUtility mappingUtility;

    @Autowired
    public CordinatorService(UserService userService,
                             MappingUtility mappingUtility){
        this.userService = userService;
        this.mappingUtility = mappingUtility;
    }

    public void inviteCordinator(int userId,
                                 InviteCordinatorDto inviteCordinatorDto){
        // First thing validate userId -> Is it belonging to maint user or not.
        User user = userService.getUserById(userId);
        if(user == null || !(user.getUserType().equals(UserType.ADMIN.toString()) || user.getUserType().equals(UserType.MAINT.toString()))){
            throw new NotAuthorizedException("User is not allowed to perform this action");
        }
        // We are getting admin details in InviteAdminDto, Now what we want ?
        // We want to save the admin details in our user table.
        // So, For that first we need to map inviteAdminDto details to user object.
        // If i will write mapping logic here directly so our code will look clumsy
        // I will create another mapping class and there i will be keeping the mapping logic
        User cordinator = mappingUtility.mapInviteAdminDtoToUserObject(inviteCordinatorDto);
        cordinator.setUserType(UserType.SERVICE_DESK_EXECUTIVE.toString());
        // I need to save this in the user table.
        cordinator = userService.saveOrUpdateUser(cordinator);
        // After saving admin object in table we need to maild the admin regarding the invite -> That he want to join org or not.
//        mailService.sendInvitationEmailToAdmin(admin, maint);
    }

}

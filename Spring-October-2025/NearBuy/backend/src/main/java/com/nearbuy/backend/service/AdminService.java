package com.nearbuy.backend.service;

import com.nearbuy.backend.dto.InviteAdminDto;
import com.nearbuy.backend.enums.UserState;
import com.nearbuy.backend.enums.UserType;
import com.nearbuy.backend.exceptions.NotAuthorizedException;
import com.nearbuy.backend.models.User;
import com.nearbuy.backend.utilities.MappingUtility;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {

    UserService userService;
    MappingUtility mappingUtility;
    MailService mailService;

    @Autowired
    public AdminService(UserService userService,
                        MappingUtility mappingUtility,
                        MailService mailService){
        this.userService = userService;
        this.mappingUtility = mappingUtility;
        this.mailService = mailService;
    }



    public void inviteAdmin(InviteAdminDto inviteAdminDto,
                            int userId) throws MessagingException {
        // First thing validate userId -> Is it belonging to maint user or not.
        User maint = userService.getUserById(userId);
        boolean isMaint = userService.isMaintUser(maint);
        if(maint == null || !isMaint){
            throw new NotAuthorizedException("User is not allowed to perform this action");
        }
        // We are getting admin details in InviteAdminDto, Now what we want ?
        // We want to save the admin details in our user table.
        // So, For that first we need to map inviteAdminDto details to user object.
        // If i will write mapping logic here directly so our code will look clumsy
        // I will create another mapping class and there i will be keeping the mapping logic
        User admin = mappingUtility.mapInviteAdminDtoToUserObject(inviteAdminDto);
        // I need to save this in the user table.
        admin = userService.saveOrUpdateUser(admin);
        // After saving admin object in table we need to maild the admin regarding the invite -> That he want to join org or not.
        mailService.sendInvitationEmailToAdmin(admin, maint);
    }


    public void acceptInvite(int userId){
       User admin =  userService.getUserById(userId);
       if(admin == null || !admin.getUserType().equals(UserType.ADMIN.toString()) || admin.getStatus().equals(UserState.ACTIVE.toString())){
           throw new NotAuthorizedException("User is not allowed to perform this operation");
       }
       admin.setStatus(UserState.ACTIVE.toString());
       userService.saveOrUpdateUser(admin);
    }

}

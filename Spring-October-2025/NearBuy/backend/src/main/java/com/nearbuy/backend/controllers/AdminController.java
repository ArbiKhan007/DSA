package com.nearbuy.backend.controllers;

import com.nearbuy.backend.dto.InviteAdminDto;
import com.nearbuy.backend.exceptions.NotAuthorizedException;
import com.nearbuy.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/invite")
    public ResponseEntity inviteAdmin(@RequestBody InviteAdminDto inviteAdminDto, @RequestParam int userId){
        try{
            adminService.inviteAdmin(inviteAdminDto, userId);
            return new ResponseEntity<>("Admin Invited Successfully", HttpStatus.OK);
        }catch (NotAuthorizedException notAuthorizedException){
            return new ResponseEntity(notAuthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

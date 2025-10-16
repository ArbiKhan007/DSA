package com.nearbuy.backend.controllers;

import com.nearbuy.backend.dto.InviteAdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/admin")
public class AdminController {

    @PostMapping("/invite")
    public ResponseEntity inviteAdmin(@RequestBody InviteAdminDto inviteAdminDto,
                                      @RequestParam int userId){

    }
}

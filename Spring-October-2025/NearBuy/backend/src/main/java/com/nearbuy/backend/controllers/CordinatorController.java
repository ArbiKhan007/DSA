package com.nearbuy.backend.controllers;


import com.nearbuy.backend.dto.InviteCordinatorDto;
import com.nearbuy.backend.exceptions.NotAuthorizedException;
import com.nearbuy.backend.service.CordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cordinator")
public class CordinatorController {

    @Autowired
    CordinatorService cordinatorService;

    @PostMapping("/invite")
    public ResponseEntity inviteCordinator(@RequestParam int userId,
                                 @RequestBody InviteCordinatorDto inviteCordinatorDto){
        try{
            cordinatorService.inviteCordinator(userId, inviteCordinatorDto);
            return new ResponseEntity<>("Admin Invited Successfully", HttpStatus.OK);
        }catch (NotAuthorizedException notAuthorizedException){
            return new ResponseEntity(notAuthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

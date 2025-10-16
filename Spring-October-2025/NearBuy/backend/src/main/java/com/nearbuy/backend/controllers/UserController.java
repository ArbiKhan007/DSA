package com.nearbuy.backend.controllers;

import com.nearbuy.backend.dto.SignInDto;
import com.nearbuy.backend.exceptions.InvalidCredentialsException;
import com.nearbuy.backend.exceptions.UserNotFoundException;
import com.nearbuy.backend.models.User;
import com.nearbuy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.interfaces.RSAKey;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Whenever our api response back it just not only return response body
     * It returns multiple things
     * Headers, ResponseBody and status code.
     * When user tried to login and entered credentials then it is a failure then our api will return what status code ? -> 401 UnAuthorized
     * On Post success call what status we should return ? 201
     * @param signInDto
     * @return
     */

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody SignInDto signInDto){
        try{
            User user = this.userService.signin(signInDto);
            return new ResponseEntity(user, HttpStatus.CREATED);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (InvalidCredentialsException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

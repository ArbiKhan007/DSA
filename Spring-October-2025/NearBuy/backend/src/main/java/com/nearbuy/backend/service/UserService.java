package com.nearbuy.backend.service;

import com.nearbuy.backend.dto.SignInDto;
import com.nearbuy.backend.exceptions.InvalidCredentialsException;
import com.nearbuy.backend.exceptions.UserNotFoundException;
import com.nearbuy.backend.enums.UserType;
import com.nearbuy.backend.models.User;
import com.nearbuy.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    UserRepository userRepository; // Field Based Autowired

    UserRepository userRepository;

    /**
     * Construtor based autowiring
     * @param userRepository
     */
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signin(SignInDto signInDto){
        String email = signInDto.getEmail();
        // We need to get UserRepository and from userRepository we will get User by email
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserNotFoundException(String.format("User with id %s does not exist", email));
        }
        if(user.getPassword().equals(signInDto.getPassword())){
            return user;
        }
        throw new InvalidCredentialsException("Wrong email password entered");
    }

    public User saveOrUpdateUser(User user){
        return userRepository.save(user);
    }

    public boolean isMaintUser(User user){
        return user.getUserType().equals(UserType.MAINT.toString());
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }


}

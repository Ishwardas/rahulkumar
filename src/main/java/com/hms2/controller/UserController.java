package com.hms2.controller;

import com.hms2.entity.AppUser;
import com.hms2.repository.AppUserRepository;
import com.hms2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private AppUserRepository appUserRepository;
    private UserService userService;

    public UserController(AppUserRepository appUserRepository, UserService userService) {
        this.appUserRepository = appUserRepository;
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(
            @RequestBody AppUser appUser
    ){
        Optional<AppUser> opUsername = appUserRepository.findByUsername(appUser.getUsername());
            if(opUsername.isPresent()){
                return new  ResponseEntity<>("This username is allready present", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        Optional<AppUser> opEmail = appUserRepository.findByEmail(appUser.getEmail());
            if(opEmail.isPresent()){
                return new ResponseEntity<>("This email is allready",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        AppUser appUser1 = userService.saveProfile(appUser);
            return new ResponseEntity<>(appUser1,HttpStatus.CREATED);
    }
        @GetMapping("/message")
    public String getMessage(){
        return "hello";
    }

}

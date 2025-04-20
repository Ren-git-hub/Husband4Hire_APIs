package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        return new ResponseEntity<>(userService.verifyUser(user), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Users user) throws MessagingException {
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<Users> me(Authentication auth) {
        // auth.getName() is the username from the JWT subject
        Users me = userService.getUserProfile(auth.getName());
        return ResponseEntity.ok(me);
    }
}

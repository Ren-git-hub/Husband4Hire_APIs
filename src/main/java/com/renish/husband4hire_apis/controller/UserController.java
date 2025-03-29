package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.User;
import com.renish.husband4hire_apis.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String username, String password) {
        return ResponseEntity.ok().body(userService.login(username,password)) ;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) throws MessagingException {
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }
}

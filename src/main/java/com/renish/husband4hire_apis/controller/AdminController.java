package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.service.AdminService;
import com.renish.husband4hire_apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity admin() {
        return ResponseEntity.ok().body("Welcome Mr.Admin to Project");
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().body(adminService.getAllUsers());
    }

    @GetMapping("/UserById")
    public ResponseEntity<?> getUserById(int id) {
        return new ResponseEntity<Users>(adminService.getUserById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(int id) {
        return ResponseEntity.ok().body(adminService.deleteUser(id));
    }



}

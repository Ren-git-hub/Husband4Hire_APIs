package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepo userRepo;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users getUserById(int id) {
        return userRepo.findById(id).get();
    }

    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "User successfully deleted";
    }
}

package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.User;
import com.renish.husband4hire_apis.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {

    UserRepo userRepo;

    public String generateOTP() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(999999));
    }

    public boolean validateOTP(String username , int otp) {
        User user = userRepo.findUsersByUsername(username);
        if(user.getOtp() == otp) {
            user.setOtp(0);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}

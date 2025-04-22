package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Random;

//OTP generation class and logic
@Service
public class OTPService {

    UserRepo userRepo;

    //method to generate OTP
    public String generateOTP() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(999999));
    }

    //save OTP into database
    public boolean validateOTP(String username , int otp) {
        Users user = userRepo.findUsersByUsername(username);
        if(user.getOtp() == otp) {
            user.setOtp(0);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}

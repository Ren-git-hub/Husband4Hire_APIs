package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.User;
import com.renish.husband4hire_apis.repository.UserRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    OTPService otpService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailService emailService;

    public String login(String username, String password) {
        //sample JWT token
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }

    public String signup(User user) throws MessagingException {
        int otp = Integer.parseInt(otpService.generateOTP());
        user.setOtp(otp);
        userRepo.save(user);
        String body = "You are registered successfully. OTP for login is : " +otp;
        emailService.sendEmail(user.getEmail(), "[No-Reply] OTP for Login Husband4Hire App",body);
       return "OTP send to your Email Address, Please verify OTP.";
    }
}

package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.repository.UserRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    OTPService otpService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailService emailService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public String verifyUser(Users user) {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }

    public String signup(Users user) throws MessagingException {
        int otp = Integer.parseInt(otpService.generateOTP());
        user.setOtp(otp);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        String body = "You are registered successfully. OTP for login is : " +otp;
        emailService.sendEmail(user.getEmail(), "[No-Reply] OTP for Login Husband4Hire App",body);
       return "OTP send to your Email Address, Please verify OTP.";
    }
}

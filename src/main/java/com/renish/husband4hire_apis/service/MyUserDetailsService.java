package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.UserPrincipal;
import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// solid implementation of UserDetailService.class
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findUsersByUsername(username);

        if(user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}

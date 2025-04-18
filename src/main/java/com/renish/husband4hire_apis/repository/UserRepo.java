package com.renish.husband4hire_apis.repository;

import com.renish.husband4hire_apis.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findUsersByUsername(String username);
}

package com.renish.husband4hire_apis.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//represent user class
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(name = "is_employer")
    private Boolean isEmployer = true;

    @Column(name = "is_jobseeker")
    private Boolean isJobseeker = true;

    @Column(length = 10)
    private int otp ;

    @Column(name ="verifiedOTP")
    private Boolean verifiedOTP = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "roleID"))
    private List<Role> roles;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEmployer() {
        return isEmployer;
    }

    public void setEmployer(Boolean employer) {
        isEmployer = employer;
    }

    public Boolean getJobseeker() {
        return isJobseeker;
    }

    public void setJobseeker(Boolean jobseeker) {
        isJobseeker = jobseeker;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Boolean getVerifiedOTP() {
        return verifiedOTP;
    }

    public void setVerifiedOTP(Boolean verifiedOTP) {
        this.verifiedOTP = verifiedOTP;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

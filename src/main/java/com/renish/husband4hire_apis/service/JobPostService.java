package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.JobPost;
import com.renish.husband4hire_apis.model.Users;
import com.renish.husband4hire_apis.repository.JobPostRepo;
import com.renish.husband4hire_apis.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private UserRepo userRepo;

    public List<JobPost> getAllJobPost() {
        return (List<JobPost>) jobPostRepo.findAll();
    }

    public JobPost createJobPost(JobPost jobPost) {
        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        Users employer = userRepo.findUsersByUsername(username);
        if (employer == null) {
            throw new IllegalStateException("Authenticated user not found in database: " + username);
        }
        jobPost.setEmployer(employer);

        jobPost.setPostDate(LocalDate.now());

        return jobPostRepo.save(jobPost);
    }

    public JobPost updateJobPost(JobPost jobPost) {
        Integer employerId = jobPost.getEmployer().getUserID();
        Users employer = userRepo.findById(employerId)
                .orElseThrow(() -> new IllegalArgumentException("No user with ID " + employerId));
        jobPost.setEmployer(employer);

        return jobPostRepo.save(jobPost);
    }

    public void deleteJobPost(int id) {
        jobPostRepo.deleteById(id);
    }

    public JobPost getJobPostByID(int id) {
        return jobPostRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("JobPost not found: " + id));
    }

    public List<JobPost> searchJobPostByKeyword(String keyword) {
        return jobPostRepo.searchJobPostByKeyword(keyword);
    }
}

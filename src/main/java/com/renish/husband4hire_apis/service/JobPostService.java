package com.renish.husband4hire_apis.service;

import com.renish.husband4hire_apis.model.JobPost;
import com.renish.husband4hire_apis.repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    @Autowired
    JobPostRepo jobPostRepo;

    public List<JobPost> getAllJobPost() {
        return (List<JobPost>) jobPostRepo.findAll();
    }

    public JobPost createJobPost(JobPost jobPost) {
        return jobPostRepo.save(jobPost);
    }

    public JobPost updateJobPost(JobPost jobPost) {
        return jobPostRepo.save(jobPost);
    }

    public String deleteJobPost(int id) {
        jobPostRepo.deleteById(id);
        return "Delete Job Post successfully";
    }

    public JobPost getJobPostByID(int id) {
        return jobPostRepo.findById(id).get();
    }

    public List<JobPost> searchJobPostByKeyword(String keyword) {
        return jobPostRepo.searchJobPostByKeyword(keyword);
    }
}

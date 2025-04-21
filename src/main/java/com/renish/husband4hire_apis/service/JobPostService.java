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

/**
 * Handles business rules for job posts.
 */
@Service
public class JobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private UserRepo userRepo;

    /**
     * Fetch all job posts.
     * @return list of posts
     */
    public List<JobPost> getAllJobPost() {
        return (List<JobPost>) jobPostRepo.findAll();
    }

    /**
     * Create and save a new post.
     * Sets the authenticated employer and current date.
     * @param jobPost data to save
     * @return saved post
     */
    public JobPost createJobPost(JobPost jobPost) {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        Users employer = userRepo.findUsersByUsername(username);
        if (employer == null) {
            throw new IllegalStateException("User not found: " + username);
        }
        jobPost.setEmployer(employer);
        jobPost.setPostDate(LocalDate.now());
        return jobPostRepo.save(jobPost);
    }

    /**
     * Update an existing post.
     * Validates that the employer still exists.
     * @param jobPost updated data
     * @return saved post
     */
    public JobPost updateJobPost(JobPost jobPost) {
        Integer employerId = jobPost.getEmployer().getUserID();
        Users employer = userRepo.findById(employerId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No user with ID " + employerId));
        jobPost.setEmployer(employer);
        return jobPostRepo.save(jobPost);
    }

    /**
     * Remove a post by ID.
     * @param id post identifier
     */
    public void deleteJobPost(int id) {
        jobPostRepo.deleteById(id);
    }

    /**
     * Retrieve a post or error if missing.
     * @param id post identifier
     * @return found post
     */
    public JobPost getJobPostByID(int id) {
        return jobPostRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Not found: " + id));
    }

    /**
     * Search posts by keyword.
     * @param keyword term to search
     * @return matching list
     */
    public List<JobPost> searchJobPostByKeyword(String keyword) {
        return jobPostRepo.searchJobPostByKeyword(keyword);
    }
}

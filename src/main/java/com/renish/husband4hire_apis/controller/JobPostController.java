package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.JobPost;
import com.renish.husband4hire_apis.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing job posts.
 */
@CrossOrigin
@RestController
@RequestMapping("/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    /**
     * Retrieve all job posts.
     * @return list of job posts
     */
    @GetMapping("/alljobpost")
    public ResponseEntity<List<JobPost>> getAllJobPost() {
        return ResponseEntity.ok(jobPostService.getAllJobPost());
    }

    /**
     * Create a new job post.
     * @param jobPost job post to create
     * @return created job post
     */
    @PostMapping("/createjobpost")
    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost) {
        JobPost created = jobPostService.createJobPost(jobPost);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Update an existing job post.
     * @param jobPost job post with updates
     * @return updated job post
     */
    @PutMapping("/upadatjobpost")
    public ResponseEntity<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        JobPost updated = jobPostService.updateJobPost(jobPost);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete a job post by ID.
     * @param id ID of job post to delete
     * @return deletion confirmation
     */
    @DeleteMapping("/deletejobpost/{id}")
    public ResponseEntity<String> deleteJobPost(@PathVariable int id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.ok("Delete Job Post successfully");
    }

    /**
     * Retrieve a job post by ID.
     * @param id job post ID
     * @return job post
     */
    @GetMapping("/{id}")
    public ResponseEntity<JobPost> getJobPostById(@PathVariable int id) {
        JobPost jp = jobPostService.getJobPostByID(id);
        return ResponseEntity.ok(jp);
    }

    /**
     * Search job posts by keyword.
     * @param keyword search term
     * @return list of matching job posts
     */
    @GetMapping("/searchjobpost/{keyword}")
    public ResponseEntity<List<JobPost>> searchJobPost(@PathVariable String keyword) {
        List<JobPost> results = jobPostService.searchJobPostByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}

package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.JobPost;
import com.renish.husband4hire_apis.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("/alljobpost")
    public ResponseEntity<List<JobPost>> getAllJobPost() {
        return ResponseEntity.ok(jobPostService.getAllJobPost());
    }

    @PostMapping("/createjobpost")
    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost) {
        JobPost created = jobPostService.createJobPost(jobPost);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/upadatjobpost")
    public ResponseEntity<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        JobPost updated = jobPostService.updateJobPost(jobPost);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deletejobpost/{id}")
    public ResponseEntity<String> deleteJobPost(@PathVariable int id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.ok("Delete Job Post successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPost> getJobPostById(@PathVariable int id) {
        JobPost jp = jobPostService.getJobPostByID(id);
        return ResponseEntity.ok(jp);
    }

    @GetMapping("/searchjobpost/{keyword}")
    public ResponseEntity<List<JobPost>> searchJobPost(@PathVariable String keyword) {
        List<JobPost> results = jobPostService.searchJobPostByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}

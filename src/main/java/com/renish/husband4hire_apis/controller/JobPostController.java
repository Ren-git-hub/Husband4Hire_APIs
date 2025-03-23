package com.renish.husband4hire_apis.controller;

import com.renish.husband4hire_apis.model.JobPost;
import com.renish.husband4hire_apis.service.JobPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController("/jobpost")
public class JobPostController {

    @Autowired
    JobPostService jobPostService;

    @GetMapping("/alljobpost")
    public ResponseEntity<List<JobPost>> getAllJobPost() {
        return ResponseEntity.ok().body(jobPostService.getAllJobPost());
    }

    @PostMapping("/createjobpost")
    public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobPost) {
        return new ResponseEntity<>(jobPostService.createJobPost(jobPost), HttpStatus.CREATED);
    }

    @PostMapping("/upadatjobpost")
    public ResponseEntity<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        return ResponseEntity.ok().body(jobPostService.updateJobPost(jobPost));
    }

    @DeleteMapping
    public ResponseEntity<JobPost> deleteJobPost(@RequestBody JobPost jobPost) {
        return new ResponseEntity<>(jobPostService.deleteJobPost(jobPost), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPost> getJobPostById(@PathVariable int id) {
        return ResponseEntity.ok().body(jobPostService.getJobPostByID(id));
    }
}

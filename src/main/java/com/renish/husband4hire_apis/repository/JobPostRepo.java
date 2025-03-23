package com.renish.husband4hire_apis.repository;

import com.renish.husband4hire_apis.model.JobPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepo extends CrudRepository<JobPost, Integer> {
}

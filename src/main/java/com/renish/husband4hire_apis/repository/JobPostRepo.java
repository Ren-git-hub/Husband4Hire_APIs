package com.renish.husband4hire_apis.repository;

import com.renish.husband4hire_apis.model.JobPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepo extends CrudRepository<JobPost, Integer> {

    @Query("SELECT j FROM JobPost j WHERE " +
            "LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " )
    List<JobPost> searchJobPostByKeyword(String keyword);
}

package com.renish.husband4hire_apis.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a job posting created by an employer.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JobPost")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostID;

    @ManyToOne
    @JoinColumn(name = "EmployerID", nullable = false)
    private Users employer;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100)
    private String location;

    private BigDecimal salary;

    private LocalDate postDate;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name="hours")
    private int hours;

    // --- Getters and Setters ---

    /** @return the post ID */
    public Integer getJobPostID() {
        return jobPostID;
    }

    /** @param jobPostID the post ID to set */
    public void setJobPostID(Integer jobPostID) {
        this.jobPostID = jobPostID;
    }

    /** @return the employer user */
    public Users getEmployer() {
        return employer;
    }

    /** @param employer the employer to set */
    public void setEmployer(Users employer) {
        this.employer = employer;
    }

    /** @return the job title */
    public String getTitle() {
        return title;
    }

    /** @param title the title to set */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return the job description */
    public String getDescription() {
        return description;
    }

    /** @param description the description to set */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return the location */
    public String getLocation() {
        return location;
    }

    /** @param location the location to set */
    public void setLocation(String location) {
        this.location = location;
    }

    /** @return the salary */
    public BigDecimal getSalary() {
        return salary;
    }

    /** @param salary the salary to set */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /** @return the post date */
    public LocalDate getPostDate() {
        return postDate;
    }

    /** @param postDate the date to set */
    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    /** @return availability flag */
    public Boolean getAvailable() {
        return isAvailable;
    }

    /** @param available the availability to set */
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    /** @return weekly hours */
    public int getHours() {
        return hours;
    }

    /** @param hours the hours to set */
    public void setHours(int hours) {
        this.hours = hours;
    }
}

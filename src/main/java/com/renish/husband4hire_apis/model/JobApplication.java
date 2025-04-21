package com.renish.husband4hire_apis.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * Represents a user’s application to a job post.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JobApplication")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationID;

    @ManyToOne
    @JoinColumn(name = "JobPostID", nullable = false)
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "JobSeekerID", nullable = false)
    private Users jobSeeker;

    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    public enum ApplicationStatus { PENDING, ACCEPTED, REJECTED }

    // --- Getters and Setters ---

    /** @return the application ID */
    public Integer getApplicationID() {
        return applicationID;
    }

    /** @param applicationID the application ID to set */
    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    /** @return the linked job post */
    public JobPost getJobPost() {
        return jobPost;
    }

    /** @param jobPost the job post to set */
    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    /** @return the applicant user */
    public Users getJobSeeker() {
        return jobSeeker;
    }

    /** @param jobSeeker the user applying */
    public void setJobSeeker(Users jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    /** @return the date of application */
    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    /** @param applicationDate the date to set */
    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    /** @return current status */
    public ApplicationStatus getStatus() {
        return status;
    }

    /** @param status the status to set */
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    /** @return the cover letter text */
    public String getCoverLetter() {
        return coverLetter;
    }

    /** @param coverLetter the cover letter to set */
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
}

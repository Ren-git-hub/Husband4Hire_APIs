package com.renish.husband4hire_apis.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private User jobSeeker;

    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    public enum ApplicationStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }
}
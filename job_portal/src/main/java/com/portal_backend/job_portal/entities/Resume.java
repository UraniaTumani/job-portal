package com.portal_backend.job_portal.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    @OneToOne
    @JoinColumn(name = "job_seeker_id") // Remove unique constraint
    private User jobSeeker;


    public Resume() {
    }

    public Resume(Long id, String fileUrl, User jobSeeker) {
        this.id = id;
        this.fileUrl = fileUrl;
        this.jobSeeker = jobSeeker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public User getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(User jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}


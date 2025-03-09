package com.portal_backend.job_portal.dto;

import com.portal_backend.job_portal.enums.ApplicationStatus;

public class ApplicationRequestDto {
    private Long userId;
    private Long jobId;
    private ApplicationStatus status;

    public ApplicationRequestDto(Long userId, Long jobId, ApplicationStatus status) {
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}

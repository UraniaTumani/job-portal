package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.Application;
import com.portal_backend.job_portal.repositories.ApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Page<Application> getApplications(int page, int size, String jobTitle, String status) {
        Pageable pageable = PageRequest.of(page, size);
        if (jobTitle != null && status != null) {
            return applicationRepository.findByJobTitleContainingAndStatus(jobTitle, status, pageable);
        } else if (jobTitle != null) {
            return applicationRepository.findByJobTitleContaining(jobTitle, pageable);
        } else if (status != null) {
            return applicationRepository.findByStatus(status, pageable);
        }
        return applicationRepository.findAll(pageable);
    }
}
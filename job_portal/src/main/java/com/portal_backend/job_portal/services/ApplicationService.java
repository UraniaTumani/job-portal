package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.Application;
import com.portal_backend.job_portal.entities.User;
import com.portal_backend.job_portal.repositories.ApplicationRepository;
import com.portal_backend.job_portal.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
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
    public void saveApplication(Application application, Long userId) {
        // Fetch the User from DB to ensure it's managed
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        application.setJobSeeker(existingUser); // Ensure the user is managed
        applicationRepository.save(application);
    }



}
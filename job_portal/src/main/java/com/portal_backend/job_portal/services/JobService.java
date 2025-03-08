package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.Job;
import com.portal_backend.job_portal.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Page<Job> getAllJobs(int page, int size, String title, String location) {
        Pageable pageable = PageRequest.of(page, size);
        if (title != null && location != null) {
            return jobRepository.findByTitleContainingAndLocationContaining(title, location, pageable);
        } else if (title != null) {
            return jobRepository.findByTitleContaining(title, pageable);
        } else if (location != null) {
            return jobRepository.findByLocationContaining(location, pageable);
        }
        return jobRepository.findAll(pageable);
    }
}

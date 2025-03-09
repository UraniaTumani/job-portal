package com.portal_backend.job_portal.controllers;

import com.portal_backend.job_portal.dto.ApplicationRequestDto;
import com.portal_backend.job_portal.entities.Application;
import com.portal_backend.job_portal.entities.Job;
import com.portal_backend.job_portal.entities.User;
import com.portal_backend.job_portal.repositories.JobRepository;
import com.portal_backend.job_portal.repositories.UserRepository;
import com.portal_backend.job_portal.services.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public ApplicationController(ApplicationService applicationService, JobRepository jobRepository, UserRepository userRepository) {
        this.applicationService = applicationService;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> createApplication(@RequestBody ApplicationRequestDto requestDto) {
        Application application = new Application();

        Job job = jobRepository.findById(requestDto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        application.setJob(job);
        application.setStatus(requestDto.getStatus());  // Now status is Enum

        applicationService.saveApplication(application, requestDto.getUserId());

        return ResponseEntity.ok("Application submitted successfully!");
    }






    @GetMapping
    public ResponseEntity<Page<Application>> getApplications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) String status) {
        return ResponseEntity.ok(applicationService.getApplications(page, size, jobTitle, status));
    }
}

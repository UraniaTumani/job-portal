package com.portal_backend.job_portal.controllers;

import com.portal_backend.job_portal.entities.Application;
import com.portal_backend.job_portal.services.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
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

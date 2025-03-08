package com.portal_backend.job_portal.controllers;

import com.portal_backend.job_portal.entities.Resume;
import com.portal_backend.job_portal.services.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<Resume> uploadResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.uploadResume(resume));
    }
}

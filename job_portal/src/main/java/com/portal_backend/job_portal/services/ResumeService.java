package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.Resume;
import com.portal_backend.job_portal.repositories.ResumeRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume uploadResume(Resume resume) {
        return resumeRepository.save(resume);
    }
}
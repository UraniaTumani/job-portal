package com.portal_backend.job_portal.services;

import com.portal_backend.job_portal.entities.Resume;
import com.portal_backend.job_portal.repositories.ResumeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    @Transactional
    public Resume uploadResume(Resume resume) {
        Optional<Resume> existingResume = resumeRepository.findByJobSeekerId(resume.getJobSeeker().getId());

        if (existingResume.isPresent()) {
            Resume resumeToUpdate = existingResume.get();
            resumeToUpdate.setFileUrl(resume.getFileUrl()); // Update only file URL
            return resumeRepository.save(resumeToUpdate);
        } else {
            return resumeRepository.save(resume);
        }
    }



}
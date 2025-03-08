package com.portal_backend.job_portal.repositories;

import com.portal_backend.job_portal.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}

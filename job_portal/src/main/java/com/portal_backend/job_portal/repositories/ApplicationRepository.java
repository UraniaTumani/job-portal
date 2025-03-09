package com.portal_backend.job_portal.repositories;

import com.portal_backend.job_portal.entities.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findByJobTitleContaining(String jobTitle, Pageable pageable);
    Page<Application> findByStatus(String status, Pageable pageable);
    Page<Application> findByJobTitleContainingAndStatus(String jobTitle, String status, Pageable pageable);
    void deleteByJobSeekerId(Long jobSeekerId);
}
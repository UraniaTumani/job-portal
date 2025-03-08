package com.portal_backend.job_portal.repositories;

import com.portal_backend.job_portal.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findByTitleContaining(String title, Pageable pageable);
    Page<Job> findByLocationContaining(String location, Pageable pageable);
    Page<Job> findByTitleContainingAndLocationContaining(String title, String location, Pageable pageable);
}


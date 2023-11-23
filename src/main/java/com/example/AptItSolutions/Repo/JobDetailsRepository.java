package com.example.AptItSolutions.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.JobDetails;
@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
    // Custom query methods, if needed
}
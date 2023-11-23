package com.example.AptItSolutions.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.JobApplication;
import com.example.AptItSolutions.Entity.ScrollNews;
import com.example.AptItSolutions.Repo.JobApplicationRepository;
import com.example.AptItSolutions.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(id);
        return optionalJobApplication.orElse(null);
    }

    @Override
    public JobApplication updateJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public boolean deleteJobApplication(Long id) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        }
        return false;
    }

	
}

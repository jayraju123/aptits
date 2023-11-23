package com.example.AptItSolutions.service;
import java.util.List;

import com.example.AptItSolutions.Entity.JobApplication;
import com.example.AptItSolutions.Entity.ScrollNews;

public interface JobApplicationService
{
    JobApplication saveJobApplication(JobApplication jobApplication);

    List<JobApplication> getAllJobApplications();

    JobApplication getJobApplicationById(Long id);

    JobApplication updateJobApplication(JobApplication jobApplication);

    boolean deleteJobApplication(Long id);
    
//    JobApplication updateJobApplication(Long id, JobApplication updatedJobApplication);

}

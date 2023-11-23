package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.JobApplication;
import com.example.AptItSolutions.Entity.JobDetails;

public interface JobDetailsService {

	
	 JobDetails saveJobDetails(JobDetails jobDetails);
	    List<JobDetails> getAllJobDetails();
	    JobDetails getJobDetailsById(Long id);
	    void deleteJobDetails(Long id);
	    JobDetails updateJobApplication(Long id, JobDetails updatedJobApplication);

}

package com.example.AptItSolutions.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.JobDetails;
import com.example.AptItSolutions.Entity.ScrollNews;
import com.example.AptItSolutions.Repo.JobDetailsRepository;
import com.example.AptItSolutions.service.JobDetailsService;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {
    

    @Autowired
    private  JobDetailsRepository jobDetailsRepository;

    @Override
    public JobDetails saveJobDetails(JobDetails jobDetails) {
        return jobDetailsRepository.save(jobDetails);
    }

    @Override
    public List<JobDetails> getAllJobDetails() {
        return jobDetailsRepository.findAll();
    }

    @Override
    public JobDetails getJobDetailsById(Long id) {
        Optional<JobDetails> optionalJobDetails = jobDetailsRepository.findById(id);
        return optionalJobDetails.orElse(null);
    }

    @Override
    public void deleteJobDetails(Long id) {
        jobDetailsRepository.deleteById(id);
    }

	@Override
	public JobDetails updateJobApplication(Long id, JobDetails updatedJobApplication) {
		JobDetails existing = jobDetailsRepository.findById(id)
	               .orElseThrow(() -> new NoSuchElementException("ScrollNews not found with ID: " + id));

	       existing.setRole(updatedJobApplication.getRole());
	       existing.setEducation(updatedJobApplication.getEducation());

	       existing.setJobTitle(updatedJobApplication.getJobTitle());
	       existing.setKeySkills(updatedJobApplication.getKeySkills());

	       existing.setYearsOfExperience(updatedJobApplication.getYearsOfExperience());

	       existing.setJobDescription(updatedJobApplication.getJobDescription());


	       return jobDetailsRepository.save(existing);
	}
}
package com.example.AptItSolutions.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.JobDetails;
import com.example.AptItSolutions.service.JobDetailsService;

@RestController
@RequestMapping("/apijobdetails")
public class JobDetailsController {
	@Autowired
    private  JobDetailsService jobDetailsService;

   

	@PostMapping("/savejob")
	public String createJobDetails(@RequestParam(required = false, value="role") String role,
	                               @RequestParam(required = false, value="education") String education,
	                               @RequestParam(required = false, value="jobTitle") String jobTitle,
	                               @RequestParam(required = false, value="keySkills") String keySkills,
	                               @RequestParam(required = false, value="yearsOfExperience") String yearsOfExperience,
	                               @RequestParam(required = false, value="numberOfPositions") String numberOfPositions,
	                               @RequestParam(required = false, value="jobDescription") String jobDescription,
	                               @RequestParam(required = false, value="status") String statusString) {

	    JobDetails jobDetails = new JobDetails();

	    jobDetails.setRole(role);
	    jobDetails.setEducation(education);
	    jobDetails.setJobTitle(jobTitle);
	    jobDetails.setKeySkills(keySkills);
	    jobDetails.setYearsOfExperience(yearsOfExperience);
	    jobDetails.setNumberOfPositions(numberOfPositions);
	    jobDetails.setJobDescription(jobDescription);

	    // Set the status to true for "Active"
	    jobDetails.setStatus(true);

	    // Set the creationDate using LocalDateTime.now()
	    jobDetails.setCreationDate(LocalDateTime.now());

	    jobDetailsService.saveJobDetails(jobDetails);

	    return "redirect:/adminDashboard";
	}



    @GetMapping("/alljobs")
    public ResponseEntity<List<JobDetails>> getAllJobDetails() {
        List<JobDetails> jobDetailsList = jobDetailsService.getAllJobDetails();
        return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<JobDetails> getJobDetailsById(@PathVariable("id") Long id) {
        JobDetails jobDetails = jobDetailsService.getJobDetailsById(id);
        if (jobDetails != null) {
            return new ResponseEntity<>(jobDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobupdating/{id}")
    public ResponseEntity<JobDetails> updateJobDetails(@PathVariable Long id,
            @RequestParam(required = false,value="role") String role,
            @RequestParam(required = false,value="education") String education,
            @RequestParam(required = false,value="jobTitle") String jobTitle,
            @RequestParam(required = false,value="keySkills") String keySkills,
            @RequestParam(required = false,value="yearsOfExperience") String yearsOfExperience,
            @RequestParam(required = false,value="numberOfPositions") String numberOfPositions,
            @RequestParam(required = false,value="jobDescription") String jobDescription,
            @RequestParam(required = false,value="status") String statusString) {

        JobDetails updatedJobDetails = jobDetailsService.getJobDetailsById(id);

        if (role != null) {
            updatedJobDetails.setRole(role);
        }
        
        if (education != null) {
            updatedJobDetails.setEducation(education);
        }
        
        if (jobTitle != null) {
            updatedJobDetails.setJobTitle(jobTitle);
        }
        
        if (keySkills != null) {
            updatedJobDetails.setKeySkills(keySkills);
        }
        
        if (yearsOfExperience != null) {
            updatedJobDetails.setYearsOfExperience(yearsOfExperience);
        }
        
        if (numberOfPositions != null) {
            updatedJobDetails.setNumberOfPositions(numberOfPositions);
        }
        
        if (statusString != null) {
            boolean status = Boolean.parseBoolean(statusString);
            updatedJobDetails.setStatus(status);
        }
        
        if (jobDescription != null) {
            updatedJobDetails.setJobDescription(jobDescription);
        }

        JobDetails savedJobDetails = jobDetailsService.updateJobApplication(id, updatedJobDetails);

        if (savedJobDetails != null) {
            return new ResponseEntity<>(savedJobDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @DeleteMapping("/deletejob/{id}")
    public ResponseEntity<HttpStatus> deleteJobDetails(@PathVariable("id") Long id) {
        JobDetails jobDetails = jobDetailsService.getJobDetailsById(id);
        if (jobDetails != null) {
            jobDetailsService.deleteJobDetails(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
package com.example.AptItSolutions.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.AptItSolutions.Entity.JobApplication;
import com.example.AptItSolutions.service.JobApplicationService;

@RestController
@RequestMapping("/jobapplication")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }



    @PostMapping("/job-applications")
    public ResponseEntity<JobApplication> createJobApplication(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile") String mobile,
            @RequestParam(value = "fatherName", required = false) String fatherName,
            @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
            @RequestParam(value = "totalExperience", required = false) String totalExperience,
            @RequestParam(value = "relevantExperience", required = false) String relevantExperience,
            @RequestParam(value = "keySkills", required = false) String keySkills,
            @RequestParam(value = "strengths", required = false) String strengths,
            @RequestParam(value = "presentDesignation", required = false) String presentDesignation,
            @RequestParam(value = "companyAddress", required = false) String companyAddress,
            @RequestParam(value = "presentCTC", required = false) Double presentCTC,
            @RequestParam(value = "expectedCTC", required = false) Double expectedCTC,
            @RequestParam(value = "noticePeriod", required = false) String noticePeriod,
            @RequestParam("resume") MultipartFile resume) {

        // Ensure that required fields are not empty
        if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || resume.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Create a new JobApplication object
        JobApplication jobApplication = new JobApplication();

        // Set the properties of the jobApplication object
        jobApplication.setName(name);
        jobApplication.setEmail(email);
        jobApplication.setCompanyAddress(companyAddress);
        jobApplication.setKeySkills(keySkills);
        jobApplication.setNoticePeriod(noticePeriod);
        jobApplication.setPresentDesignation(presentDesignation);
        jobApplication.setRelevantExperience(relevantExperience);
        jobApplication.setStrengths(strengths);
        jobApplication.setTotalExperience(totalExperience);

        // Handle optional fields
        if (mobile != null && !mobile.isEmpty()) {
            jobApplication.setMobile(Long.parseLong(mobile));
        }
        if (fatherName != null && !fatherName.isEmpty()) {
            jobApplication.setFatherName(fatherName);
        }

        // Handle dateOfBirth conversion
        java.sql.Date dateOfBirthSql = null;
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dateOfBirthDate = dateFormat.parse(dateOfBirth);
                dateOfBirthSql = new java.sql.Date(dateOfBirthDate.getTime());
            } catch (ParseException e) {
                // Handle date parsing exception
            }
        }

        // Set the dateOfBirth in the JobApplication object
        jobApplication.setDateOfBirth(dateOfBirthSql);

        // Set presentCTC and expectedCTC
        jobApplication.setPresentCTC(presentCTC != null ? presentCTC : 0.0);
        jobApplication.setExpectedCTC(expectedCTC != null ? expectedCTC : 0.0);

        try {
            // Set the resume byte array from the uploaded file
            jobApplication.setResume(resume.getBytes());
        } catch (IOException e) {
            // Handle the exception
        }

        // Save the job application using the service
        JobApplication savedJobApplication = jobApplicationService.saveJobApplication(jobApplication);

        return new ResponseEntity<>(savedJobApplication, HttpStatus.CREATED);
    }
    
    

    @GetMapping("/job-applications")
    public ResponseEntity<List<JobApplication>> getAllJobApplications() {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/job-applications/{id}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable Long id) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationById(id);
        if (jobApplication != null) {
            return new ResponseEntity<>(jobApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/job-applications/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(
            @PathVariable Long id,
            @ModelAttribute JobApplication updatedApplication) {
        JobApplication existingJobApplication = jobApplicationService.getJobApplicationById(id);
        if (existingJobApplication != null) {
            updatedApplication.setId(existingJobApplication.getId());
            JobApplication savedJobApplication = jobApplicationService.saveJobApplication(updatedApplication);
            return new ResponseEntity<>(savedJobApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/jobapplications/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.AptItSolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.ContactDetails;
import com.example.AptItSolutions.Entity.RecieverEmails;
import com.example.AptItSolutions.service.ContactDetailsService;
import com.example.AptItSolutions.service.RecieverEmailsService;
@RestController
@RequestMapping("/contactdetails")
public class ContactDetailsController {
	@Autowired
    private  ContactDetailsService contactDetailsService;

	@Autowired
    private EmailService emailService;
	
	
	@Autowired
	private RecieverEmailsService recieverEmailsService;

	// In your controller method
	@PostMapping("/savingDetail")
	public ResponseEntity<?> saveContactDetails(@RequestParam("firstName") String firstName,
	                                            @RequestParam("lastName") String lastName,
	                                            @RequestParam("phoneNumber") String phoneNumber,
	                                            @RequestParam("email") String email,
	                                            @RequestParam("message") String message) {
	    try {
	        ContactDetails contactDetails = new ContactDetails(null, firstName, lastName, phoneNumber, email, message);
	        ContactDetails savedContactDetails = contactDetailsService.saveContactDetails(contactDetails);

	        List<RecieverEmails> mails = recieverEmailsService.getAllRecieverEmails();

	        if (!mails.isEmpty()) {
	            emailService.sendEmail(mails.get(0).getEmail(), email, message);
	        } else {
	            String defaultEmail = "sai.srinivas@aptits.com";
	            emailService.sendEmail(defaultEmail, email, message);
	        }

	        return new ResponseEntity<>(savedContactDetails, HttpStatus.CREATED);
	    } catch (Exception e) {
	        // Log the error or return a specific error response
	        return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
	
	
    @GetMapping("/getallcontacts")
    public ResponseEntity<List<ContactDetails>> getAllContactDetails() {
        List<ContactDetails> contactDetailsList = contactDetailsService.getAllContactDetails();
        return new ResponseEntity<>(contactDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDetails> getContactDetailsById(@PathVariable Long id) {
        ContactDetails contactDetails = contactDetailsService.getContactDetailsById(id);
        return new ResponseEntity<>(contactDetails, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDetails> updateContactDetails(
            @PathVariable Long id,
            @RequestBody ContactDetails updatedContactDetails) {
        ContactDetails contactDetails = contactDetailsService.updateContactDetails(id, updatedContactDetails);
        return new ResponseEntity<>(contactDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactDetails(@PathVariable Long id) {
        contactDetailsService.deleteContactDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{id}/updateEmail")
    public ResponseEntity<ContactDetails> updateEmail(
            @PathVariable Long id,
            @RequestParam String newEmail) {

        // Retrieve the existing contact details
        ContactDetails contactDetails = contactDetailsService.getContactDetailsById(id);

        if (contactDetails != null) {
            // Save the old email for notification
            String oldEmail = contactDetails.getEmail();

            // Update the email in contact details
            contactDetails.setEmail(newEmail);

            // Save the updated contact details
            ContactDetails updatedContactDetails = contactDetailsService.updateContactDetails(id, contactDetails);

            // Notify the user of the email update
            emailService.sendEmailUpdateNotification(oldEmail, newEmail);

            return new ResponseEntity<>(updatedContactDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}  
 
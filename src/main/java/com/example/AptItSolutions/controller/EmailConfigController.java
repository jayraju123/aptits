package com.example.AptItSolutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailConfigController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/updateEmailRecipient")
    public void updateEmailRecipient(@RequestBody UpdateEmailRequest request) {
        // You can add email validation here if needed
        emailService.sendEmail(request.getNewEmail(), "Email Recipient Updated", "Your email recipient has been updated to: " + request.getNewEmail());
    }
}

class UpdateEmailRequest {
    private String newEmail;

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}

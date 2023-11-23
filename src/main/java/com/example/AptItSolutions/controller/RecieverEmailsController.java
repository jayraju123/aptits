package com.example.AptItSolutions.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.RecieverEmails;
import com.example.AptItSolutions.service.RecieverEmailsService;

@RestController
@RequestMapping("/reciever-emails")
public class RecieverEmailsController {
    private final RecieverEmailsService recieverEmailsService;

    @Autowired
    public RecieverEmailsController(RecieverEmailsService recieverEmailsService) {
        this.recieverEmailsService = recieverEmailsService;
    }

    @GetMapping("/")
    public List<RecieverEmails> getAllRecieverEmails() {
        return recieverEmailsService.getAllRecieverEmails();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecieverEmails> updateRecieverEmail(@PathVariable long id, @RequestBody RecieverEmails updatedRecieverEmail) {
        RecieverEmails existingRecieverEmail = recieverEmailsService.getRecieverEmailById(id);

        if (existingRecieverEmail == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the email address with the new one
        existingRecieverEmail.setEmail(updatedRecieverEmail.getEmail());

        // Save the updated email address
        RecieverEmails updatedEmail = recieverEmailsService.saveRecieverEmail(existingRecieverEmail);

        return ResponseEntity.ok(updatedEmail);
    }

    @PostMapping("/save")
    public RecieverEmails saveRecieverEmail(@RequestBody RecieverEmails recieverEmail) {
        return recieverEmailsService.saveRecieverEmail(recieverEmail);
    }

    @DeleteMapping("/{id}")
    public void deleteRecieverEmail(@PathVariable long id) {
        recieverEmailsService.deleteRecieverEmail(id);
    }
}

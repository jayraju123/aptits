package com.example.AptItSolutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mail;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mail.send(message);
    }

    public void sendEmailUpdateNotification(String oldEmail, String updatedEmail) {
        String subject = "Email Address Updated";
        String text = "Your email address has been updated from " + oldEmail + " to " + updatedEmail;
        sendEmail(oldEmail, subject, text);
        sendEmail(updatedEmail, subject, text); // Optionally, send a notification to the new email address as well
    }
}

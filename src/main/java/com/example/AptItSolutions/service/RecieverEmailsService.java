package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.RecieverEmails;

public interface RecieverEmailsService {

    List<RecieverEmails> getAllRecieverEmails();

    RecieverEmails getRecieverEmailById(long id);

    RecieverEmails saveRecieverEmail(RecieverEmails recieverEmail);

    void deleteRecieverEmail(long id);
}

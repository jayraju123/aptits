package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.ContactDetails;

public interface ContactDetailsService
{
    ContactDetails saveContactDetails(ContactDetails contactDetails);

    List<ContactDetails> getAllContactDetails();

    ContactDetails getContactDetailsById(Long id);

    ContactDetails updateContactDetails(Long id, ContactDetails updatedContactDetails);

    void deleteContactDetails(Long id);
}

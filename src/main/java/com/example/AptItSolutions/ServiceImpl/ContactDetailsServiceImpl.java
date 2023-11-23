package com.example.AptItSolutions.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.ContactDetails;
import com.example.AptItSolutions.Repo.ContactDetailsRepository;
import com.example.AptItSolutions.service.ContactDetailsService;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {
	
	@Autowired
    private  ContactDetailsRepository contactDetailsRepository;

  

    @Override
    public ContactDetails saveContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    @Override
    public List<ContactDetails> getAllContactDetails() {
        return contactDetailsRepository.findAll();
    }

    @Override
    public ContactDetails getContactDetailsById(Long id) {
        return contactDetailsRepository.findById(id).orElse(null);
                
    }

    @Override
    public ContactDetails updateContactDetails(Long id, ContactDetails updatedContactDetails) {
        ContactDetails existingContactDetails = getContactDetailsById(id);
        existingContactDetails.setFirstName(updatedContactDetails.getFirstName());
        existingContactDetails.setLastName(updatedContactDetails.getLastName());
        existingContactDetails.setPhoneNumber(updatedContactDetails.getPhoneNumber());
        existingContactDetails.setEmail(updatedContactDetails.getEmail());
        existingContactDetails.setMessage(updatedContactDetails.getMessage());
        return contactDetailsRepository.save(existingContactDetails);
    }

    @Override
    public void deleteContactDetails(Long id) {
        contactDetailsRepository.deleteById(id);
    }
}

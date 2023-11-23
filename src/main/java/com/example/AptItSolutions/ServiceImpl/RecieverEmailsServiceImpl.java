package com.example.AptItSolutions.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.RecieverEmails;
import com.example.AptItSolutions.Repo.RecieverEmailsRepository;
import com.example.AptItSolutions.service.RecieverEmailsService;

@Service
public class RecieverEmailsServiceImpl implements RecieverEmailsService {

    private final RecieverEmailsRepository recieverEmailsRepository;

    @Autowired
    public RecieverEmailsServiceImpl(RecieverEmailsRepository recieverEmailsRepository) {
        this.recieverEmailsRepository = recieverEmailsRepository;
    }

    @Override
    public List<RecieverEmails> getAllRecieverEmails() {
        return recieverEmailsRepository.findAll();
    }

    @Override
    public RecieverEmails getRecieverEmailById(long id) {
        return recieverEmailsRepository.findById(id).orElse(null);
    }

    @Override
    public RecieverEmails saveRecieverEmail(RecieverEmails recieverEmail) {
        return recieverEmailsRepository.save(recieverEmail);
    }

    @Override
    public void deleteRecieverEmail(long id) {
        recieverEmailsRepository.deleteById(id);
    }
}

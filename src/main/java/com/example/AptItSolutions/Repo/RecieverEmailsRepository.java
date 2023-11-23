package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.RecieverEmails;

@Repository
public interface RecieverEmailsRepository extends JpaRepository<RecieverEmails, Long> {
}

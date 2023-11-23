package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.AptItSolutions.Entity.ScrollNews;

@Repository
public interface ScrollNewsRepository extends JpaRepository<ScrollNews, Long> {
}

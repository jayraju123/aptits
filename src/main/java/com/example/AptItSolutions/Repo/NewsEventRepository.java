package com.example.AptItSolutions.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.NewsEvent;

@Repository
public interface NewsEventRepository extends JpaRepository<NewsEvent, Long> {
	List<NewsEvent> findByNewsEventContainingIgnoreCase(String search);

}

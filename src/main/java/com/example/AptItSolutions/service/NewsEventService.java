package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.NewsEvent;
import com.example.AptItSolutions.Entity.ScrollNews;

import java.util.List;

public interface NewsEventService {
    List<NewsEvent> getAllNewsEvents();

    NewsEvent getNewsEventById(Long id);
    NewsEvent save(NewsEvent newsEvent);
  

//    List<NewsEvent> searchNews(String search);
    
    
    NewsEvent saveNewsEvent(Long id, NewsEvent updatedScrollNews);

    void deleteNewsEvent(NewsEvent newsEvent);
}

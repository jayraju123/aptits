package com.example.AptItSolutions.ServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.NewsEvent;
import com.example.AptItSolutions.Repo.NewsEventRepository;
import com.example.AptItSolutions.service.NewsEventService;

@Service
public class NewsEventServiceImpl implements NewsEventService {

    private final NewsEventRepository newsEventRepository;

    @Autowired
    public NewsEventServiceImpl(NewsEventRepository newsEventRepository) {
        this.newsEventRepository = newsEventRepository;
    }

    @Override
    public List<NewsEvent> getAllNewsEvents() {
        return newsEventRepository.findAll();
    }

    @Override
    public NewsEvent getNewsEventById(Long id) {
        Optional<NewsEvent> newsEventOptional = newsEventRepository.findById(id);
        return newsEventOptional.orElse(null);
    }

  

    @Override
    public void deleteNewsEvent(NewsEvent newsEvent) {
        newsEventRepository.delete(newsEvent);
    }


	
	  @Override
	    public NewsEvent saveNewsEvent(Long id, NewsEvent updatedNewsEvent) {
	        NewsEvent existingNewsEvent = newsEventRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("NewsEvent not found with ID: " + id));

	        existingNewsEvent.setNewsEvent(updatedNewsEvent.getNewsEvent());
	        return newsEventRepository.save(existingNewsEvent);
	    }
	  
	  
	   @Override
	    public NewsEvent save(NewsEvent newsEvent) {
	        return newsEventRepository.save(newsEvent);
	    }
//	    public List<NewsEvent> searchNews(String search) {
//	        return newsEventRepository.findByNewsEventContainingIgnoreCase(search);
//	    }
}


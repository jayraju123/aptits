package com.example.AptItSolutions.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.ScrollNews;
import com.example.AptItSolutions.Repo.ScrollNewsRepository;
import com.example.AptItSolutions.service.ScrollNewsService;
@Service
public class ScrollNewsServiceImpl implements ScrollNewsService {

	@Autowired
	 private  ScrollNewsRepository scrollNewsRepository;
	@Override
	public ScrollNews savescrollNews(ScrollNews scrollNews) {
		
        return scrollNewsRepository.save(scrollNews);

	}
	
	   @Override
	    public List<ScrollNews> getAllScrollNews() {
	        return scrollNewsRepository.findAll();
	    }
	
	   
	   @Override
	   public ScrollNews getScrollNewsById(Long id) {
	       return scrollNewsRepository.findById(id)
	               .orElseThrow(() -> new NoSuchElementException("ScrollNews not found with ID: " + id));
	   }
	   
	   
	   @Override
	    public void deleteScrollNews(Long id) {
	        scrollNewsRepository.deleteById(id);
	    }
	   
	   
	   @Override
	   public ScrollNews updateScrollNews(Long id, ScrollNews updatedScrollNews) {
	       ScrollNews existingScrollNews = scrollNewsRepository.findById(id)
	               .orElseThrow(() -> new NoSuchElementException("ScrollNews not found with ID: " + id));

	       existingScrollNews.setScrollNews(updatedScrollNews.getScrollNews());
	       return scrollNewsRepository.save(existingScrollNews);
	   }


}

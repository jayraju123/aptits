package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.ScrollNews;

public interface ScrollNewsService {
	ScrollNews savescrollNews(ScrollNews scrollNews);
	   List<ScrollNews> getAllScrollNews();
	    ScrollNews getScrollNewsById(Long id);
	    void deleteScrollNews(Long id);
	    ScrollNews updateScrollNews(Long id, ScrollNews updatedScrollNews);


}

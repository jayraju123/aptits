package com.example.AptItSolutions.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScrollNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 5000)
    private String scrollNews;
  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScrollNews() {
		return scrollNews;
	}

	public void setScrollNews(String scrollNews) {
		this.scrollNews = scrollNews;
	}

	public ScrollNews(Long id, String scrollNews) {
		super();
		this.id = id;
		this.scrollNews = scrollNews;
	}

	@Override
	public String toString() {
		return "ScrollNews [id=" + id + ", scrollNews=" + scrollNews + "]";
	}

	public ScrollNews() {
		super();
	}

   
}

package com.example.AptItSolutions.Entity;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class NewsEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 5000)
    private String newsEvent;
    private Date date;
    
    @Lob
@Column(columnDefinition = "longblob")
    private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewsEvent() {
		return newsEvent;
	}

	public void setNewsEvent(String newsEvent) {
		this.newsEvent = newsEvent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public NewsEvent(Long id, String newsEvent, Date date, byte[] image) {
		super();
		this.id = id;
		this.newsEvent = newsEvent;
		this.date = date;
		this.image = image;
	}

	@Override
	public String toString() {
		return "NewsEvent [id=" + id + ", newsEvent=" + newsEvent + ", date=" + date + ", image="
				+ Arrays.toString(image) + "]";
	}

	public NewsEvent() {
		super();
		// TODO Auto-generated constructor stub
	} 
    

  
    
    
}
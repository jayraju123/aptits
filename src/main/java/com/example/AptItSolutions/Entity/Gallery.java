package com.example.AptItSolutions.Entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @Lob
    @Column(columnDefinition = "LongBlob")
    
    private byte[] image;
    
    private String description;

	private String link;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Gallery(Long id, String title, byte[] image, String description, String link) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
		this.link = link;
	}

	@Override
	public String toString() {
		return "Gallery [id=" + id + ", title=" + title + ", image=" + Arrays.toString(image) + ", description="
				+ description + ", link=" + link + "]";
	}

	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
  
}
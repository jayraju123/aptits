package com.example.AptItSolutions.Entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Download {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	

	private String description;
	
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] file;
	
	@Column(name = "file_type")
	private String fileType;
	
	
	@Column(name = "count", nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer count;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public Download(int id, String title, String description, byte[] file, String fileType, Integer count) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.file = file;
		this.fileType = fileType;
		this.count = count;
	}


	@Override
	public String toString() {
		return "Download [id=" + id + ", title=" + title + ", description=" + description + ", file="
				+ Arrays.toString(file) + ", fileType=" + fileType + ", count=" + count + "]";
	}


	public Download() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	

}

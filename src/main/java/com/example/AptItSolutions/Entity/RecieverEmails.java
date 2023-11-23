package com.example.AptItSolutions.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class RecieverEmails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RecieverEmails(long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	@Override
	public String toString() {
		return "RecieverEmails [id=" + id + ", email=" + email + "]";
	}
	public RecieverEmails() {
		super();
		// TODO Auto-generated constructor stub
	}

   


}

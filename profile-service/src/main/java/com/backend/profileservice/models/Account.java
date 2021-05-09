package com.backend.profileservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Account {
    
    public Account() {  }
              
    	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
                  
        @Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	
	public Account(String email, String username) {
		this.email = email;
		this.username = username;
		
	}
        
                
        public long getId() {
		return id;
	}
        
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
        
             
        @Override
	public String toString() {
		return "Content [id=" + id + ", email=" + email + ", username=" + username + "]";
	}

}



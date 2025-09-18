package com.cart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String username;

	    @Column(nullable = false)
	    private String password; // Store hashed and encrypted password

	    @Column(nullable = false)
	    private boolean loggedIn; // To track the login status

	    public boolean isLoggedIn() {
	        return loggedIn;
	   
	    }
	    
	 
	    
	    public void setLoggedIn(boolean loggedIn) {
	        this.loggedIn = loggedIn;
	    }
		public Long getId() {
			return id;
		}

		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Long id, String username, String password, boolean loggedIn, List<Cart> cart) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.loggedIn = loggedIn;
		
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public String getPassword() {
			// TODO Auto-generated method stub
			return password;
		
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			// TODO Auto-generated method stub
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", loggedIn=" + loggedIn + "]";
		}
		
		
	}



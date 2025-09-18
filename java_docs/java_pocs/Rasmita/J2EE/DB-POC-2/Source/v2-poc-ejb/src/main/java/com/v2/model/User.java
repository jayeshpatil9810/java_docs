package com.v2.model;

import java.io.Serializable;

public class User implements Serializable{
    private Long userId; 
    private String firstName;
    private String lastName;


    public User(Long userId, String firstName, String lastName) {
        super();
        this.userId = userId; 
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getUserId() { 
        return userId;
    }

    public void setUserId(Long userId) { 
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}






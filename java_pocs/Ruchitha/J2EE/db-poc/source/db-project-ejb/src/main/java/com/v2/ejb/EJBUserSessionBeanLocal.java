package com.v2.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import com.v2.model.User;

@Local
public interface EJBUserSessionBeanLocal {
	public void addUser(String firstName, String lastName, String mobileNumber, String address) throws SQLException;
	public void editUser(int userId, String newFirstName, String newLastName, String newMobileNumber, String newAddress);
	 public void deleteUser(int userId);
	 public List<User> getAllUsers();
	 public User getUser(int userId);
	 
}

package com.v2.session;

import javax.ejb.Local;

import com.v2.model.User;

import java.sql.SQLException;
import java.util.List;

@Local
public interface UserSessionLocal {
    public void addUser(String firstName, String lastName)throws SQLException;

    public void editUser(Long userId, String newFirstName, String newLstName);

    public void deleteUser(Long userId);

    public List<User> getAllUsers();
    
    public User getUser(Long userId);
}



	 
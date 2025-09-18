package com.v2.session;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;

import com.v2.model.User;

@Remote
public interface UserSessionRemote {
    public void addUser(String firstName, String lastName)throws SQLException;

    public void editUser(Long userId, String newFirstName, String newLastName);

    public void deleteUser(Long userId);

    public List<User> getAllUsers();
    
    public User getUser(Long userId);
}


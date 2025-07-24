package com.v2.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import com.v2.model.User;
import java.util.logging.Logger;

@Stateless(mappedName = "UserSessionBean")
public class UserSession implements UserSessionRemote, UserSessionLocal {
	private static final Logger LOGGER = Logger.getLogger(UserSession.class.toString());
	
    public UserSession() {
    }
    @Resource(lookup = "java:jboss/MySqlDS")
    private DataSource dataSource;

    // For adding a new user
    public void addUser(String firstName, String lastName){
    	try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO user (first_name, last_name) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
        	LOGGER.info("Error while adding user: " + e);
        }
    }

    // Edit an existing user
    public void editUser(Long userId, String newFirstName, String newLastName) {
    	try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE user SET first_name = ?, last_name = ? WHERE UserID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newFirstName);
                preparedStatement.setString(2, newLastName);
                preparedStatement.setLong(3, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    public User getUser(Long userId) {
    	User user=null;
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM user WHERE userId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeQuery();
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                	System.out.println("resultSet"+ resultSet);
                  while (resultSet.next()) {
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                         user = new User(userId, firstName, lastName);
                        System.out.println("list of users "+ user);
                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Delete a user by ID
    public void deleteUser(Long userId) {
    	try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM user WHERE userId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

    // Get all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        System.out.println("Getting all users"+ users);
        try (Connection connection = dataSource.getConnection()) {
        	System.out.println("connection"+ connection);
            String sql = "SELECT * FROM user";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            	System.out.println("preparedStatement"+ preparedStatement);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                	System.out.println("resultSet"+ resultSet);
                    while (resultSet.next()) {
                        Long userId = resultSet.getLong("userId");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        User user = new User(userId, firstName, lastName);
                        System.out.println("list of users "+ user);
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return users;
    }
}





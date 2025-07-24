package com.v2.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 * Session Bean implementation class UserSessionBean
 */
@Stateless(mappedName = "UserSessionBean")
public class EJBUserSessionBean implements EJBUserSessionBeanRemote, EJBUserSessionBeanLocal {
	private static final Logger LOGGER = Logger.getLogger(EJBUserSessionBean.class.toString());
	
    /**
     * Default constructor. 
     */
    public EJBUserSessionBean() {
       
    }
    
   
    @Resource(lookup= "java:jboss/MySqlDS")
    private DataSource dataSource;

    // Add a new user
    public void addUser(String firstName, String lastName, String mobileNumber, String address) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO user (first_name, last_name, mobile_number, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, mobileNumber);
                preparedStatement.setString(4, address);
                preparedStatement.executeUpdate();
               // connection.commit();
            }
        } catch (SQLException e) {
        	LOGGER.info("Error while adding user: " + e);
             }
    }

    // Edit an existing user
    public void editUser(int userId, String newFirstName, String newLastName, String newMobileNumber, String newAddress) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE user SET first_name = ?, last_name = ?, mobile_number = ?, address = ? WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newFirstName);
                preparedStatement.setString(2, newLastName);
                preparedStatement.setString(3, newMobileNumber);
                preparedStatement.setString(4, newAddress);
                preparedStatement.setInt(5, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User getUser(int userId) {
    	User user=null;
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM user WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeQuery();
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                	System.out.println("resultSet"+ resultSet);
                	
                  while (resultSet.next()) {
                       
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String mobileNumber = resultSet.getString("mobile_number");
                        String address = resultSet.getString("address");
                         user = new User(userId, firstName, lastName, mobileNumber, address);
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
    public void deleteUser(int userId) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM user WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
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
                        int userId = resultSet.getInt("user_id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String mobileNumber = resultSet.getString("mobile_number");
                        String address = resultSet.getString("address");
                        User user = new User(userId, firstName, lastName, mobileNumber, address);
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







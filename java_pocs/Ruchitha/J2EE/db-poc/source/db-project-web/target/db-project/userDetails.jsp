<%@ page import="com.v2.model.*,java.util.*" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    
    <!-- Form for adding a new user -->
    <h2>Add User</h2>
    <form action="UsersServlet" method="post">
        <input type="hidden" name="action" value="addUser">
        First Name : <input type="text" name="firstName"><br>
        Last Name  : <input type="text" name="lastName"><br>
        Mobile     : <input type="text" name="mobileNumber"><br>
        Address    : <input type="text" name="address"><br>
        <input type="submit" value="Add User">
        
    </form>
    
   <form action="UsersServlet" method="post">
        <input type="hidden" name="action" value="getAllUsers">
        <input type="submit" value="Get All Users">
</form>
    <!-- List of Users -->
    <h2>List of Users</h2>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mobile Number</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        
        <%
         List<User> users=(List<User>)request.getAttribute("users");
        if(null!=users){
        
        for(int i = 0; i < users.size(); i+=1) {
            User user = users.get(i);
         %> 
        
          <tr>
                <td><%= user.getUserid() %></td>
                <td><%= user.getFirstName() %></td>
                <td><%= user.getLastName() %></td>
                <td><%= user.getMobileNumber() %></td>
                <td><%= user.getAddress() %></td>
               <td> <a href="UsersServlet?userId=<%= user.getUserid() %>">Edit</a></td> 
                
                <!-- <td>
                    <form action="UsersServlet" method="post">
                        <input type="hidden" name="action" value="editUser">
                        <input type="hidden" name="userId" value="<%= user.getUserid() %>">
                        <input type="submit" value="Edit">
                    </form>
                </td> -->
                <td>
                    <form action="UsersServlet" method="post">
                        <input type="hidden" name="action" value="deleteUser">
                        <input type="hidden" name="userId" value="<%= user.getUserid() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
     <% }} %>
    </table>
    <br>
    <br>
    
    <% if (request.getAttribute("successMessage") != null) { %>
    <div class="success-message">
        <%= request.getAttribute("successMessage") %>
    </div>
<% } %>
    
 </body>
</html>

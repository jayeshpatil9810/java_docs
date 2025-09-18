<%@ page import="com.v2.model.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>

<h1>User Details</h1>

<!-- Form for adding/editing user -->
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="addUser">
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    <input type="submit" value="Add User">
</form>

<form action="UserServlet" method="post">
        <input type="hidden" name="action" value="getAllUsers">
        <input type="submit" value="Get All Users">
</form>



<table border="1">
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
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
        <td><%= user.getUserId() %></td>
        <td><%= user.getFirstName() %></td>
        <td><%= user.getLastName() %></td>
        <td><a href="UserServlet?userId=<%= user.getUserId() %>">Edit</a></td> 
         

        <td>
            <form action="UserServlet" method="post">
                <input type="hidden" name="action" value="deleteUser">
                <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <% }} %>
    </table>
    <h2>${requestScope.message}</h2>
</body>
</html>

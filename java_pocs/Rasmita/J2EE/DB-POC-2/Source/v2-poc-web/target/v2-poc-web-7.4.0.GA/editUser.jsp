<%@ page import="com.v2.model.*,java.util.*,com.v2.session.*,javax.naming.InitialContext" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>

<%
User user =(User)request.getAttribute("user");
 %>

<form action="UserServlet" method="post">
    <!-- Hidden field for user ID -->
    <input type="hidden" name="action" value="editUser">
    <input type="hidden" name="userId" value="<%= user.getUserId() %>">
    First Name: <input type="text" name="newFirstName" value="<%= user.getFirstName() %>"><br>
    Last Name: <input type="text" name="newLastName" value="<%= user.getLastName() %>"><br>
    <input type="submit" value="Edit User">
</form>

<!-- Back button to return to the user list -->
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="getAllUsers">
    <input type="submit" value="Back to Get All Users">
</form>

<h2>${requestScope.message}</h2>
</body>
</html>



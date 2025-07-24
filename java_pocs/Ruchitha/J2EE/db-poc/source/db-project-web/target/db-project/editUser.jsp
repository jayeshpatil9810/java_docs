<%@ page import="com.v2.model.*,java.util.*,com.v2.ejb.*,javax.naming.InitialContext" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<%-- String userId = request.getParameter(userId); 

User user = getUserFromSomewhere(); 
request.setAttribute("user", user);
--%>
<%
User user =(User)request.getAttribute("user");
 %> 
<form action="UsersServlet" method="post">
    <!-- Hidden field for user ID -->
    <input type="hidden" name="action" value="editUser">
    <input type="hidden" name="userId" value="<%= user.getUserid() %>">
    First Name: <input type="text" name="newFirstName" value="<%= user.getFirstName() %>"><br>
    Last Name: <input type="text" name="newLastName" value="<%= user.getLastName() %>"><br>
    Mobile Number: <input type="text" name="newMobileNumber" value="<%= user.getMobileNumber() %>"><br>
    Address: <input type="text" name="newAddress" value="<%= user.getAddress() %>"><br>
    <input type="submit" value="Edit User">
</form>

</body>
</html>
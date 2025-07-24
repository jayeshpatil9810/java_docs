<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
     <title>Insert your Name</title>
</head>
<body>
     <form action="RasmiServlet" method="post">
        <label for="name">Enter Your Name:</label>
        <input type="text" id="name" name="name">
        <input type="submit" value="Login">
     </form>
     
     <h2>Response from EJB:</h2>
    <p><%= request.getAttribute("responseMessage") %></p>
   
</body>
</html>




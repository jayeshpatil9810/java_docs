<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
</head>
<body>

<form action="GreetingServlet" method="post">
<pre>
  Enter your name:<input type="text" name="name">
                  <input type="submit" value="Submit">  
  </pre>    
    </form>
 <h2>Response from EJB:</h2>
    <p><%= request.getAttribute("responseMessage") %></p>
   
</body>
</html>
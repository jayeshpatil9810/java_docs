package com.v2.servlet;

import java.io.IOException;
import java.util.List;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.v2.model.User;
import com.v2.session.UserSessionRemote;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserServlet() {
    	super();
    }    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("userId"));
        User user =null;

       try {
       	InitialContext ctx = new InitialContext();
        Object lookup = ctx.lookup("java:app/v2-poc-ejb/UserSession!com.v2.session.UserSessionRemote");
        UserSessionRemote userSessionRemote =(UserSessionRemote)lookup;
       	user= userSessionRemote.getUser(userId);
       	request.setAttribute("user", user);
       	request.getRequestDispatcher("editUser.jsp").forward(request, response);
      }catch (Exception e) {
    	  e.printStackTrace();
    	  }
      }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InitialContext ctx = new InitialContext();
            Object lookup = ctx.lookup("java:app/v2-poc-ejb/UserSession!com.v2.session.UserSessionRemote");
            UserSessionRemote userSessionRemote = (UserSessionRemote) lookup;
            
            String action = request.getParameter("action");
            String message = "Action performed successfully!";
            
            if ("addUser".equals(action)) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                userSessionRemote.addUser(firstName, lastName);
                message = "User added successfully!";
                request.setAttribute("message", message);
            } else if ("editUser".equals(action)) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                String newFirstName = request.getParameter("newFirstName");
                String newLastName = request.getParameter("newLastName");
                userSessionRemote.editUser(userId, newFirstName, newLastName);
                message = "User edited successfully!";
	            List<User> users = userSessionRemote.getAllUsers();
	            request.setAttribute("users", users);
	            request.setAttribute("message", message);
	            request.getRequestDispatcher("userList.jsp").forward(request, response);
	            
            } else if ("deleteUser".equals(action)) {
                Long userId = Long.parseLong(request.getParameter("userId"));
                userSessionRemote.deleteUser(userId);
                message = "User deleted successfully!";
                List<User> users = userSessionRemote.getAllUsers();
                request.setAttribute("users", users);
                request.setAttribute("message", message);
                
              } else if ("getAllUsers".equals(action)) {
              List<User> users = userSessionRemote.getAllUsers();
                request.setAttribute("users", users);
                request.setAttribute("message", message);
  	        }
       
//             Redirect to the doGet method to display the list of users after the operation 

	        request.getRequestDispatcher("userList.jsp").forward(request, response);
	    } catch (Exception e) {
			e.printStackTrace();
		}
    }
}
        
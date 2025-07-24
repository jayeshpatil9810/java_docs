package com.v2.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.v2.ejb.EJBUserSessionBeanRemote;
import com.v2.model.User;
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsersServlet() {
        super();
        }

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int userId = Integer.parseInt(request.getParameter("userId"));
      User user =null;

     try {
     	InitialContext ctx = new InitialContext();
      	Object lookup = ctx.lookup("java:global/db-project/db-project-ejb/EJBUserSessionBean!com.v2.ejb.EJBUserSessionBeanRemote");
      	EJBUserSessionBeanRemote remoteBean =(EJBUserSessionBeanRemote)lookup;
     	 user= remoteBean.getUser(userId);
     	 request.setAttribute("user", user);
     	request.getRequestDispatcher("editUser.jsp").forward(request, response);
     	 }catch (Exception e) {
      		e.printStackTrace();
      	}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			InitialContext ctx = new InitialContext();
			Object lookup = ctx.lookup("java:global/db-project/db-project-ejb/EJBUserSessionBean!com.v2.ejb.EJBUserSessionBeanRemote");
			EJBUserSessionBeanRemote remoteBean =(EJBUserSessionBeanRemote)lookup;
			String action = request.getParameter("action");
	

	        if ("addUser".equals(action)) {
	            String firstName = request.getParameter("firstName");
	            String lastName = request.getParameter("lastName");
	            String mobileNumber = request.getParameter("mobileNumber");
	            String address = request.getParameter("address");
	           remoteBean.addUser(firstName, lastName, mobileNumber, address);
	           request.setAttribute("successMessage", "User added successfully!");
	         } else if ("editUser".equals(action)) {
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            String newFirstName = request.getParameter("newFirstName");
	            String newLastName = request.getParameter("newLastName");
	            String newMobileNumber = request.getParameter("newMobileNumber");
	            String newAddress = request.getParameter("newAddress");
	         //   public User getUser(int userId)
	            //User user = remoteBean.getUser(userId);
	            //request.setAttribute("user", user);
	            remoteBean.editUser(userId, newFirstName, newLastName, newMobileNumber, newAddress);
	            List<User> users = remoteBean.getAllUsers();
	            request.setAttribute("users", users);
	            request.setAttribute("successMessage", "User updated successfully!");
	            request.getRequestDispatcher("userDetails.jsp").forward(request, response);
	          } else if ("deleteUser".equals(action)) {
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            remoteBean.deleteUser(userId);
	            List<User> users = remoteBean.getAllUsers();
	            request.setAttribute("users", users);
	            request.setAttribute("successMessage", "User deleted successfully!");

	        } else if ("getAllUsers".equals(action)) {
	        	List<User> users = remoteBean.getAllUsers();
	            request.setAttribute("users", users);
	            //request.getRequestDispatcher("userDetails.jsp").forward(request, response);
	           // return; // Exit the servlet since we've forwarded the request
	        }
	        request.getRequestDispatcher("userDetails.jsp").forward(request, response);
	    } catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
		
	
	

   
   
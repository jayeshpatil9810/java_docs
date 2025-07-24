package com.v2.org;

import java.io.IOException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.v2.org.GreetingEJBRemote;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/GreetingServlet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GreetingServlet() {
        super();
     
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			InitialContext ctx = new InitialContext();
			Object lookup = ctx.lookup("java:global/ejb-tut1/ejb-tut1-war/GreetingEJB!com.v2.org.GreetingEJBRemote");
			GreetingEJBRemote remoteEJB=(GreetingEJBRemote)lookup;
			String greetingMessage = remoteEJB.getGreetingMessage(request.getParameter("name"));
			 request.setAttribute("responseMessage", greetingMessage);
		        request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		}

package com.rasmi.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.v2.org.GreetingEJBRemote;


@WebServlet("/RasmiServlet")
public class RasmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RasmiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
        

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			InitialContext ctx = new InitialContext();
    			Object lookup = ctx.lookup("java:global/rasmita.v2.app/rasmita-in-web-7.4.0.GA/GreetingEJB!com.v2.org.GreetingEJBRemote");
    			//com.v2.org.GreetingEJBRemote remoteEJB = (com.v2.org.GreetingEJBRemote)lookup;
    			GreetingEJBRemote remoteEJB=(GreetingEJBRemote)lookup;
    			String greetingMessage = remoteEJB.getGreetingMessage(request.getParameter("name"));
    			 request.setAttribute("responseMessage", greetingMessage);
    		        request.getRequestDispatcher("/rasmi.jsp").forward(request, response);
    		} catch (NamingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		//String name = request.getParameter("name");
    	   // String greetingMessage = greetingEJB.getGreetingMessage(name);
    	      //  request.setAttribute("responseMessage", responseMessage);
//    	        request.setAttribute("responseMessage", greetingMessage);
//    	        request.getRequestDispatcher("/index.jsp").forward(request, response);
    	    }
    		
    	
 
    }


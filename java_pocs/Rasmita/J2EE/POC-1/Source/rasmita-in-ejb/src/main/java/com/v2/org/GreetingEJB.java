package com.v2.org;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class GreetingEJB
 */
@Stateless(mappedName = "GreetingEJB")
//@LocalBean
public class GreetingEJB implements GreetingEJBLocal, GreetingEJBRemote {

    /**
     * Default constructor. 
     */
    public GreetingEJB() {
        // TODO Auto-generated constructor stub
    }
    public  String getGreetingMessage(String name) {
        return "Hello, " + name + "!";
    }

}

package com.v2.org;

import javax.ejb.Local;

@Local
public interface GreetingEJBLocal {
	 public String getGreetingMessage(String name);
}

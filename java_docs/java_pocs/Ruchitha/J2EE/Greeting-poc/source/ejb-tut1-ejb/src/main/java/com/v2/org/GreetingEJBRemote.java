package com.v2.org;

import javax.ejb.Remote;

@Remote
public interface GreetingEJBRemote {
	 public String getGreetingMessage(String name);
}

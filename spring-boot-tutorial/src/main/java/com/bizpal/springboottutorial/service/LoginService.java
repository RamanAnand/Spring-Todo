package com.bizpal.springboottutorial.service;

import org.springframework.stereotype.Component;

//spring bean
@Component
public class LoginService {

	public boolean validateUser (String userid, String password) {
		return userid.equalsIgnoreCase("raman") 
				&& password.equalsIgnoreCase("test");
	}
}

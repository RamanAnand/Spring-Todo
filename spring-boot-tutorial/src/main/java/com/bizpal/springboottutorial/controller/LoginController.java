package com.bizpal.springboottutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bizpal.springboottutorial.service.LoginService;

@Controller
@SessionAttributes("name")
public final class LoginController {
	
	@Autowired
	LoginService service;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loginMessage(ModelMap model) {
		model.put("name","Raman");
		return "welcome";
	}
	
}

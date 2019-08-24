package com.bizpal.springboottutorial.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleException (HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("url",request.getRequestURL());
		mv.addObject("exception",ex.getStackTrace());
		mv.setViewName("error");
		return mv;
	}

}

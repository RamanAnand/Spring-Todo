package com.bizpal.springboottutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bizpal.springboottutorial.model.Todo;
import com.bizpal.springboottutorial.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todo", method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		model.addAttribute("todo",new Todo());
		String user = (String)model.get("name");
		model.put("todos",service.getTodo(user));
		return "list-todo";
	}
		
	@RequestMapping(value="/list-todo", method=RequestMethod.POST)
	public String addTodos(@Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			String user = (String)model.get("name");
			model.put("todos",service.getTodo(user));
			return "list-todo";
		}
		String user = (String)model.get("name");
		service.addTodo(user, todo.getDescription());
		return "redirect:/list-todo";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodos(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retriveTodo(id);
		model.put("todo",todo);
		String user = (String)model.get("name");
		model.put("todos",service.getTodo(user));
		return "list-todo";
	}

	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			String user = (String)model.get("name");
			model.put("todos",service.getTodo(user));
			return "list-todo";
		}
		service.updateTodo(todo);
		model.addAttribute("todo",new Todo());
		String user = (String)model.get("name");
		model.put("todos",service.getTodo(user));
		return "list-todo";
	}
}

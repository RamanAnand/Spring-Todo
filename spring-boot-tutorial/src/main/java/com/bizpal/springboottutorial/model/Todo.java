package com.bizpal.springboottutorial.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	private String user;
	
	@Size(min = 3, message = "Enter atleast 3 characters")
	private String description;
	private Date targetDate;
	private boolean isDone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public Todo(int id, String user, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	
	
	public Todo() {
		super();
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", description=" + description + ", isDone=" + isDone + "]";
	}
	
	

}
package com.example.JSFexample.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;

@Model 
public class User implements Serializable{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
}

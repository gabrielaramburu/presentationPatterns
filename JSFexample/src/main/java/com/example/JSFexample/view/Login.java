package com.example.JSFexample.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class Login {
	private String userName;
	private String password;
	private String output;
	
	static Logger logger = LogManager.getLogger(Login.class);
	
	public String submit() {
		
		System.out.println("Entrando");
		if (userName.equals("pepe") && password.equals("1234")) {
			System.out.println("credenciales correctas");
			
			return "ejemploBulma.html";
		} else {
			System.out.println("credenciales erroneas");
			output= "Usuario o contraseña incorrecta.";
			return null;
		}
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getOutput() {
		return output;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}

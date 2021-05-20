package com.example.JSFexample.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.example.JSFexample.model.User;

@Named
@RequestScoped
public class Login implements Serializable{
	/* ¿porqué Serializable? Según la especificación de CDI, puede ser neceario que el servidor requiera persistir las clases asociadas a las sessión,
	 * esto puede suceder ante la falta de recursos de servidor. Serialización e sun tipo de mecanismo de persistencia, por lo tanto, algunos seridor obligan
	 * a ciertos managedBean a implementar serialzable */
	
	@Inject
	private User user;
	private String output;
	
	/* solo para probar */
	private int contador;
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String submit() {
		
		System.out.println("Entrando");
		if (correctUserAndPassword(user.getUsername(), user.getPassword())) {
			System.out.println("credenciales correctas");
			
			setearSession();
			
			// esto no cambia la url de la barra de navegación de browser 
			//return "bienvenido.xhtml";
			return "/secure/bienvenido.xhtml?faces-redirect=true";
		} else {
			System.out.println("credenciales erroneas");
			output= "Usuario o contraseña incorrecta.";
			return null;
		}
	}
	
	private void setearSession() {
		/* pongo objeto en la session */
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("login", user);
	}
	
	private boolean correctUserAndPassword(String user, String pass) {
		if (user.equals("pepe") && pass.equals("1234")) {
			return true;
		} else return false;
	}
	
	public String mostrarAyuda() {
		//ayuda es el nombre del archivo ayuda.xhtml
		System.out.println("Estoy en ayuda");
		return "ayuda";
	}
	
	public String getUserName() {
		return user.getUsername();
	}

	public void setUserName(String userName) {
		this.user.setUsername(userName);
	}
	
	public void setPassword(String password) {
		this.user.setPassword(password);
	}

	public String getPassword() {
		return user.getPassword();
	}
	
	public String getOutput() {
		return output;
	}

	public void sumar() {
		contador++;
		this.output=contador+"";
	}

}

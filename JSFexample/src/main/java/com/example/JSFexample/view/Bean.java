package com.example.JSFexample.view;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Named //esta anotación es para bean que interactúan con la la página JSF
@RequestScoped
public class Bean {
	static Logger logger = LogManager.getLogger(Bean.class);
	
	private String input;
    private String output;

    public void submit() {
        output = "Hello World! You have typed: " + input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }
}

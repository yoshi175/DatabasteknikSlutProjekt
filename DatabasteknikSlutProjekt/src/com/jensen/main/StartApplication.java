package com.jensen.main;

import com.jensen.control.Control;
import com.jensen.model.Model;
import com.jensen.view.MainFrame;

/**
 * This class holds the main method to execute the sumo database application.
 * @author Takeyoshi
 * @version 1.0
 */
public class StartApplication {

	public static void main(String[] args) {
		
		MainFrame view = new MainFrame();
		Model model = new Model();
		new Control(model, view);
		
	}
	
}

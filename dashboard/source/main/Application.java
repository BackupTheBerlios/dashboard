package main;

import view.ViewMain;
import control.ControlEnvironment;
import entity.Environment;

public class Application 
{
	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
        new ViewMain(new ControlEnvironment(new Environment())).setVisible(true);
    }

}

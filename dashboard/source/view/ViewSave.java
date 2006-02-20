package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import control.*;
import examples.TestEntity;




public class ViewSave extends JFileChooser{

	/**
	 * 
	 */
	private ControlProject selectedCp;
	private static final long serialVersionUID = 1L;

	public ViewSave(ControlProject pj)
	{
		super();
	    selectedCp=pj;
		
		Control2DBFilter filter=new Control2DBFilter("fichiers 2db",".2db");
		
		this.setCurrentDirectory(new File("/"));
		//this.changeToParentDirectory();
		this.setFileFilter(filter);
		int returnVal =this.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to save this file: " +
		            this.getSelectedFile().getPath());
		       
		       		ControlSave cs = new ControlSave(selectedCp.getProject(),this.getSelectedFile().getPath());
		    }
		 
	}
	
	private void saveAction()
	{
		System.out.println("fic : "+this.getName());
	}
	public static void main(String[] args) {
		 ControlEnvironment envC= new ControlEnvironment(TestEntity.createEnvironment()); 
		ViewSave v=new ViewSave(envC.getControlProjects().get(0));
		/*
		Control2DBFilter filter=new Control2DBFilter("fichiers 2db",".2db");
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("/"));
		chooser.changeToParentDirectory();
		chooser.setFileFilter(filter);
		chooser.showSaveDialog(null);
	 */    
	}

}

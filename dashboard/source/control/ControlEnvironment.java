package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entity.Environment;
import entity.Project;
import entity.WBESet;


/**
 * This class is the controller class that is used to manage
 * the Environment class.  
**/
public class ControlEnvironment 
{

	private Environment env;// object to manage through
	
	
	/**
	 * @author Olivier TANKOANO
	 * contructor
	 * @param <penv> Environment object from which the ControlEnvironment
	 * object will process data.	 * 
	**/
	public ControlEnvironment(Environment penv) {
		this.env = penv;
	}


	/**
	 * @author Olivier TANKOANO
	 * retreives the projects names list.
	 * @return projects names list of "env" Environment object.	 * 
	**/
	public ArrayList<String> getProjectNameList()
	{
		ArrayList<String> l = new ArrayList<String>();
		for(Project p:env.getProjects())
		{			
			l.add(p.getId() + " - " + p.getName());
		}
		return l;
	}

	

	/**
	 * @author Olivier TANKOANO
	 * creates a list of ControlProject obects from the list
	 * of projects in "env" member 
	 * @return list of ControlProject obects from the list of projects in "env" member	  
	**/
	public ArrayList<ControlProject> getControlProjects() {
		ArrayList<ControlProject> l = new ArrayList<ControlProject>();
		for(Project p: env.getProjects())
		{
			l.add(new ControlProject(p));	
		}
		return l;
	}


	
	/**
	 * @author Olivier TANKOANO
	 * creates a list of ControlConsolidation obects from the list
	 * of projects in "env" member 
	 * @return list of ControlConsolidation obects from the list of projects in "env" member	  
	**/
	public ArrayList<ControlConsolidation> getConsolidationHandlers() {
		ArrayList<ControlConsolidation> l = new ArrayList<ControlConsolidation>();
		for(Project p: env.getProjects())
		{
			l.add(new ControlConsolidation(p));	
		}
		return l;
	}


	
	
	/**
	 * @author Olivier TANKOANO
	 * saves the underlying Environment object into a file
	 * @param <filename> the name of the file that will be written on the disk
	 * @exception IOException is thrown if the file cannot be written	 	  
	**/
	public void saveFile(String fileName)		throws IOException 
	{
		FileOutputStream out;
		out = new FileOutputStream(fileName + ".2db");
		ObjectOutputStream s = new ObjectOutputStream(out);
		s.writeObject(env);
		s.flush();
		out.close();
	}
	
	
	/**
	 * @author Olivier TANKOANO
	 * loads a file into the underlying Environment object
	 * @param <filename> the name of the file
	 * @exception ClassNotFoundException is thrown if the file is not found	 	  
	 * @exception IOException is thrown if the file cannot be written
	**/
	public void loadFile(String fileName)		throws ClassNotFoundException, IOException 
	{
		FileInputStream in;
		in = new FileInputStream(fileName + ".2db");
		ObjectInputStream s = new ObjectInputStream(in);
		env = (Environment) s.readObject();
		in.close();
	}

	
}

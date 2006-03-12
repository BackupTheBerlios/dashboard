package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import utils.Functions;
import utils.Pair;

import entity.Environment;
import entity.Project;


/**
 * This class is the controller class that is used to manage
 * the Environment class.  
**/
public class ControlEnvironment 
{

	private Environment env;// object to manage through
	private String lastFileName;
	
	/**
	 * @author Olivier TANKOANO
	 * contructor
	 * @param <penv> Environment object from which the ControlEnvironment
	 * object will process data.	 * 
	**/
	public ControlEnvironment(Environment penv) {
		this.env = penv;
		lastFileName = null;
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
			l.add(p.getName());
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
		if(fileName != null){
			
			if(Functions.getFileNameExtension(fileName) == null || !Functions.getFileNameExtension(fileName).equalsIgnoreCase("ddb"))
			{			
				fileName = fileName + ".ddb";
			}
		
		out = new FileOutputStream(fileName);
		ObjectOutputStream s = new ObjectOutputStream(out);
		s.writeObject(env);
		s.flush();
		out.close();
		lastFileName = fileName;
		}
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
		in = new FileInputStream(fileName);
		ObjectInputStream s = new ObjectInputStream(in);
		env = (Environment) s.readObject();
		in.close();
		lastFileName = fileName;
	}

	
	

	/**
	 * @author Olivier TANKOANO
	 * Returns the lastFileName.
	 * @return the lastFileName.
	 */
	public String getLastFileName() {
		return lastFileName;
	}

	
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * Adds a new Project to the Environment object
	 */		
	public void createNewProject()
	{
		env.getProjects().add(new Project("","[vide]",0.0,0.0));
	}
	
	
	/**
	 * @author Olivier TANKOANO
	 * calculates the number of resources allocated to each project in
	 * the Environment object
	 * @return a Map containing each project with its number of resources	  
	**/
	public ArrayList<Pair<String,Number>> getNbResourcesMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new Integer(p.getResources().size())));
		}
		return map;
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * calculates the number of WorkBreakdownElement of each project in
	 * the Environment object
	 * @return a Map containing each project with its number of 
	 * WorkBreakdownElement	objects  
	**/
	public ArrayList<Pair<String,Number>> getNbWBEsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),p.getWbesRecursive().size()));
		}
		return map;
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * calculates the real work amount of each project in
	 * the Environment object
	 * @return a Map containing each project with its real work amount
	**/
	public ArrayList<Pair<String,Number>> getRealWorkAmountsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),p.getRealWorkAmount()));
		}
		return map;
	}
	
	
	/**
	 * @author Olivier TANKOANO
	 * calculates the previsionnal work amount of each project in
	 * the Environment object
	 * @return a Map containing each project with its previsionnal work amount
	**/
	public ArrayList<Pair<String,Number>> getPrevWorkAmountsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),p.getPrevWorkAmount()));
		}
		return map;
	}
	

	
	
	/**
	 * @author Olivier TANKOANO
	 * calculates the difference between the real and previsionnal work amounts of each project in
	 * the Environment object
	 * @return a Map containing each project with its difference between the real and previsionnal work amounts
	**/
	public ArrayList<Pair<String,Number>> getWorkAmountOffsetsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new ControlPlannable(p).getWorkAmountOffset()));
		}
		return map;
	}
	

	
	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the real start date of each project in
	 * the Environment object
	 * @return a Map containing each project with its real start date
	**/
	public ArrayList<Pair<String, Date>> getRealStartDatesMap()
	{
		ArrayList<Pair<String, Date>> map = new ArrayList<Pair<String, Date>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String, Date>(p.getName(),p.getRealStartDate()));
		}
		return map;
	}
	

	
	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the previsionnal start date of each project in
	 * the Environment object
	 * @return a Map containing each project with its previsionnal start date
	**/
	public ArrayList<Pair<String, Date>> getPrevStartDatesMap()
	{
		ArrayList<Pair<String, Date>> map = new ArrayList<Pair<String, Date>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String, Date>(p.getName(),p.getPrevStartDate()));
		}
		return map;
	}
	

	
	
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the real end date of each project in
	 * the Environment object
	 * @return a Map containing each project with its real end date
	**/
	public ArrayList<Pair<String, Date>> getRealEndDatesMap()
	{
		ArrayList<Pair<String, Date>> map = new ArrayList<Pair<String, Date>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String, Date>(p.getName(),p.getRealEndDate()));
		}
		return map;
	}
	

	
	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the previsionnal end date of each project in
	 * the Environment object
	 * @return a Map containing each project with its previsionnal end date
	**/
	public ArrayList<Pair<String, Date>> getPrevEndDatesMap()
	{
		ArrayList<Pair<String, Date>> map = new ArrayList<Pair<String, Date>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String, Date>(p.getName(),p.getPrevEndDate()));
		}
		return map;
	}
	

		

	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the real duration of each project in
	 * the Environment object
	 * @return a Map containing each project with its real duration
	**/
	public ArrayList<Pair<String,Number>> getRealDurationsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new ControlPlannable(p).getRealDuration()));
		}
		return map;
	}
	

	
	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the previsionnal duration of each project in
	 * the Environment object
	 * @return a Map containing each project with its previsionnal duration
	**/
	public ArrayList<Pair<String,Number>> getPrevDurationsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new ControlPlannable(p).getPrevDuration()));
		}
		return map;
	}
	
	

	
	/**
	 * @author Olivier TANKOANO
	 * returns the duration offset of each project in
	 * the Environment object
	 * @return a Map containing each project with its duration offset
	**/
	public ArrayList<Pair<String,Number>> getDurationOffsetsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new ControlPlannable(p).getDurationOffset()));
		}
		return map;
	}
	
	

	
	
	/**
	 * @author Olivier TANKOANO
	 * returns the duration offset in percentage of each project in
	 * the Environment object
	 * @return a Map containing each project with its duration offset in percentage
	**/
	public ArrayList<Pair<String, Number>> getDurationOffsetPrctsMap()
	{
		ArrayList<Pair<String,Number>> map = new ArrayList<Pair<String,Number>>();
		for(Project p:env.getProjects())
		{			
			map.add(new Pair<String,Number>(p.getName(),new ControlPlannable(p).getDurationOffsetPrct()));
		}
		return map;
	}


	public void reset() 
	{
		env = new Environment();
	}
	
	

	
	
}

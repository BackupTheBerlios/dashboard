package control;

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
	 * creates a list of ConsolidationHandler obects from the list
	 * of projects in "env" member 
	 * @return list of ConsolidationHandler obects from the list of projects in "env" member	  
	**/
	public ArrayList<ConsolidationHandler> getConsolidationHandlers() {
		ArrayList<ConsolidationHandler> l = new ArrayList<ConsolidationHandler>();
		for(Project p: env.getProjects())
		{
			l.add(new ConsolidationHandler(p));	
		}
		return l;
	}

	
}

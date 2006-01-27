package entity;

import java.util.ArrayList;

public class Environment 
{
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private ArrayList<WBESet> wbeSets= new ArrayList<WBESet>();
	
	
	
	/**
	 * @return Returns the projects.
	 */
	public ArrayList<Project> getProjects() {
		return projects;
	}
	
	
	
	
	/**
	 * @param projects The projects to set.
	 */
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}




	/**
	 * @return Returns the wbeSets.
	 */
	public ArrayList<WBESet> getWbeSets() {
		return wbeSets;
	}




	/**
	 * @param wbeSets The wbeSets to set.
	 */
	public void setWbeSets(ArrayList<WBESet> wbeSets) {
		this.wbeSets = wbeSets;
	}

}

package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Environment  implements Serializable
{
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private ArrayList<Project> projects = new ArrayList<Project>();
	

	
	
	
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




}

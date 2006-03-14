package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Environment  implements Serializable
{
	
	private static int minLimit=25;
	private static int maxLimit=70;
	
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

	public static int getMinLimit ()
	{
		return(minLimit);
	}
	public static int getMaxLimit ()
	{
		return(maxLimit);
	}
	public static void setMaxLimit (int limit)
	{
		maxLimit=limit;
	}
	public static void setMinLimit (int limit)
	{
		minLimit=limit;
	}


}

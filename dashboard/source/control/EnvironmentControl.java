package control;

import java.util.ArrayList;

import entity.Environment;
import entity.Project;
import entity.WBESet;

public class EnvironmentControl {

	private Environment env;
	
	
	/**
	 * @param env
	 */
	public EnvironmentControl(Environment penv) {
		// TODO Auto-generated constructor stub
		this.env = penv;
	}


	public ArrayList<String> getProjectNameList()
	{
		ArrayList<String> l = new ArrayList<String>();
		for(Project p:env.getProjects())
		{			
			l.add(p.getId() + " - " + p.getName());
		}
		return l;
	}


	/* (non-Javadoc)
	 * @see entity.Environment#getProjects()
	 */
	public ArrayList<Project> getProjects() {
		return env.getProjects();
	}


	/* (non-Javadoc)
	 * @see entity.Environment#getWbeSets()
	 */
	public ArrayList<WBESet> getWbeSets() {
		return env.getWbeSets();
	}


	/* (non-Javadoc)
	 * @see entity.Environment#setProjects(java.util.ArrayList)
	 */
	public void setProjects(ArrayList<Project> projects) {
		env.setProjects(projects);
	}


	/* (non-Javadoc)
	 * @see entity.Environment#setWbeSets(java.util.ArrayList)
	 */
	public void setWbeSets(ArrayList<WBESet> wbeSets) {
		env.setWbeSets(wbeSets);
	}
}

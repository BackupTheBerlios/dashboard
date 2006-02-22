package entity ;

import java.io.Serializable;
import java.util.Iterator;


/**
 * <p>
 * </p>
 */
public class Project extends Activity implements Serializable {
	
	// /////////////////////////////////////
	// attributes
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */	
	private java.util.ArrayList<WBESet> wbeSets = new java.util.ArrayList<WBESet>();
	
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */	
	private Double prevBudget =0.0;
	
	
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */	
	private Double realBudget =0.0;
	
	
	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();

	/*
	 * Cette variable sert de compteur d'étape.
	 * Elle est à sauvegardé dans le fichier 2DB et à incrémenter à chaque import.
	 */
	private int progress = 0;
	

	/**
	 * @param id
	 * @param name
	 * @param prevBudget
	 * @param realBudget
	 */
	public Project(String id, String name, Double prevBudget, Double realBudget) {
		super(id, name);
		// TODO Auto-generated constructor stub
		this.prevBudget = prevBudget;
		this.realBudget = realBudget;
	}





	/**
	 * @param id
	 * @param name
	 */
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	/**
	 * @return Returns the resources.
	 */
	public java.util.ArrayList<Resource> getResources() {
		return resources;
	}


	/**
	 * @param resources
	 *            The resources to set.
	 */
	public void setResources(java.util.ArrayList<Resource> resources) {
		this.resources = resources;
	}


	/**
	 * @return Returns the wbeSets.
	 */
	public java.util.ArrayList<WBESet> getWbeSets() {
		return wbeSets;
	}


	/**
	 * @param wbeSets
	 *            The wbeSets to set.
	 */
	public void setWbeSets(java.util.ArrayList<WBESet> wbeSets) {
		this.wbeSets = wbeSets;
	}
	
	/**
	 * @param 
	 */
	public Resource findResourceById(java.lang.String pId) throws Exception
	{		
		Iterator<Resource> it;		
		for(it = resources.iterator(); it.hasNext();)
		{
			Resource r = it.next();
			if(r.getId().equals(pId))
			{
				return r;
			}
		}
		throw new Exception("Unknown resource Id!");
	}
	
	/**
	 * @param 
	 */
	public WBESet findWbeSetById(java.lang.String pId) throws Exception
	{		
		Iterator<WBESet> it;		
		for(it = wbeSets.iterator(); it.hasNext();)
		{
			WBESet w = it.next();
			if(w.getId().equals(pId))
			{
				return w;
			}
		}
		throw new Exception("Unknown WBESet Id!");
	}



	/**
	 * @return Returns the prevBudget.
	 */
	public Double getPrevBudget() {
		return prevBudget;
	}



	/**
	 * @param prevBudget The prevBudget to set.
	 */
	public void setPrevBudget(Double prevBudget) {
		this.prevBudget = prevBudget;
	}



	/**
	 * @return Returns the realBudget.
	 */
	public Double getRealBudget() {
		return realBudget;
		
	}



	/**
	 * @param realBudget The realBudget to set.
	 */
	public void setRealBudget(Double realBudget) {
		this.realBudget = realBudget;
	}
	
	public int []getImportNumbers()
	{
		int [] res= new int[this.getSubActivities().size()];
		int i;
		for(i=0;i<this.getSubActivities().size();i++)
		{
			res[i]=i+1;
		}
		return res;
	}
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}


} // end Project







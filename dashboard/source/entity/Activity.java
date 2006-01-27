package entity;

import java.util.Date;
import java.util.Iterator;

/*
 * Java class "Activity.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */

/**
 * <p>
 * </p>
 */
public class Activity extends Plannable {

	// /////////////////////////////////////
	// attributes

	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private String name;

	/**
	 * <p>
	 * Represents ...
	 * </p>
	 */
	private String id;

	// /////////////////////////////////////
	// associations
	// WorkBreakDownElement

	/**
	 * <p>
	 * </p>
	 */
	private java.util.ArrayList<Activity> subActivities = new java.util.ArrayList<Activity>();

	/**
	 * <p>
	 * </p>
	 */
	private java.util.ArrayList<WorkBreakDownElement> wbes = new java.util.ArrayList<WorkBreakDownElement>();

	/**
	 * @param id
	 * @param name
	 */
	public Activity(String id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	
	public Activity() {
		// TODO Auto-generated constructor stub
		this.id = null;
		this.name = null;
	}

	
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getPrevEndDate()
	 */
	@Override
	public Date getPrevEndDate() {
		//the PrevEndDate will be the PrevEndDate of the lattest subActivity		
		Date res = null;
		if (!subActivities.isEmpty()) {
			res = subActivities.iterator().next().getPrevEndDate();
			for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
				Activity ac = it.next();
				if (res.after(ac.getPrevEndDate())) {
					res = ac.getPrevEndDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getPrevEndDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if (res.after(wbe.getPrevEndDate())) {
					res = wbe.getPrevEndDate();
				}
			}
		}
		return res;
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getPrevStartDate()
	 */
	@Override
	public Date getPrevStartDate() {
		//the PrevStartDate will be the PrevStartDate of the first subActivity		
		Date res = null;
		if (!subActivities.isEmpty()) {
			res = subActivities.iterator().next().getPrevStartDate();
			for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
				Activity ac = it.next();
				if (res.before(ac.getPrevStartDate())) {
					res = ac.getPrevStartDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getPrevStartDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if (res.before(wbe.getPrevStartDate())) {
					res = wbe.getPrevStartDate();
				}
			}
		}
		return res;

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getPrevWorkAmount()
	 */
	@Override
	public Double getPrevWorkAmount() {
		double amount = 0;
		for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
			Activity ac = it.next();
			amount = amount + ac.getPrevWorkAmount();
		}
		for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
			WorkBreakDownElement wbe = it.next();
			amount = amount + wbe.getPrevWorkAmount();
		}
		return new Double(amount);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getRealEndDate()
	 */
	@Override
	public Date getRealEndDate() {
		//the RealEndDate will be the RealEndDate of the lattest subActivity		
		Date res = null;
		if (!subActivities.isEmpty()) {
			res = subActivities.iterator().next().getRealEndDate();
			for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
				Activity ac = it.next();
				if (res.after(ac.getRealEndDate())) {
					res = ac.getRealEndDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getRealEndDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if (res.after(wbe.getRealEndDate())) {
					res = wbe.getRealEndDate();
				}
			}
		}
		return res;
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getRealStartDate()
	 */
	@Override
	public Date getRealStartDate() {
		//the RealStartDate will be the RealStartDate of the first subActivity		
		Date res = null;
		if (!subActivities.isEmpty()) {
			res = subActivities.iterator().next().getRealStartDate();
			for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
				Activity ac = it.next();
				if (res.before(ac.getRealStartDate())) {
					res = ac.getRealStartDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getRealStartDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if (res.before(wbe.getRealStartDate())) {
					res = wbe.getRealStartDate();
				}
			}
		}
		return res;

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.Plannable#getRealWorkAmount()
	 */
	@Override
	public Double getRealWorkAmount() {
		double amount = 0;
		for (Iterator<Activity> it = subActivities.iterator(); it.hasNext();) {
			Activity ac = it.next();
			amount = amount + ac.getRealWorkAmount();
		}
		for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
			WorkBreakDownElement wbe = it.next();
			amount = amount + wbe.getRealWorkAmount();
		}
		return new Double(amount);
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the subActivities.
	 */
	public java.util.ArrayList<Activity> getSubActivities() {
		return subActivities;
	}

	/**
	 * @param subActivities
	 *            The subActivities to set.
	 */
	public void setSubActivities(java.util.ArrayList<Activity> subActivities) {
		this.subActivities = subActivities;
	}

	/**
	 * @return Returns the wbes.
	 */
	public java.util.ArrayList<WorkBreakDownElement> getWbes() {
		return wbes;
	}

	/**
	 * @param wbes The wbes to set.
	 */
	public void setWbes(java.util.ArrayList<WorkBreakDownElement> wbes) {
		this.wbes = wbes;
	}

	/**
	 * @param 
	 */
	public Activity findActivityById(java.lang.String pId) throws Exception
	{		
		Iterator<Activity> it;		
		for(it = subActivities.iterator(); it.hasNext();)
		{
			Activity a = it.next();
			if(a.getId().equals(pId))
			{
				return a;
			}
		}
		throw new Exception("Unknown activity Id!");
	}
	
	
	public WorkBreakDownElement findWbeById(java.lang.String pId) throws Exception
	{		
		Iterator<WorkBreakDownElement> it;		
		for(it = wbes.iterator(); it.hasNext();)
		{
			WorkBreakDownElement w = it.next();
			if(w.getId().equals(pId))
			{
				return w;
			}
		}
		throw new Exception("Unknown WorkBreakDownElement Id!");
	}
	
} // end Activity


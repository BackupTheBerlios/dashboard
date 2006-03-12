package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
public class Activity extends Plannable implements Serializable{

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
		this.id = "";
		this.name = "";
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
				if(ac.getPrevEndDate() != null)
				if (res.before(ac.getPrevEndDate())) {
					res = ac.getPrevEndDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getPrevEndDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if(wbe.getPrevEndDate() != null)
				if (res.before(wbe.getPrevEndDate())) {
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
				if(ac.getPrevStartDate() != null)
				if (res.after(ac.getPrevStartDate())) {
					res = ac.getPrevStartDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getPrevStartDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if(wbe.getPrevStartDate() != null)
				if (res.after(wbe.getPrevStartDate())) {
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
			if(ac.getPrevWorkAmount() != null)
				amount = amount + ac.getPrevWorkAmount();
		}
		for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
			WorkBreakDownElement wbe = it.next();
			if(wbe.getPrevWorkAmount() != null)
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
				if(ac.getRealEndDate() != null)
				if (res.before(ac.getRealEndDate())) {
					res = ac.getRealEndDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getRealEndDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if(wbe.getRealEndDate() != null)
				if (res.before(wbe.getRealEndDate())) {
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
				if(ac.getRealStartDate() != null)
				if (res.after(ac.getRealStartDate())) {
					res = ac.getRealStartDate();
				}
			}
		}
		if ((res == null)&& !wbes.isEmpty()) {
			res = wbes.iterator().next().getRealStartDate();
			for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
				WorkBreakDownElement wbe = it.next();
				if(wbe.getRealStartDate() != null)
				if (res.after(wbe.getRealStartDate())) {
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
			if(ac.getRealWorkAmount()!=null)
				amount = amount + ac.getRealWorkAmount();
		}
		for (Iterator<WorkBreakDownElement> it = wbes.iterator(); it.hasNext();) {
			WorkBreakDownElement wbe = it.next();
			if(wbe.getRealWorkAmount()!=null)
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
	 * @param wbes The wbes to set.
	 */
	public void setWbes(java.util.ArrayList<WorkBreakDownElement> wbes) {
		this.wbes = wbes;
	}

	

	/**
	 * @return Returns the wbes.
	 */
	public java.util.ArrayList<WorkBreakDownElement> getWbes() {
		return wbes;
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
	
	
	
	public java.util.ArrayList<WorkBreakDownElement> getWbesRecursive()
	{
		java.util.ArrayList<WorkBreakDownElement> l = new java.util.ArrayList<WorkBreakDownElement>();
		l.addAll(this.getWbes());
		for(Activity ac:subActivities)
		{
			java.util.ArrayList<WorkBreakDownElement> subL = ac.getWbesRecursive();
			l.addAll(subL );
		}
		return l;
	}	
	
	
	
	/**
	 * @param override from Plannable
	 */
	public HashMap<Resource,Double> getResourcesUsage() 
	{
		HashMap<Resource,Double> map = new HashMap<Resource,Double>();
		
		//gather all sub resourceUsage map
		ArrayList<HashMap<Resource,Double>> subMaps = new ArrayList<HashMap<Resource,Double>>(); 
		for(Activity ac: subActivities)
		{
			subMaps.add(ac.getResourcesUsage());
		}
		for(WorkBreakDownElement wbe: wbes)
		{
			subMaps.add(wbe.getResourcesUsage());
		}
		
		//process sub maps
		for(HashMap<Resource,Double> subMap: subMaps)
		{
			for(Resource r: subMap.keySet())
			{
				if(map.containsKey(r))
				{
					Double d = map.get(r);
					map.remove(r);
					double dAdd = d.doubleValue() + subMap.get(r).doubleValue();
					map.put(r,new Double(dAdd));
				}
				else
				{
					map.put(r, subMap.get(r));
				}
			}
		}
		
		return map;
	}



} // end Activity


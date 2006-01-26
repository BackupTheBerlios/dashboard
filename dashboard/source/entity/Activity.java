 package entity;

import java.util.Collection;
import java.util.Iterator;

/*
 * Java class "Activity.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class Activity extends Plannable {
	
	///////////////////////////////////////
	// attributes
	
	
	/**
	 * <p>Represents ...</p>
	 */
	private String name; 
	private String id;
	private int duration;
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p></p>
	 * 
	 * @poseidon-type WorkBreakDownElement
	 */
	private java.util.Collection<WorkBreakDownElement> workBreakDownElements = new java.util.ArrayList<WorkBreakDownElement>(); // of type WorkBreakDownElement
	/**
	 * <p></p>
	 */
	private java.util.Collection<Activity> activities= new java.util.ArrayList<Activity>(); 
	
	
	/**
	 * <p></p>
	 */
	private Project project; 

	
	
	///////////////////////////////////////
	// operations
	
	
	public Activity() {
		super();
		this.name = null;
		this.id = null;
		project = null;
	}
	
	/**
	 * @param name
	 * @param id
	 */
	public Activity(String id) {
		super();
		this.name = null;
		this.id = id;
		project = null;
	}
	
	
	/**
	 * @param name
	 * @param id
	 */
	public Activity(String id, String name) {
		super();
		this.name = name;
		this.id = id;
	
		project = null;
	}
	


	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id ;
	}
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public Double getPrevisionsCharges() {        
		return null;
	}       
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public Double getPrevisionsDelais() {        
		return null;
	}     
	
	/**
	 * @return Returns the activities.
	 */
	public java.util.Collection getActivities() {
		return activities;
	}
	
	/**
	 * @return Returns the workBreakDownElements.
	 */
	public java.util.Collection<WorkBreakDownElement> getWorkBreakDownElements() {
		return workBreakDownElements;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isWbesEmpty() {
		return workBreakDownElements.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	public int sizeOfWbes() {
		return workBreakDownElements.size();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	public Iterator<WorkBreakDownElement> iteratorOnWbes() {
		return workBreakDownElements.iterator();
	}
	
	/**
	 * @param activities The activities to set.
	 */
	public void setActivities(java.util.Collection<Activity> activities) {
		this.activities = activities;
	}
	
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param workBreakDownElements The workBreakDownElements to set.
	 */
	public void setWorkBreakDownElements(java.util.Collection<WorkBreakDownElement> workBreakDownElements) {
		this.workBreakDownElements = workBreakDownElements;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#add(E)
	 */
	public boolean addWorkBreakDownElement(WorkBreakDownElement arg) {
		arg.setActivity(this);
		return workBreakDownElements.add(arg);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addWorkBreakDownElementsAll(Collection<? extends WorkBreakDownElement> workBreakDownElements) {
		WorkBreakDownElement work = null;
		for(Iterator<? extends WorkBreakDownElement> i= workBreakDownElements.iterator(); i.hasNext(); work = i.next()){
			work.setActivity(this);
		}
		
		return this.workBreakDownElements.addAll(workBreakDownElements);
	}
	
	public String toString() {
		String work = "";
		Iterator it2 = null;
		Iterator it= workBreakDownElements.iterator();
		
		WorkBreakDownElement act= null;
		Working wk = null;
		
		while(it.hasNext()){
			act = (WorkBreakDownElement) it.next();
			work +="\n\t<wbe " + act.getName() +" ,";
			it2 = act.getWorkings().iterator();
			while(it2.hasNext()){
				wk = (Working) it2.next();
				work += "\n\t\t<wking " + wk.getName() + ", " + wk.getWorkAmount()+ ">";
			}
			work += "\n\t>";
			
		}
		
		return "<A " + this.getName() + "," + work+ "\n>";
	}
	
	/**
	 * @return Returns the project.
	 */
	public Project getProject() {
		return project;
	}
	
	/**
	 * @param project The project to set.
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @param duration of activiry to set and get.
	 */
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
} // end Activity







package entity;

import java.util.*;
/*
 * Java class "Project.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class Project extends Plannable {

  ///////////////////////////////////////
  // attributes


/**
 * <p></p>
 * 
 * @poseidon-type Activity
 */
	
    private java.util.Collection<Activity> activities = new java.util.ArrayList<Activity>();// of type Activity 
    private java.util.Collection<WBESet> wbeSets = new java.util.ArrayList<WBESet>();

   ///////////////////////////////////////
   // associations

/**
 * <p>Represents ...</p>
 */
    private String name;


  ///////////////////////////////////////
  // operations



    /**
 */
public Project(String name) {
	super();
	// TODO Auto-generated constructor stub
	this.name = name;
}

/**
 * <p>Does ...</p>
 * 
 */
    public Double getPrevisionsCharges() {
		return null;
		
        // your code here
    } // end getPrevisionsCharges        

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public Double getPrevisionsDelais() {        
        // your code here
       return  null;
    } // end getPrevisionsDelais        

/**
 * @return Returns the activities.
 */
public java.util.Collection<Activity> getActivities() {
	return activities;
}

/**
 * @return Returns the name.
 */
public String getName() {
	return name;
}

/**
 * @return Returns the wbeSets.
 */
public java.util.Collection<WBESet> getWbeSets() {
	return wbeSets;
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
 * @param wbeSets The wbeSets to set.
 */
public void setWbeSets(java.util.Collection<WBESet> wbeSets) {
	this.wbeSets = wbeSets;
}

/* (non-Javadoc)
 * @see java.util.Collection#add(E)
 */
public boolean addActivity(Activity activity) {
	return activities.add(activity);
}

/* (non-Javadoc)
 * @see java.util.Collection#addAll(java.util.Collection)
 */
public boolean addAllActivities(Collection<Activity> activities) {
	return this.activities.addAll(activities);
}

/* (non-Javadoc)
 * @see java.util.Collection#contains(java.lang.Object)
 */
public boolean containsActivity(Activity activity) {
	return activities.contains(activity);
}

/* (non-Javadoc)
 * @see java.util.Collection#isEmpty()
 */
public boolean isActivitiesEmpty() {
	return activities.isEmpty();
}

/* (non-Javadoc)
 * @see java.util.Collection#iterator()
 */
public Iterator<Activity> activitiesIterator() {
	return activities.iterator();
}

/* (non-Javadoc)
 * @see java.util.Collection#size()
 */
public int ActivitiesSize() {
	return activities.size();
}



 } // end Project






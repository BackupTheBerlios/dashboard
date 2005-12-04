
package entity;

import java.util.Collection;
import java.util.Iterator;

/*
 * Java class "WorkBreakDowElement.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class WorkBreakDownElement extends Plannable {

  ///////////////////////////////////////
  // attributes


/**
 * <p>Represents ...</p>
 */
    private String name; 
    private String id;
   ///////////////////////////////////////
   // associations

/**
 * <p></p>
 * 
 * @poseidon-type Working
 */
    
    public java.util.Collection<Working> workings = new java.util.ArrayList<Working>(); // of type Working
/**
 * <p></p>
 */
    public Activity activity = null; 
/**
 * <p></p>
 */
    public WBESet wBESet; 


  ///////////////////////////////////////
  // operations


/**
 * @param id
 * @param name
 */
public WorkBreakDownElement(String id, String name) {
	super();
	// TODO Auto-generated constructor stub
	this.id = id;
	this.name = name;
}

/**
 * @return Returns the workings.
 */
public java.util.Collection<Working> getWorkings() {
	return workings;
}

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public Double getReal() {        
        // your code here
        return null;
    } // end getReal        

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public Double getPrevisionsDelais() {        
        // your code here
        return null;
    } // end getPrevisionsDelais        

/**
 * <p>Does ...</p>
 * 
 * 
 * @return 
 */
    public Double getPrevisionsCharges() {        
        // your code here
        return null;
    } // end getPrevisionsCharges        

/**
 * @return Returns the activity.
 */
public Activity getActivity() {
	return activity;
}

/**
 * @return Returns the name.
 */
public String getName() {
	return name;
}

/**
 * @return Returns the wBESet.
 */
public WBESet getWBESet() {
	return wBESet;
}

/**
 * @param activity The activity to set.
 */
public void setActivity(Activity activity) {
	this.activity = activity;
}

/**
 * @param name The name to set.
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @param set The wBESet to set.
 */
public void setWBESet(WBESet set) {
	wBESet = set;
}

/**
 * @return Returns the id.
 */
public String getId() {
	return id;
}
public String toString() {
	return id;
}

/* (non-Javadoc)
 * @see java.util.Collection#add(E)
 */
public boolean addWorking(Working working) {
	working.setWorkBreakDownElement(this);
	return this.workings.add(working);
}

/* (non-Javadoc)
 * @see java.util.Collection#addAll(java.util.Collection)
 */
public boolean addWorkingsAll(Collection<? extends Working> workings) {
	Working work = null;
	for(Iterator<? extends Working> i= workings.iterator(); i.hasNext(); work = i.next()){
			work.setWorkBreakDownElement(this);
	}
	return this.workings.addAll(workings);
}

/* (non-Javadoc)
 * @see java.util.Collection#isEmpty()
 */
public boolean isWorkingsEmpty() {
	return workings.isEmpty();
}

/* (non-Javadoc)
 * @see java.util.Collection#iterator()
 */
public Iterator<Working> iteratorOnWorkings() {
	return workings.iterator();
}

/* (non-Javadoc)
 * @see java.util.Collection#size()
 */
public int sizeOfWorkings() {
	return workings.size();
}

 } // end WorkBreakDowElement







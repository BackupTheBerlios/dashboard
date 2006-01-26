
package entity;

import java.util.Collection;
import java.util.Iterator;


/**
 * <p>this class represent the association beetween a participant(Resource) and a WorkBreakdown Element </p>
 * @docRoot dashboard
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
	
	
	public java.util.Collection<Working> workings = new java.util.ArrayList<Working>(); // of type Working
	/**
	 * <p></p>
	 */
	public Activity activity = null; 
	/**
	 * <p></p>
	 */
	public WBESet wBESet = null; 
	
	
	///////////////////////////////////////
	// operations
	
	
	/**
	 * @param id
	 * @param name
	 */
	public WorkBreakDownElement(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public WorkBreakDownElement(String id) {
		super();
		this.id = id;
		this.name = null;
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
	public Double getPrevisionsDelais() {        
		
		return null;
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
	 *
	 * @return Returns the wBESet.
	 */
	public WBESet getWBESet() {
		return wBESet;
	}
	
	/**
	 * 
	 * @param pactivity The activity to set.
	 */
	public void setActivity(Activity pactivity) {
		this.activity = pactivity;
	}
	
	/**
	 *
	 * @param pname The name to set.
	 */
	public void setName(String pname) {
		this.name = pname;
	}
	
	/**
	 * 
	 * @param pset The wBESet associated.
	 */
	public void setWBESet(WBESet pset) {
		wBESet = pset;
	}
	
	/**
	 *
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return id;
	}
	
	
	/**
	 * <P>Add a working to the associated workings Collection<BR></p>
	 * <p>this method set associated wbElement of working to add with this</p>
	 * @param pworking the working to associate with (added)
	 * @return Returns boolean indicate if working was added
	 */
	public boolean addWorking(Working pworking) {
		pworking.setWorkBreakDownElement(this);
		return this.workings.add(pworking);
	}
	
	/**
	 * <P>Add the elements of a workings Collection to the associated workings Collection.<BR></p>
	 * <p>this method set associated wbElement of workings to add with this</p>
	 * @param pworkings the workings Colllection to associate with (added)
	 * @return Returns boolean indicate if all workings were added
	 */
	public boolean addWorkingsAll(Collection<? extends Working> pworkings) {
		Working lwork = null;
		for(Iterator<? extends Working> i= pworkings.iterator(); i.hasNext(); lwork = i.next()){
			lwork.setWorkBreakDownElement(this);
		}
		return this.workings.addAll(pworkings);
	}
	
	/**
	 * <p>this method is a getter that returns  <BR> if associated workings Collection is Empty</p>
	 * @return boolean  
	 */
	public boolean isWorkingsEmpty() {
		return workings.isEmpty();
	}
	
	/**
	 * <p>this method is a getter that returns an iterator on <BR>the workings Collecton.</p>
	 * @return Returns an iterator on workings collection of this wbElement
	 */
	public Iterator<Working> iteratorOnWorkings() {
		return workings.iterator();
	}
	
	/**
	 * <p>this method is a getter that returns account of workins associated.</p>
	 * @return the associated workings Collection account
	 */
	public int sizeOfWorkings() {
		return workings.size();
	}
	
	public Double getReel() {
		Double reel = 0.0;
		for(Working working: this.getWorkings()){
			reel += working.getWorkAmount();
		}
		return reel;
	}
	
	
} // end WorkBreakDowElement







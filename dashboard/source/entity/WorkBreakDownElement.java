
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


/**
 * <p>this class represent the association beetween a participant(Resource) and a WorkBreakdown Element </p>
 * @docRoot dashboard
 */

public class WorkBreakDownElement extends Plannable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////
	// attributes
	
	
	/**
	 * <p>Represents the name of the WBE</p>
	 */
	private String name; 
		
	/**
	 * <p>Represents the id of the WBE</p>
	 */
	private String id;


	/**
	 * <p>Represents the start date of the WBE</p>
	 */
	private Date realStartDate;


	/**
	 * <p>Represents the end date of the WBE</p>
	 */
	private Date realEndDate;


	/**
	 * <p>Represents the previsionnal start date of the WBE</p>
	 */
	private Date prevStartDate;
	


	/**
	 * <p>Represents the previsionnal end date of the WBE</p>
	 */
	private Date prevEndDate;
	
	


	/**
	 * <p>Represents ...</p>
	 */
	private Double prevWorkAmount;
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p>list of working for a WBE</p>
	 */
	private java.util.ArrayList<Working> workings = new java.util.ArrayList<Working>(); // of type Working
	
	
	/**
	 * <p>list of WBE set for a WBE</p>
	 */
	private java.util.ArrayList<WBESet> wbeSets = new java.util.ArrayList<WBESet>(); // of type Working
	
	/**
	 * @param id
	 * @param name
	 * @param prevStartDate
	 * @param prevEndDate
	 * @param prevWorkAmount
	 * @param realStartDate
	 * @param realWorkAmount
	 * @param realEndDate
	 */
	public WorkBreakDownElement(String id, String name, Date prevStartDate, Date prevEndDate, Double prevWorkAmount, Date realStartDate,  Date realEndDate, Double realWorkAmount) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.prevStartDate = prevStartDate;
		this.prevEndDate = prevEndDate;
		this.prevWorkAmount = prevWorkAmount;
		this.realStartDate = realStartDate;
		this.realEndDate = realEndDate;
	}
	
	
	public WorkBreakDownElement() {
		// TODO Auto-generated constructor stub
		this.id = "";
		this.name = "";
		this.prevStartDate = null;
		this.prevEndDate = null;
		this.prevWorkAmount = null;
		this.realStartDate = null;
		this.realEndDate = null;
	}
	
	
	
	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
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
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the prevEndDate.
	 */
	public Date getPrevEndDate() {
		return prevEndDate;
	}
	/**
	 * @param prevEndDate The prevEndDate to set.
	 */
	public void setPrevEndDate(Date prevEndDate) {
		this.prevEndDate = prevEndDate;
	}
	/**
	 * @return Returns the prevStartDate.
	 */
	public Date getPrevStartDate() {
		return prevStartDate;
	}
	/**
	 * @param prevStartDate The prevStartDate to set.
	 */
	public void setPrevStartDate(Date prevStartDate) {
		this.prevStartDate = prevStartDate;
	}
	/**
	 * @return Returns the prevWorkAmount.
	 */
	public Double getPrevWorkAmount() {
		return prevWorkAmount;
	}
	/**
	 * @param prevWorkAmount The prevWorkAmount to set.
	 */
	public void setPrevWorkAmount(Double prevWorkAmount) {
		this.prevWorkAmount = prevWorkAmount;
	}
	/**
	 * @return Returns the realEndDate.
	 */
	public Date getRealEndDate() {
		return realEndDate;
	}
	/**
	 * @param realEndDate The realEndDate to set.
	 */
	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}
	/**
	 * @return Returns the realStartDate.
	 */
	public Date getRealStartDate() {
		return realStartDate;
	}
	/**
	 * @param realStartDate The realStartDate to set.
	 */
	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
	}
	/**
	 * @return Returns the realWorkAmount.
	 */
	public Double getRealWorkAmount() {

			return this.getRealWorkAmountOfKnownWorkings();

		
	}
	
	public Double getRealWorkAmountOfKnownWorkings(){
		Double temp = new Double(0.0);
		for(Working work: this.getWorkings()){
			if(work.getWorkAmount()!= null)
				temp = temp + work.getWorkAmount();

		}
	
		return temp;
	}
	/**
	 * @param realWorkAmount The realWorkAmount to set.
	 */
	public void setRealWorkAmount(Double realWorkAmount) {
	}
	/**
	 * @return Returns the workings.
	 */
	public java.util.ArrayList<Working> getWorkings() {
		return workings;
	}
	/**
	 * @param workings The workings to set.
	 */
	public void setWorkings(java.util.ArrayList<Working> workings) {
		this.workings = workings;
	}
	
	/**
	 * @param 
	 */
	public Working findWorkingById(java.lang.String pId) throws Exception
	{		
		Iterator<Working> it;		
		for(it = workings.iterator(); it.hasNext();)
		{
			Working w = it.next();
			if(w.getId().equals(pId))
			{
				return w;
			}
		}
		throw new Exception("Unknown Working Id!");
	}


	/**
	 * @return Returns the wbeSets.
	 */
	public java.util.ArrayList<WBESet> getWbeSets() {
		return wbeSets;
	}


	/**
	 * @param wbeSets The wbeSets to set.
	 */
	public void setWbeSets(java.util.ArrayList<WBESet> wbeSets) {
		this.wbeSets = wbeSets;
	}


	/**
	 * @param override from Plannable
	 */
	public HashMap<Resource,Double> getResourcesUsage() 
	{
		HashMap<Resource,Double> map = new HashMap<Resource,Double>();
		for(Working wk: workings)
		{
			if(map.containsKey(wk.getResource()))
			{
				Double d = map.get(wk.getResource());
				map.remove(wk.getResource());
				double dAdd = d.doubleValue() + wk.getWorkAmount().doubleValue();
				map.put(wk.getResource(),new Double(dAdd));
			}
			else
			{
				map.put(wk.getResource(), wk.getWorkAmount());
			}
		}
		return map;
	}
	
} // end WorkBreakDowElement







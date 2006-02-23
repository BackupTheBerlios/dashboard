package entity;

import java.io.Serializable;



/**
 * <p>this class represent the association beetween a participant(Resource) and a WorkBreakdown Element </p>
 * @docRoot dashboard
 */

public class Working implements Serializable{
	
	///////////////////////////////////////
	// attributes
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>Represents the workamount that will be used to estimate workBreakdownElement amount </p>
	 */
	private Double workAmount = 0.0; 
	
	/**
	 * <p>Represents the working identificator </p>
	 */
	private String id = null;
	
	/**
	 * <p>Represents the working description </p>
	 */
	private String description = null;
	
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p>Represents Resource link to access to the associated resource </p>
	 * 
	 * @link Resource
	 */
	public Resource resource = null; // of type Resource
	
	
	
	
	/**
	 * @param id
	 * @param description
	 * @param workAmount
	 * @param resource
	 * @param workBreakDownElement
	 */
	public Working(String pid, String pdescription, Double pworkAmount, Resource presource) {
		this.id = pid;
		this.description = pdescription;
		this.workAmount = pworkAmount;
		this.resource = presource;	
		this.resource.addWorking(this);
	}


	/**
	 * @param pid the workAmount 
	 * @param pname the Working identificator
	 * @param pworkAmount the Working name
	 */
	public Working( String pid, String pDesc, Double pworkAmount) {
		
		this.workAmount = pworkAmount;
		this.id = pid;
		this.description = pDesc;
	}
	
	
	/** 
	 * <p>Constructor taken 2 parameters the String id and the Double workAmount  </p>
	 * @param pid the Working identificator
	 * @param pworkAmount the Working name
	 */
	public Working( String pid, Double pworkAmount) {
		this.workAmount = pworkAmount;
		this.id = pid;
	}
	
	
	
	public Working(String id) {
		this.id = id;
	}


	/**
	 * 
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	
	
	/***
	 * 
	 * @return Returns the workAmount.
	 */
	public Double getWorkAmount() {
		return workAmount;
	}


	/**
	 * 
	 * @return Returns the resource.
	 */
	public Resource getResource() {
		return resource;
	}
	
	
	/**
	 *  
	 * @param pworkAmount The workAmount to set.
	 */
	public void setWorkAmount(Double pworkAmount) {
		this.workAmount = pworkAmount;
	}


	/**
	 * 
	 * @param presource The resource associate to set.
	 */
	public void setResource(Resource presource) {
		this.resource = presource;
		this.resource.addWorking(this);
	}
	
	

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
} // end Working







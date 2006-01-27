package entity;



/**
 * <p>this class represent the association beetween a participant(Resource) and a WorkBreakdown Element </p>
 * @docRoot dashboard
 */

public class Working {
	
	///////////////////////////////////////
	// attributes
	
	
	/**
	 * <p>Represents the workamount that will be used to estimate workBreakdownElement consommation </p>
	 */
	private Double workAmount = 0.0; 
	
	/**
	 * <p>Represents the working identificator </p>
	 */
	private String id = null;
	
	/**
	 * <p>Represents the working name </p>
	 */
	private String description = null;
	
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p>Represents Resource link to access to the associate resource </p>
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
		// TODO Auto-generated constructor stub
		this.id = pid;
		this.description = pdescription;
		this.workAmount = pworkAmount;
		this.resource = presource;		
	}


	/**
	 * <p>Constructor taken 3 parameters the String id, the String name and the Double workAmount  </p>
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







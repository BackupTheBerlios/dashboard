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
	private Double workAmount = null; 
	
	/**
	 * <p>Represents the working identificator </p>
	 */
	private String id;
	
	/**
	 * <p>Represents the working name </p>
	 */
	private String name;
	
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p>Represents Resource link to access to the associate resource </p>
	 * 
	 * @link Resource
	 */
	public Resource resource; // of type Resource
	
	
	/**
	 * <p>Represents WBE link to access to the associate WorkBreakDownElement </p>
	 * 
	 * @link WorkBreakDownElement
	 */
	public WorkBreakDownElement workBreakDownElement; // of type WorkBreakDowElement
	
	
	
	
	
	/**
	 * <p>Constructor taken 3 parameters the String id, the String name and the Double workAmount  </p>
	 * @param pid the workAmount 
	 * @param pname the Working identificator
	 * @param pworkAmount the Working name
	 */
	public Working( String pid, String pname, Double pworkAmount) {
		
		this.workAmount = pworkAmount;
		this.id = pid;
		this.name = pname;
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
	
	
	
	/**
	 * 
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	
	
	/**
	 * 
	 * @return Returns this Working name.
	 */
	public String getName() {
		return name;
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
	 * @return Returns the workBreakDowElement associate.
	 */
	public WorkBreakDownElement getWorkBreakDownElement() {
		return workBreakDownElement;
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
	 * 
	 * @param pworkBreakDownElement The workBreakDowElement associate to set.
	 */
	public void setWorkBreakDownElement(WorkBreakDownElement pworkBreakDownElement) {
		this.workBreakDownElement = pworkBreakDownElement;
	}
	
	
	
} // end Working







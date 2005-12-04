package entity;
/*
 *  Java class "Working.java" generated from Poseidon for UML.
 *  Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 *  Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */

/**
 * <p></p>
 */
public class Working {

  ///////////////////////////////////////
  // attributes


/**
 * <p>Represents ...</p>
 */
    private Double workAmount = null; 
    private String id;
    private String name;


   ///////////////////////////////////////
   // associations

/**
 * <p></p>
 * 
 * @poseidon-type Resource
 */
    public Resource resource; // of type Resource
/**
 * <p></p>
 * 
 * @poseidon-type WorkBreakDowElement
 */
    public WorkBreakDownElement workBreakDownElement; // of type WorkBreakDowElement
    




/**
 * @param workAmount
 * @param id
 * @param name
 */
public Working( String id, String name, Double workAmount) {
	super();
	// TODO Auto-generated constructor stub
	this.workAmount = workAmount;
	this.id = id;
	this.name = name;
}



/**
 * @param workAmount
 * @param id
 */
public Working( String id, Double workAmount) {
	super();
	// TODO Auto-generated constructor stub
	this.workAmount = workAmount;
	this.id = id;
}



/**
 * @return Returns the id.
 */
public String getId() {
	return id;
}


/**
 * @return Returns the resource.
 */
public Resource getResource() {
	return resource;
}
/**
 * @return Returns the workAmount.
 */
public Double getWorkAmount() {
	return workAmount;
}
/**
 * @return Returns the workBreakDowElement.
 */
public WorkBreakDownElement getWorkBreakDownElement() {
	return workBreakDownElement;
}
/**
 * @param resource The resource to set.
 */
public void setResource(Resource resource) {
	this.resource = resource;
}
/**
 * @param workAmount The workAmount to set.
 */
public void setWorkAmount(Double workAmount) {
	this.workAmount = workAmount;
}
/**
 * @param workBreakDowElement The workBreakDowElement to set.
 */
public void setWorkBreakDownElement(WorkBreakDownElement workBreakDownElement) {
	this.workBreakDownElement = workBreakDownElement;
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



/* (non-Javadoc)
 * @see java.lang.String#equals(java.lang.Object)
 */
public boolean equals(Object workin) {
	
	return (workin instanceof Working) && ((Working)workin).getId().equals(this.getId());
}




} // end Working







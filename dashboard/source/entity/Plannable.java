package entity;
/*
 * Java class "Plannable.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */
import java.util.Date;


/**
 * <p></p>
 */
public abstract class Plannable {
	
	///////////////////////////////////////
	// attributes
	
	
	/**
	 * <p>Represents ...</p>
	 */
	
	///////////////////////////////////////
	// operations
	
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Double getPrevWorkAmount();
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Double getRealWorkAmount();
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Date getRealStartDate();
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Date getRealEndDate();
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Date getPrevStartDate();
	
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Date getPrevEndDate();

	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract String getName();
	

	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract String getId();
	
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public String toString()
	{
		return getId() + " - " + getName();
	}
	
	
	
} // end Plannable







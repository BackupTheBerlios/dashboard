package entity;


import java.util.Date;

	
	/**
	 * This class is the and abstract class that represents any task, activity
	 * or set of activities that can be planned. 
	**/
	public abstract class Plannable {
		
		
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the previsionnal work amount
	 * @return the previsionnal work amount
	**/
	public abstract Double getPrevWorkAmount();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the real work amount
	 * @return the real work amount
	**/	
	public abstract Double getRealWorkAmount();
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the real end date 
	 * @return the real end date 
	**/
	public abstract Date getRealEndDate();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the previsionnal start date 
	 * @return the previsionnal start date 
	**/
	public abstract Date getPrevStartDate();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the real start date 
	 * @return the real start date 
	**/
	public abstract Date getRealStartDate();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the previsionnal end date 
	 * @return the previsionnal end date 
	**/
	public abstract Date getPrevEndDate();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the name
	 * @return the name
	**/
	public abstract String getName();
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes and returns the id
	 * @return the name
	**/
	public abstract String getId();
	
	
	/**
	 * @author Olivier TANKOANO
	 * constructs a String from the name and the id
	 * @return a String from the name and the id
	**/
	public String toString()
	{
		return getId() + " - " + getName();
	}
	
	
} // end Plannable







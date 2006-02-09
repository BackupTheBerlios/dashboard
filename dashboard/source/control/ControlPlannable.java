package control;

import java.util.Date;

import entity.Plannable;


/**
 * This class is the controller class that is used to manage
 * the Planable class.  
**/
public class ControlPlannable 
{

	private Plannable plannable;;  // object to manage through

	
	
	/**
	 * @author Olivier TANKOANO
	 * contructor
	 * @param <penv> Plannable object from which the ControlPlannable
	 * object will process data.	 * 
	**/
	public ControlPlannable(Plannable p) {
		this.plannable = p;
	}

	
	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getPrevEndDate()	  
	**/
	public Date getPrevEndDate() {
		return plannable.getPrevEndDate();
	}



	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getPrevStartDate()	  
	**/
	public Date getPrevStartDate() {
		return plannable.getPrevStartDate();
	}

	
	
	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getPrevWorkAmount()	  
	**/
	public Double getPrevWorkAmount() {
		return plannable.getPrevWorkAmount();
	}



	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getRealEndDate()	  
	**/
	public Date getRealEndDate() {
		return plannable.getRealEndDate();
	}

	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getRealStartDate()	  
	**/
	public Date getRealStartDate() {
		return plannable.getRealStartDate();
	}



	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getRealWorkAmount()  
	**/
	public Double getRealWorkAmount() {
		return plannable.getRealWorkAmount();
	}
	
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the real work amount and the
	 * previsionnal work amount read from "plannable" member
	 * @return plannable.getRealWorkAmount() - plannable.getPrevWorkAmount()	 *    
	**/
	public Double getWorkAmountOffset() {
		return plannable.getRealWorkAmount() - plannable.getPrevWorkAmount();
	}
	
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the real start date and the
	 * previsionnal start date read from "plannable" member
	 * @return plannable.getRealStartDate() - plannable.getPrevStartDate() or null
	 * if any is null
	**/
	public Long getStartOffset()
	{
		if((plannable.getRealStartDate()!=null) && (plannable.getPrevStartDate()!=null))
		{
			return Utils.subDates(plannable.getRealStartDate(),plannable.getPrevStartDate());
		}
		else
		{			
			return null;
		}
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the previsionnal duration and the
	 * real duration obtained from "plannable" member
	 * @return getRealDuration() - getPrevDuration()
	**/
	public Long getDurationOffset()
	{
		if((getRealDuration()!=null) &&( getPrevDuration()!=null))
		{
			return getRealDuration() - getPrevDuration();
		}
		else
		{
			return null;
		}		
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the real end date and the
	 * previsionnal end date read from "plannable" member
	 * @return plannable.getRealEndDate() - plannable.getPrevEndDate() or null
	 * if any is null
	**/
	public Long getGlobalOffset()
	{
		if((plannable.getRealEndDate()!=null) && (plannable.getPrevEndDate()!=null))
		{
			return Utils.subDates(plannable.getRealEndDate(),plannable.getPrevEndDate());
		}
		else
		{
			return null;
		}		
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * percentage version of getStartOffset()
	 * @return getStartOffset() / getPrevDuration()  *100 or null
	 * if any is null
	**/
	public Double getStartOffsetPrct()
	{
		if((getStartOffset()!=null) && ( getPrevDuration()!=null))
		{
			return getStartOffset().doubleValue() / getPrevDuration() *100;
		}
		else
		{
			return null;
		}
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * percentage version of getDurationOffset()
	 * @return getDurationOffset().doubleValue() / getPrevDuration() *100 or null
	 * if any is null
	**/
	public Double getDurationOffsetPrct()
	{
		if((getDurationOffset()!=null) && (getPrevDuration()!=null))
		{
			return getDurationOffset().doubleValue() / getPrevDuration() *100;
		}
		else
		{
			return null;
		}		
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * percentage version of getGlobalOffset()
	 * @return getGlobalOffset().doubleValue() / getPrevDuration() *100 or null
	 * if any is null
	**/
	public Double getGlobalOffsetPrct()
	{
		if((getGlobalOffset()!=null) && (getPrevDuration()!=null))
		{
			return getGlobalOffset().doubleValue() / getPrevDuration() *100;
		}
		else
		{
			return null;
		}			
	}
	
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the real end date and the
	 * real start date read from "plannable" member
	 * @return plannable.getRealEndDate() - plannable.getRealStartDate() or null
	 * if any is null
	**/
	public Long getRealDuration()
	{
		if((plannable.getRealEndDate()!=null) && (plannable.getRealStartDate()!=null))
		{
			return Utils.subDates(plannable.getRealEndDate(),plannable.getRealStartDate());
		}
		else
		{
			return null;
		}			
	}
	

	
	/**
	 * @author Olivier TANKOANO
	 * computes the difference between the previsonnal end date and the
	 * previsonnal start date read from "plannable" member
	 * @return plannable.getPrevEndDate() - plannable.getPrevStartDate() or null
	 * if any is null
	**/
	public Long getPrevDuration()
	{
		if((plannable.getPrevEndDate()!=null) && (plannable.getPrevStartDate()!=null))
		{
			return Utils.subDates(plannable.getPrevEndDate(),plannable.getPrevStartDate());
		}
		else
		{
			return null;
		}			
	}
	
	
	


	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getName()	  
	**/
	public String getName() {
		return plannable.getName();
	}

	
	
	/**
	 * @author Olivier TANKOANO
	 * delegate method from "plannable" member
	 * @return plannable.getId()	  
	**/
	public String getId() {
		return plannable.getId();
	}
}

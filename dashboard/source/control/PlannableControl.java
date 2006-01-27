package control;

import java.util.Date;

import entity.Plannable;

public class PlannableControl {

	private Plannable plannable;

	/**
	 * @param plannable
	 */
	public PlannableControl(Plannable p) {
		// TODO Auto-generated constructor stub
		this.plannable = p;
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getPrevEndDate()
	 */
	public Date getPrevEndDate() {
		return plannable.getPrevEndDate();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getPrevStartDate()
	 */
	public Date getPrevStartDate() {
		return plannable.getPrevStartDate();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getPrevWorkAmount()
	 */
	public Double getPrevWorkAmount() {
		return plannable.getPrevWorkAmount();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getRealEndDate()
	 */
	public Date getRealEndDate() {
		return plannable.getRealEndDate();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getRealStartDate()
	 */
	public Date getRealStartDate() {
		return plannable.getRealStartDate();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getRealWorkAmount()
	 */
	public Double getRealWorkAmount() {
		return plannable.getRealWorkAmount();
	}
	
	
	
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
	
	
	
	
	public Long getDurationOffset()
	{
		if((getGlobalOffset()!=null) &&( getStartOffset()!=null))
		{
			return getGlobalOffset() - getStartOffset();
		}
		else
		{
			return null;
		}		
	}
	
	
	
	
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
	

	/* (non-Javadoc)
	 * @see entity.Plannable#getName()
	 */
	public String getName() {
		return plannable.getName();
	}

	/* (non-Javadoc)
	 * @see entity.Plannable#getId()
	 */
	public String getId() {
		return plannable.getId();
	}
}

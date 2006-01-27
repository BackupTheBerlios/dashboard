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
		return Utils.subDates(plannable.getRealStartDate(),plannable.getPrevStartDate());	
	}
	
	
	
	
	public Long getDurationOffset()
	{
		return getGlobalOffset() - getStartOffset();	
	}
	
	
	
	
	public Long getGlobalOffset()
	{
		return Utils.subDates(plannable.getRealEndDate(),plannable.getPrevEndDate());	
	}
	
	
	
	
	public Double getStartOffsetPrct()
	{
		return getStartOffset().doubleValue() / getPrevDuration() *100;		
	}
	
	
	
	public Double getDurationOffsetPrct()
	{
		return getDurationOffset().doubleValue() / getPrevDuration() *100;	
	}
	
	
	
	
	public Double getGlobalOffsetPrct()
	{
		return getGlobalOffset().doubleValue() / getPrevDuration() *100;	
	}
	
	
	
	public Long getRealDuration()
	{
		return Utils.subDates(plannable.getRealEndDate(),plannable.getRealStartDate());	
	}
	

	
	
	public Long getPrevDuration()
	{
		return Utils.subDates(plannable.getPrevEndDate(),plannable.getPrevStartDate());	
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

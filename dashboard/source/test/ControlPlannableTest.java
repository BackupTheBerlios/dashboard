package test;

import junit.framework.TestCase;

import java.util.Date;
import control.ControlPlannable;
import control.Utils;
import entity.Plannable;
	
public class ControlPlannableTest extends TestCase {
		private ControlPlannable plannableC1;
		private ControlPlannable plannableC2;
		private ControlPlannable plannableC3;
		private ControlPlannable plannableC4;
		
	public void setUp()
	{	
		plannableC1 = new ControlPlannable(new Plannable (){
			public  Double getPrevWorkAmount(){return (10.0);}
			public  Double getRealWorkAmount(){return (10.0);}
			public  Date getRealStartDate(){return (null);}
			public  Date getRealEndDate(){return (null);}
			public  Date getPrevStartDate(){return (null);}
			public  Date getPrevEndDate(){return (null);}
			public  String getName(){return ("");}
			public  String getId(){return ("");}
			});
		plannableC2 = new ControlPlannable(new Plannable (){
			public  Double getPrevWorkAmount(){return (100001.0);}
			public  Double getRealWorkAmount(){return (100000.0);}
			public  Date getPrevStartDate(){
				int jour=1,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealStartDate(){
				int jour=2,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getPrevEndDate(){
				int jour=27,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealEndDate(){
				int jour=30,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  String getName(){return ("p2");}
			public  String getId(){return ("p2");}
			});
		plannableC3 = new ControlPlannable(new Plannable (){
			public  Double getPrevWorkAmount(){return (10000.0);}
			public  Double getRealWorkAmount(){return (10001.0);}
			public  Date getPrevStartDate(){
				int jour=2,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealStartDate(){
				int jour=1,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			
			public  Date getPrevEndDate(){
				int jour=10,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealEndDate(){
				int jour=9,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  String getName(){return ("p3");}
			public  String getId(){return ("p3");}
			});
		plannableC4 = new ControlPlannable(new Plannable (){
			public  Double getPrevWorkAmount(){return (0.1);}
			public  Double getRealWorkAmount(){return (1.0);}
			public  Date getPrevStartDate(){
				int jour=2,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealStartDate(){
				int jour=2,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			
			public  Date getPrevEndDate(){
				int jour=10,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  Date getRealEndDate(){
				int jour=10,mois=10,annee=105;
				Date d = new Date(annee,mois,jour);
				return (d);}
			public  String getName(){return ("p4");}
			public  String getId(){return ("p4");}
			});
	}
	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getWorkAmountOffset()'
	 */
	public void testGetWorkAmountOffset() {
		assertTrue(plannableC1.getWorkAmountOffset() == 0.0);
		assertTrue(plannableC2.getWorkAmountOffset() == -1.0);
		assertTrue(plannableC3.getWorkAmountOffset() == 1.0);
		assertTrue(plannableC4.getWorkAmountOffset() == 0.9);
	}

	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getStartOffset()'
	 */
	public void testGetStartOffset() {
		assertTrue(plannableC1.getStartOffset() == null);
		assertTrue(plannableC2.getStartOffset() == 1);
		assertTrue(plannableC3.getStartOffset() == -1);
		assertTrue(plannableC4.getStartOffset() == 0);
	}

	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getGlobalOffset()'
	 */
	public void testGetGlobalOffset() {
		assertTrue(plannableC1.getGlobalOffset() == null);
		assertTrue(plannableC2.getGlobalOffset() == 3);
		assertTrue(plannableC3.getGlobalOffset() == -1);
		assertTrue(plannableC4.getGlobalOffset() == 0);
	}

	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getRealDuration()'
	 */
	public void testGetRealDuration() {
		assertTrue(plannableC1.getRealDuration() == null);
		assertTrue(plannableC2.getRealDuration() == 28);
		assertTrue(plannableC3.getRealDuration() == 8);
		assertTrue(plannableC4.getRealDuration() == 8);
	}

	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getPrevDuration()'
	 */
	public void testGetPrevDuration() {
		assertTrue(plannableC1.getPrevDuration() == null);
		assertTrue(plannableC2.getPrevDuration() == 26);
		assertTrue(plannableC3.getPrevDuration() == 8);
		assertTrue(plannableC4.getPrevDuration() == 8);
	}
	
	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getGlobalOffsetPrct()'
	 */
	public void testGetGlobalOffsetPrct() {
		assertTrue(plannableC1.getGlobalOffsetPrct() == null);
		assertTrue(plannableC2.getGlobalOffsetPrct() == (3.0/26)*100);
		assertTrue(plannableC3.getGlobalOffsetPrct() == (-1.0/8)*100);
		assertTrue(plannableC4.getGlobalOffsetPrct() == 0);
	}

	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getDurationOffset()'
	 */
	public void testGetDurationOffset() {
		assertTrue(plannableC1.getDurationOffset() == null);
		assertTrue(plannableC2.getDurationOffset() == 2);
		assertTrue(plannableC3.getDurationOffset() == 0);
		assertTrue(plannableC4.getDurationOffset() == 0);
	}
	
	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getStartOffsetPrct()'
	 */
	public void testGetStartOffsetPrct() {
		assertTrue(plannableC1.getStartOffsetPrct() == null);
		assertTrue(plannableC2.getStartOffsetPrct() == (1.0/26)*100);
		assertTrue(plannableC3.getStartOffsetPrct() == (-1.0/8)*100);
		assertTrue(plannableC4.getStartOffsetPrct() == 0);
	}
	
	/*@author Alexandre SIMONNET
	 * Test method for 'control.ControlPlannable.getDurationOffsetPrct()'
	 */
	public void testGetDurationOffsetPrct() {
		assertTrue(plannableC1.getDurationOffsetPrct() == null);
		assertTrue(plannableC2.getDurationOffsetPrct() == (2.0/26)*100);
		assertTrue(plannableC3.getDurationOffsetPrct() == 0);
		assertTrue(plannableC4.getDurationOffsetPrct() == 0);

	}
}

package control;

import java.util.ArrayList;
import java.util.Vector;

import utils.Pair;
import entity.Plannable;
import entity.Project;

public class ControlAlert {
	
	private static  double min = -0.2;
	private static double max = 0.2;

	
	public ControlAlert(Double min, Double max) {
		super();
		// TODO Auto-generated constructor stub
		if(min != null) ControlAlert.min = min;
		if(max != null)ControlAlert.max = max;
	}

	public static Pair<Vector<String>,Vector<Vector>> vectorAlertAmount(ControlProject proj){
		AlertIndicator amountIndicator = new AlertIndicator(){
			
		
			public Double getPrevious() {
				
				return plannable.getPrevWorkAmount();
			}

			public Double getReal() {
				
				return plannable.getRealWorkAmount();
			}
			
		};

		
		return createTableModelValue(proj, amountIndicator);
	}	
	
	public static Pair<Vector<String>,Vector<Vector>> vectorAlertDuration(ControlProject proj){
		
		AlertIndicator amountIndicator = new AlertIndicator(){
		public Double getPrevious() {
			
			return plannable.getPrevDuration().doubleValue();
		}

		public Double getReal() {
			
			return plannable.getRealDuration().doubleValue();
		}
		
	};

	
	return createTableModelValue(proj, amountIndicator);
	}
	
	public static Pair<Vector<String>,Vector<Vector>> createTableModelValue(ControlProject proj, AlertIndicator computer){
		Vector<String>	nomDesColonnes	= new Vector<String>();
		nomDesColonnes.addElement("nom");
		nomDesColonnes.addElement("prevision");
		nomDesColonnes.addElement("réel");
		nomDesColonnes.addElement("dépassement");
		Vector<Vector>	valeurDesChamps	= new Vector<Vector>();
		Vector<Object>	elements	= null;
		
		
		ArrayList<Pair<String,Plannable>> activities = proj.getProject().getHierrarchyRecursive();
		IndicatorState percent;

		for(Pair<String,Plannable> activity: activities){
			computer.setPlannable(activity.getSecond());
			percent = computer.compute();	

				//if(percent.getLed() == IndicatorState.BAD || percent.getLed() == IndicatorState.MEDIUM){

					elements = new Vector<Object>();
					elements.addElement(activity.getFirst());
					elements.addElement(computer.getPrevious());
					elements.addElement(computer.getReal());
					elements.addElement(percent);
					
					valeurDesChamps.addElement(elements);
				//}
			}
		
		
		return new Pair<Vector<String>,Vector<Vector>>(nomDesColonnes,valeurDesChamps);
	
	}

	
	 abstract static class AlertIndicator extends IIndicator{
		ControlPlannable plannable = new ControlPlannable ();
		public double min;
		public double max;
		
		public AlertIndicator(){
			
		}
		public  abstract Double getPrevious();
		
		public  abstract Double getReal();
		
		public void setPlannable(Plannable plannable) {
			this.plannable.setPlannable(plannable);
		}
		
		public  IndicatorState compute(){
			IndicatorState indic = new IndicatorState();
			indic.setValue((getReal() - getPrevious()) / getPrevious());
			
			if(indic.getValue() > this.getTresholdMax()){
				indic.setLed(IndicatorState.BAD);
			}
			else if(indic.getValue() < this.getTresholdMin()){
				indic.setLed(IndicatorState.MEDIUM);
			}
			else{
				indic.setLed(IndicatorState.GOOD);
			}
				
			return indic;
			
		}
		public double getTresholdMax() {
			return ControlAlert.max;
		}

		public double getTresholdMin() {
			return ControlAlert.min;
		}
	}

}


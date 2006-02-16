package control;

import entity.*;

public class ControlProject {

	/* Indicateurs globaux du projet sur le tps(avancement) et le budget
	 * 	ils mettent en relation l'estimation par rapport � la r�alisation
	 */
	private String nameP;
	
	private double tps;
	private double budget;
	
	//Ces deux tableaux contiennent les donn�es du projet: Temps/Budget 
	private double estimation[] = new double [2];
	private double realisation[] = new double [2];
	
	/*
	 * R�f�rence vers le projet, afin de r�cup�rer les donn�es 
	 * n�cessaires aux calculs des indicateurs
	 */
	Project p ;
	
	public ControlProject(Project p) {
		super();
		// TODO Auto-generated constructor stub
		this.p = p;
		
		//R�cup�ration du nom du projet
		this.nameP=this.p.getName();
		
		//R�cup�ration des donn�es
		this.estimation[0]=p.getPrevWorkAmount();
		this.estimation[1]=p.getPrevBudget();
		
		this.realisation[0]=p.getRealWorkAmount();
		this.realisation[1]=p.getRealBudget();
		
		//Calcul des indicateurs
		this.cTps(this.estimation[0],this.realisation[0]);
		this.cBudget(this.estimation[1],this.realisation[1]);
	}
	
	
	/*
	 * Getteurs de la classe
	 */
	public String getNameP() {
		return nameP;
	}
	
	public double getTps() {
		return tps;
	}

	public double getBudget() {
		return budget;
	}
	
	public double[] getEstimation() {
		return estimation;
	}
	
	public double[] getRealisation() {
		return realisation;
	}

	
	
	/*
	 * M�thodes de la classe
	 */
	
	/* Cette fonction permet de connaitre en pourcentage 
	 * l'avancement du projet en fonction des estimations 
	 * et du temps effectif attribu�e � la r�alisation du projet. 
	 */
	public void cTps(double Testime, double Tconsomme ){
		
		this.tps = (Tconsomme*100)/Testime;
	}
	
	
	/* Cette fonction permet de connaitre en pourcentage
	 * la quantit� du budget qui a �t� d�pens�. 
	 */ 
	public void cBudget(double Bestime,double Bconsomme){
		
		this.budget = (Bconsomme*100)/Bestime;
	}


	public Project getP() {
		return p;
	}


	 
	
}

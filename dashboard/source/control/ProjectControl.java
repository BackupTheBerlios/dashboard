package control;

import entity.*;

public class ProjectControl {

	/* Indicateurs globaux du projet sur le tps(avancement) et le budget
	 * 	ils mettent en relation l'estimation par rapport à la réalisation
	 */
	private String nameP;
	
	private double tps;
	private double budget;
	
	//Ces deux tableaux contiennent les données du projet: Temps/Budget 
	private double estimation[] = new double [2];
	private double realisation[] = new double [2];
	
	/*
	 * Référence vers le projet, afin de récupérer les données 
	 * nécessaires aux calculs des indicateurs
	 */
	Project p ;
	
	public ProjectControl(Project p) {
		super();
		// TODO Auto-generated constructor stub
		this.p = p;
		
		//Récupération du nom du projet
		this.nameP=this.p.getName();
		
		//Récupération des données
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
	 * Setteurs de la classe
	 */
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	
	public void setTps(int tps) {
		this.tps = tps;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public void setEstimation(double[] pEstimation) {
		this.estimation = pEstimation;
	}
	
	public void setRealisation(double[] pRealisation) {
		this.realisation = pRealisation;
	}
	
	/*
	 * Méthodes de la classe
	 */
	
	/* Cette fonction permet de connaitre en pourcentage 
	 * l'avancement du projet en fonction des estimations 
	 * et du temps effectif attribuée à la réalisation du projet. 
	 */
	public void cTps(double Testime, double Tconsomme ){
		
		this.tps = (Tconsomme*100)/Testime;
	}
	
	
	/* Cette fonction permet de connaitre en pourcentage
	 * la quantité du budget qui a été dépensé. 
	 */ 
	public void cBudget(double Bestime,double Bconsomme){
		
		this.budget = (Bconsomme*100)/Bestime;
	}
	
}

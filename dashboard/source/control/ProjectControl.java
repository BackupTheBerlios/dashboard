package control;

import entity.*;

public class ProjectControl {

	//Ces deux variables contiennent les calculs des indicateurs
	private int avancement;
	private int budget;
	
	//Ces deux tableaux contiennent les données du projet: Temps/Budget 
	private int estimation[] = new int [2];
	private int realisation[] = new int [2];
	

	public ProjectControl(String name){
		
		Project p = new Project(name);
		/*récupérer du package entity toutes les données utiles(estimées et effectives)
		 * au calcul des indicateurs sur le projet
		 */
	}
	/*
	 * Getteurs de la classe
	 */
	
	public int getAvancement() {
		return avancement;
	}

	public int getBudget() {
		return budget;
	}
	
	public int[] getEstimation() {
		return estimation;
	}
	
	public int[] getRealisation() {
		return realisation;
	}

	/*
	 * Setteurs de la classe
	 */
	
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public void setEstimation(int[] estimation) {
		this.estimation = estimation;
	}
	
	public void setRealisation(int[] realisation) {
		this.realisation = realisation;
	}
	
	/*
	 * Méthodes de la classe
	 */
	
	/* Cette fonction permet de connaitre en pourcentage 
	 * l'avancement du projet en fonction des estimations 
	 * et du temps effectif attribuée à la réalisation du projet. 
	 */
	public void cAvancement(int Testime, int Tconsomme ){
		
		this.avancement = (Tconsomme*100)/Testime;
	}
	
	
	/* Cette fonction permet de connaitre en pourcentage
	 * la quantité du budget qui a été dépensé. 
	 */ 
	public void cBudget(int Bestime,int Bconsomme){
		
		this.budget = (Bconsomme*100)/Bestime;
	}
		
}

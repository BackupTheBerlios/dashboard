package control;

import entity.*;

public class ProjectControl {

	private int avancement;
	private int rapport;
	private int budget;
	
	Project p = new Project(null);
	/*r�cup�rer du package entity toutes les donn�es utiles et n�cessaires
	 * au calcul des indicateurs sur le projet
	 */

	/*
	 * Getteurs de la classe
	 */
	
	public int getAvancement() {
		return avancement;
	}

	public int getRapport() {
		return rapport;
	}
	
	public int getBudget() {
		return budget;
	}

	/*
	 * Setteurs de la classe
	 */
	
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public void setRapport(int rapport) {
		this.rapport = rapport;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	/*
	 * M�thodes de la classe
	 */
	
	public void cAvancement(int Tconsomme, int Testime ){
		
	}
	
	public void cRapport(int Bconsomme, int Tconsomme){
		
	}
	
	public void cBudget(int Bestime,int Bconsomme){
		
	}
	
	
}

package control;

import entity.*;

public class ProjectControl {

	/* Indicateurs globaux du projet sur le tps(avancement) et le budget
	 * 	ils mettent en relation l'estimation par rapport � la r�alisation
	 */
	private String nameP;
	
	private int tps;
	private int budget;
	
	//Ces deux tableaux contiennent les donn�es du projet: Temps/Budget 
	private int estimation[] = new int [2];
	private int realisation[] = new int [2];
	
	/*
	 * R�f�rence vers le projet, afin de r�cup�rer les donn�es 
	 * n�cessaires aux calculs des indicateurs
	 */
	Project p ;
	
	public ProjectControl(Project p) {
		super();
		// TODO Auto-generated constructor stub
		this.p = p;
		
		//R�cup�ration du nom du projet
		this.nameP=this.p.getName();
		
		//R�cup�ration des donn�es
		this.estimation[0]=p.getTpsEstime();
		this.estimation[1]=p.getBudgetEstime();
		
		this.realisation[0]=p.getTpsEffectif();
		this.realisation[1]=p.getBudgeteffectif();
		
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
	
	public int getTps() {
		return tps;
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
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	
	public void setTps(int tps) {
		this.tps = tps;
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
	 * M�thodes de la classe
	 */
	
	/* Cette fonction permet de connaitre en pourcentage 
	 * l'avancement du projet en fonction des estimations 
	 * et du temps effectif attribu�e � la r�alisation du projet. 
	 */
	public void cTps(int Testime, int Tconsomme ){
		
		this.tps = (Tconsomme*100)/Testime;
	}
	
	
	/* Cette fonction permet de connaitre en pourcentage
	 * la quantit� du budget qui a �t� d�pens�. 
	 */ 
	public void cBudget(int Bestime,int Bconsomme){
		
		this.budget = (Bconsomme*100)/Bestime;
	}
	
}

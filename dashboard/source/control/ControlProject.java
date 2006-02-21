package control;

import entity.*;

import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class ControlProject {
	
	/*
	 * Ces variables sont des bornes pour les calculs
	 * d'indicateurs afin d'alerter l'utilisateur.
	 * Elles seront utilisées dans la fonction "alerteIndicator"
	 */
	static double Max = 0;
	static double Min1Project = -5;
	static double Min2Project = -10;
	static double Min1Budget = -2;
	static double Min2Budget = -6;
	static double Min1Moy = -2;
	static double Min2Moy = -5;
	/*
	 * Référence vers le projet, afin de récupérer les données 
	 * nécessaires aux calculs des indicateurs
	 */
	private Project p ;
	private String nameP;
 
	private int etapeProgress  ;
 
 
 
		
	//Ces tableaux contiennent les données en terme de charges: estmimée/consommée 
	private double projectTime[] = new double [2];//projectTime[1] renvoie le tps total consommé sur le projet
	private double budget[] = new double [2];
		//On donne ici un vision du projet à partir de différentes moyennes: estmimée/consommée 
	private double etapesTime [] = new double [2];
	private double ressourcesTime [] = new double [2];
	private double activitiesTime [] = new double [2];
	
	
	
	
	public ControlProject(Project p) {
		super();
		// TODO Auto-generated constructor stub
		this.p = p;
 
		etapeProgress=p.getProgress();
 
		//Récupération du nom du projet
		this.nameP=this.p.getName();
		
		//Récupération des données
		this.projectTime[0]=p.getPrevWorkAmount();
		this.budget[0]=p.getPrevBudget();
		
		this.projectTime[1]=p.getRealWorkAmount();
		this.budget[1]=p.getRealBudget();
		
		
	}
	
	
	/*
	 * Getteurs de la classe
	 */
	public String getNameP() {
		return nameP;
	}
	
	public Project getProject() {
		return p;
	}
	
	public double[] getProjectTime() {
		return projectTime;
	}

	public double[] getBudget() {
		return budget;
	}

	public double[] getEtapesTime() {
		return etapesTime;
	}
	
	public double[] getActivities() {
		return this.activitiesTime;
	}
	
	public double[] getRessourcesTime() {
		return this.ressourcesTime;
	}
	
	/*
	 * Setteurs de la classe
	 */
	
	public void setBudget(double[] budget) {
		this.budget = budget;
	}

	public void setActivitiesTime(double[] activities) {
		this.activitiesTime = activities;
	}

	public void setEtapesTime(double[] etapes) {
		this.etapesTime = etapes;
	}

	public void setRessourcesTime(double[] ressources) {
		this.ressourcesTime = ressources;
	}

	public void setProject(double[] project) {
		this.projectTime = project;
	}

	public void setNameP(String nameP) {
		this.nameP = nameP;
	}

	public void setPoject(Project p) {
		this.p = p;
	}

	/*
	 * Méthodes de la classe
	 */
	
	/*
	 * Les 3 procahines fonctions permettent d'obtenir le tps moyen pour chacune des rubriques
	 */
	/*
	public double EtapeIndicator(){
		
<<<<<<< ControlProject.java
	//	return moyE;
=======
		return (this.projectTime[1]/p.getProgress());
>>>>>>> 1.7
	}
	*/
	public double RessourcesIndicator(){
		
		return (this.projectTime[1]/p.getResources().size());
	}
	/*
	public double ActivitiesIndicator(){
		
<<<<<<< ControlProject.java
		//return moyA;
=======
		return(this.projectTime[1]/p.getSubActivities().size());
>>>>>>> 1.7
	}
	*/
	/*
	 * Les 2 fonctions suivantes permettent de calculer des indicateurs sur le projet
	 * à partir des estimations et des consommations
	 */
	
	public double indiceIndicator(double chargeEstimee,double chargeConsommee){
		
		return(chargeConsommee - chargeEstimee);
		
	}
	
	public String alerteIndicator(double diff, double max, double min1, double min2){
		
		String alerte;
		
		if(diff>=max){
			alerte="***";
		}
		else{
			if(diff>(min1)){
				alerte ="+";
			}
			else{
				if(diff>(min2)){
					alerte="++";
				}
				else{
					alerte="+++";
				}
			}
		}
		return alerte;
	}

	/* Cette fonction permet de connaitre en pourcentage 
	 * l'avancement du projet en fonction des estimations 
	 * et du temps consommé attribué à la réalisation du projet. 
	 */
	public double projectIndicator(double Testime, double Tconsomme ){
		
		return((Tconsomme*100)/Testime);
	}
	
	/* Cette fonction permet de connaitre en pourcentage
	 * la quantité du budget qui a été dépensé. 
	 */ 
	public double budgetIndicator(double Bestime,double Bconsomme){
		
		return((Bconsomme*100)/Bestime);
	} 
		
	//Les fonctions suivantes permettent de récupérer des données à partir de calculs
	//ou de recherche dans le package entity
	
	public int getEtapeProgress(){
		return this.etapeProgress;
	}
	
	public int getRessourcesNumber(){
		
		return(p.getResources().size());
	}
	/*
	public Date getNextEtapeStartDate(){
		Date d= new Date();
		return d;
	}
	
	public Date getProjectPrevEndDate(){
		Date d= new Date();
		return d;
	}
	
	public Date getProjectRealEndDate(){
		Date d= new Date();
		return d;
	}
	
	
	
	/**
	 * @author Olivier TANKOANO
	 * constructs a tree representing the internal structure of a Project object	  
	 * @return a TreeModel object representing the internal structure of a Project	  
	**/
	public TreeModel getTreeModel()
    {
    	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project " + p.getName());
		root.setUserObject(p);
		int i;
		ArrayList<Activity> lAcs = p.getSubActivities();
		for(i=0; i<lAcs.size(); i++)
		{
			Activity lAc = lAcs.get(i);
			DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode("Activity " + lAc.getName()) ;
			lAcNode.setUserObject(lAc);
			updateActivityNode(lAcNode, lAc);
			root.add(lAcNode);
		}
		DefaultTreeModel lModel= new DefaultTreeModel(root);
		return lModel;
		

	} 
 
    
    
	/**
	 * @author Olivier TANKOANO
	 * recursive function used to constructs a tree representing the internal 
	 * structure of a Project object. This function is meant to be called by 
	 * the getTreeModel() method to fill each node of the tree model.	  
	**/	
	private void updateActivityNode(DefaultMutableTreeNode pNode, Activity pAc) 
	{
		int i;
		ArrayList<Activity> lAcs = pAc.getSubActivities();
		for (i = 0; i < lAcs.size(); i++) {
			Activity lAc = lAcs.get(i);
			DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode(
					"Activity " + lAc.getName());
			lAcNode.setUserObject(lAc);
			updateActivityNode(lAcNode, lAc);
			pNode.add(lAcNode);
		}

		ArrayList<WorkBreakDownElement> lWBEs = pAc.getWbes();
		for (i = 0; i < lWBEs.size(); i++) {
			WorkBreakDownElement lWBE = lWBEs.get(i);
			DefaultMutableTreeNode lWBENode = new DefaultMutableTreeNode("WBE "
					+ lWBE.getName());
			lWBENode.setUserObject(lWBE);
			pNode.add(lWBENode);
		}

	}
	
		


}

package view;

import control.ProjectControl;

/* Cette classe permet d'obtenir une vision globale sur l'avancement du projet
 *  en ayant actuellement 3 principaux indicateurs:	
 *  	avancement par rapport aux estimations
 *  	rapport entre le budget consomm� et le temps effectif
 *  	etat du budget en fonction des estimations
 */

public class ProjectView {

	// R�cup�rer le nom du projet lors de la s�lection par l'utilisateur
	String name;
	
	ProjectControl pc = new ProjectControl(name);
	/*
	 * pc permet de r�cup�rer les indicateurs calcul�s 
	 * dans la classe control: ProjectControl
	 */
}

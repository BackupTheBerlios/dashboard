package view;

import control.ProjectControl;

/* Cette classe permet d'obtenir une vision globale sur l'avancement du projet
 *  en ayant actuellement 3 principaux indicateurs:	
 *  	avancement par rapport aux estimations
 *  	rapport entre le budget consommé et le temps effectif
 *  	etat du budget en fonction des estimations
 */

public class ProjectView {

	// Récupérer le nom du projet lors de la sélection par l'utilisateur
	String name;
	
	ProjectControl pc = new ProjectControl(name);
	/*
	 * pc permet de récupérer les indicateurs calculés 
	 * dans la classe control: ProjectControl
	 */
}

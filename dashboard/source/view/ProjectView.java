package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;

import control.ProjectControl;

/* Cette classe permet d'obtenir une vision globale sur l'avancement du projet
 *  en ayant actuellement 3 principaux indicateurs:	
 *  	avancement par rapport aux estimations
 *  	rapport entre le budget consommé et le temps effectif
 *  	etat du budget en fonction des estimations
 */

public class ProjectView {

	/*
	 * Référence vers le controlleur du projet, afin de récupérer
	 * les indicateurs
	 */
	ProjectControl pc;

	public ProjectView(ProjectControl pc) {
		super();
		// TODO Auto-generated constructor stub
		this.pc = pc;
	}
	

}

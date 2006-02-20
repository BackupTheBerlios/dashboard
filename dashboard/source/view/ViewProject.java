package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import control.ControlProject;

/* Cette classe permet d'obtenir une vision globale sur l'avancement du projet
 *  en ayant actuellement 3 principaux indicateurs:	
 *  	avancement par rapport aux estimations
 *  	rapport entre le budget consommé et le temps effectif
 *  	etat du budget en fonction des estimations
 */

public class ViewProject extends javax.swing.JPanel{


	/*
	 * Référence vers le controlleur du projet, afin de récupérer
	 * les indicateurs
	 */
	ControlProject cp;

	public ViewProject(ControlProject cp) {
		super();
		// TODO Auto-generated constructor stub
		this.cp = cp;
		fillPanel();
	}
	
	
	private void fillPanel()
	{
		JLabel label = new JLabel("Avancement du projet :" + cp.getNameP());
    	this.setLayout(new BorderLayout());
    	label.setMaximumSize(label.getPreferredSize());
    	this.add(label,BorderLayout.NORTH);
		JProgressBar Jbar=new JProgressBar(1,99);
		Jbar.setForeground(Color.red);
		Jbar.setValue(((int)Double.doubleToLongBits(cp.getTps())));
		Jbar.setMaximumSize(Jbar.getPreferredSize());
		JPanel jPanel3=new JPanel();
		jPanel3.setLayout(new BorderLayout());
		JPanel jPanel4=new JPanel();
		JLabel label2 = new JLabel("Avancement :");
		jPanel4.add(label2);
		jPanel4.add(Jbar);
		jPanel3.add(jPanel4,BorderLayout.NORTH);
		JProgressBar Jbar2=new JProgressBar();
		Jbar2.setMaximumSize(Jbar2.getPreferredSize());
		Jbar2.setForeground(Color.GREEN);
		Jbar2.setValue(((int)Double.doubleToLongBits(cp.getBudget())));
		JPanel jPanel5=new JPanel();
		JLabel label3 = new JLabel("Budget :");
		jPanel5.add(label3);
		jPanel5.add(Jbar2);
		JPanel jPanel6=new JPanel();
		Object[][] donnees = {{"Budget", cp.getEstimation()[1], cp.getRealisation()[1]},
							{"Time", cp.getEstimation()[0], cp.getRealisation()[0]}}; 
		String[] nomsColonnes = {"b", "Prevision", "Realization"};  
		JTable table = new JTable(donnees, nomsColonnes);
		jPanel6.add(table);
		
		jPanel3.add(jPanel5,BorderLayout.WEST);
		this.add(jPanel6,BorderLayout.CENTER);
		this.add(jPanel3,BorderLayout.WEST);
				
	/* Panel avec les 3 boutons */	 
		 JPanel jPanel_bouton=new JPanel();
		 jPanel_bouton.setLayout(new FlowLayout());  
		 JButton Biteration = new JButton("Itération");
		 JButton Bactivite = new JButton("Activité");
		 JButton Bressources = new JButton("Ressources");
		 
		 Biteration.setPreferredSize(Bressources.getPreferredSize());
		 Bactivite.setPreferredSize(Bressources.getPreferredSize());
		 Bressources.setPreferredSize(Bressources.getPreferredSize());
		 
		 jPanel_bouton.add(Biteration);
		 jPanel_bouton.add(Bactivite);
		 jPanel_bouton.add(Bressources);
		 this.add(jPanel_bouton,BorderLayout.SOUTH);
		 jPanel_bouton.setVisible(true);
	/* Fin Panel 3 boutons*/
		
	}
	
}

package view;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

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
		JPanel general=new JPanel();
		general.setLayout(new GridLayout(6,1));
		JLabel label = new JLabel("Avancement du projet : " + cp.getNameP());
		general.add(label);
		
		JPanel Paneltable=new JPanel();
		Object[][] donnees = {{"", "Estimé", "Consommé","Unité","Difference","Indicateur"},{"Temps", cp.getProjectTime()[0], cp.getProjectTime()[1],"H",cp.projectIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]),""},{"Budget", cp.getBudget()[0], cp.getBudget()[1],"€",cp.projectIndicator(cp.getBudget()[0],cp.getBudget()[1]),""},
				{"Moyenne", "", "","","","",""},{"Etapes", "", "","","","",""},{"Ressources", "", "","","","",""},{"Activités", "", "","","","",""}}; 
		String[] nomsColonnes = {"b", "Estimé", "Consommé","Unité","Difference","Indicateur"};  
		JTable table = new JTable(donnees, nomsColonnes);
		table.setEnabled(false);
		Paneltable.add(table);
		general.add(Paneltable);
		
		JPanel Panelbarre=new JPanel();
		Panelbarre.setLayout(new GridLayout(2,1));
		JProgressBar Jbar=new JProgressBar(1,99);
		Jbar.setForeground(Color.red);
		Jbar.setValue(((int)Double.doubleToLongBits(cp.getProjectTime()[0])));
		JLabel temps = new JLabel("Temps : ");
		JPanel barre1=new JPanel();
		JLabel pourcent1 = new JLabel(((int)Double.doubleToLongBits(cp.getProjectTime()[0]))+"%");
		barre1.add(temps);
		barre1.add(Jbar);
		barre1.add(pourcent1);
		
		JProgressBar Jbar2=new JProgressBar(1,99);
		Jbar.setForeground(Color.green);
		Jbar.setValue(((int)Double.doubleToLongBits(cp.getBudget()[0])));
		JLabel budget = new JLabel("Budget : ");
		JPanel barre2=new JPanel();
		JLabel pourcent2 = new JLabel(((int)Double.doubleToLongBits(cp.getBudget()[0]))+"%");
		barre2.add(budget);
		barre2.add(Jbar2);
		barre2.add(pourcent2);
		
		Panelbarre.add(barre1);
		Panelbarre.add(barre2);		
		general.add(Panelbarre);
		
		JLabel projet = new JLabel("Le projet en chiffre : ");
		general.add(projet);
		
		JPanel PanelChiffre=new JPanel();
		PanelChiffre.setLayout(new GridLayout(4,1));
		JLabel ressource = new JLabel("Nombre de ressource : "+cp.getRessourcesNumber());
		JLabel etape = new JLabel("Début de la prochaine étape : "+cp.getNextEtapeStartDate());
		JLabel fin = new JLabel("Date de fin prévue : "+cp.getProjectPrevEndDate());
		JLabel finr = new JLabel("Date de fin ré-estimée : "+cp.getProjectRealEndDate());
		PanelChiffre.add(ressource);
		PanelChiffre.add(etape);
		PanelChiffre.add(fin);
		PanelChiffre.add(finr);
		general.add(PanelChiffre);
		
		
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
		 /* Fin Panel 3 boutons*/
		 
		 general.add(jPanel_bouton);
		
		
    	/*this.setLayout(new BorderLayout());
    	label.setMaximumSize(label.getPreferredSize());
    	this.add(label,BorderLayout.NORTH);
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
		Jbar2.setValue(((int)Double.doubleToLongBits(cp.getBudget()[0])));
		JPanel jPanel5=new JPanel();
		JLabel label3 = new JLabel("Budget :");
		jPanel5.add(label3);
		jPanel5.add(Jbar2);
		JPanel jPanel6=new JPanel();
		
		
		jPanel6.add(table);
		
		jPanel3.add(jPanel5,BorderLayout.WEST);
		this.add(jPanel6,BorderLayout.CENTER);
		this.add(jPanel3,BorderLayout.WEST);
				
		 /* Panel avec les 3 boutons *//*	 
		 JPanel jPanel_bouton=new JPanel();
		 jPanel_bouton.setLayout(new FlowLayout());  
		 JButton Biteration = new JButton("Itération");
		 JButton Bactivite = new JButton("Activité");
		 JButton Bressources = new JButton("Ressources");*/
	/* Fin Panel 3 boutons*/
		 /*
		 Biteration.setPreferredSize(Bressources.getPreferredSize());
		 Bactivite.setPreferredSize(Bressources.getPreferredSize());
		 Bressources.setPreferredSize(Bressources.getPreferredSize());
		 
		 jPanel_bouton.add(Biteration);
		 jPanel_bouton.add(Bactivite);
		 jPanel_bouton.add(Bressources);
		 this.add(general,BorderLayout.SOUTH);
		 jPanel_bouton.setVisible(true);*/
		this.add(general);
		 
		 
	
		
	}
	
}

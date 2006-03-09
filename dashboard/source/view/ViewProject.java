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
		general.setLayout(new BorderLayout());
		JLabel label = new JLabel("Avancement du projet : " + cp.getNameP());
		label.setFont(new Font("Ms-tahoma",Font.BOLD,18));
		general.add(label,BorderLayout.NORTH);
		
		JPanel Paneltable=new JPanel();
		Object[][] donnees = {{"", "Estimé", "Consommé","Unité","Difference","Indicateur"},
				{"Temps", cp.getProjectTime()[0], cp.getProjectTime()[1],"H",cp.indiceIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]),ControlProject.Max,ControlProject.Min1Project,ControlProject.Min2Project)},
				{"Budget", cp.getBudget()[0], cp.getBudget()[1],"€",cp.indiceIndicator(cp.getBudget()[0],cp.getBudget()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getBudget()[0],cp.getBudget()[1]),ControlProject.Max,ControlProject.Min1Budget,ControlProject.Min2Budget)},
				{"Moyenne", "", "","","","",""},
				{"Etapes",cp.getEtapesTime()[0], cp.getEtapesTime()[1],"H",cp.indiceIndicator(cp.getEtapesTime()[0],cp.getEtapesTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getEtapesTime()[0],cp.getEtapesTime()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)},
				{"Ressources", cp.getRessourcesTime()[0], cp.getRessourcesTime()[1],"H",cp.indiceIndicator(cp.getRessourcesTime()[0],cp.getRessourcesTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getRessourcesTime()[0],cp.getRessourcesTime()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)},
				{"Activités", cp.getActivities()[0], cp.getActivities()[1],"H",cp.indiceIndicator(cp.getActivities()[0],cp.getActivities()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getActivities()[0],cp.getActivities()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)}}; 
		String[] nomsColonnes = {"b", "Estimé", "Consommé","Unité","Difference","Indicateur"};  
		JTable table = new JTable(donnees, nomsColonnes);
		table.setEnabled(false);
		Paneltable.add(table);
		
		JPanel PanelMilieu=new JPanel();
		PanelMilieu.setLayout(new GridLayout(2,1,0,0));
		
		JPanel Panelbarre=new JPanel();
		Panelbarre.setLayout(new GridLayout(2,1,0,0));
		JProgressBar Jbar=new JProgressBar(1,99);
		Jbar.setForeground(Color.red);
		Jbar.setValue(((int)(cp.projectIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]))));
		JLabel temps = new JLabel("Temps : ");
		JPanel barre1=new JPanel();
		JLabel pourcent1 = new JLabel(((int)(cp.projectIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1])))+"%");
		barre1.add(temps);
		barre1.add(Jbar);
		barre1.add(pourcent1);
		
		JProgressBar Jbar2=new JProgressBar(1,99);
		Jbar2.setForeground(Color.green);
		Jbar2.setValue(((int)(cp.budgetIndicator(cp.getBudget()[0],cp.getBudget()[1]))));
		JLabel budget = new JLabel("Budget : ");
		JPanel barre2=new JPanel();
		JLabel pourcent2 = new JLabel((int)cp.budgetIndicator(cp.getBudget()[0],cp.getBudget()[1])+"%");
		barre2.add(budget);
		barre2.add(Jbar2);
		barre2.add(pourcent2);
		
		Panelbarre.add(barre1);
		Panelbarre.add(barre2);
		PanelMilieu.add(Paneltable);
		PanelMilieu.add(Panelbarre);
		general.add(PanelMilieu,BorderLayout.CENTER);
		
		JLabel projet = new JLabel("Le projet en chiffre : ");
		projet.setFont(new Font("Ms-tahoma",Font.BOLD,15));
		
		JPanel PanelChiffre=new JPanel();
		PanelChiffre.setLayout(new GridLayout(5,1));
		JLabel ressource = new JLabel("Nombre de ressource : "+cp.getRessourcesNumber());
		JLabel etape = new JLabel("Début de la prochaine étape : "+cp.getNextEtapeStartDate());
		JLabel fin = new JLabel("Date de fin prévue : "+cp.getProjectPrevEndDate());
		JLabel finr = new JLabel("Date de fin ré-estimée : "+cp.getProjectRealEndDate());
		PanelChiffre.add(projet);
		PanelChiffre.add(ressource);
		PanelChiffre.add(etape);
		PanelChiffre.add(fin);
		PanelChiffre.add(finr);
		
		
		 /* Panel avec les 3 boutons */	 
		 JPanel jPanel_bouton=new JPanel();
		 jPanel_bouton.setLayout(new FlowLayout());  
		 JButton Biteration = new JButton("Itération");
		 Biteration.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	SubViewStep fenetre;
	            	fenetre= new SubViewStep(cp);
	            }
	        });
		 JButton Bactivite = new JButton("Activité");
		 Bactivite.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	SubViewActivity fenetre;
	            	fenetre= new SubViewActivity(cp);
	            }
	        });
		 JButton Bressources = new JButton("Ressources");
		 Bressources.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	SubViewRessources fenetre;
	            	fenetre= new SubViewRessources(cp);
	            }
	        });
		 Biteration.setPreferredSize(Bressources.getPreferredSize());
		 Bactivite.setPreferredSize(Bressources.getPreferredSize());
		 Bressources.setPreferredSize(Bressources.getPreferredSize());
		 
		 jPanel_bouton.add(Biteration);
		 jPanel_bouton.add(Bactivite);
		 jPanel_bouton.add(Bressources);
		 /* Fin Panel 3 boutons*/
		 
		 JPanel jPanelbas=new JPanel();
		 jPanelbas.setLayout(new GridLayout(2,1,0,0));
		 jPanelbas.add(PanelChiffre);
		 jPanelbas.add(jPanel_bouton);
		 
		 general.add(jPanelbas,BorderLayout.SOUTH);
		this.add(general);	
		
	}
	
}

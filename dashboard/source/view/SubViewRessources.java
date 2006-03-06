package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import control.ControlProject;
import entity.Project;

public class SubViewRessources  extends JFrame {
	
	private JComboBox combo;
	private ArrayList ressources;
	private JPanel bas=new JPanel();
	

	public SubViewRessources(ControlProject cp){
		super("Ressources pour le projet : "+cp.getNameP());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(500,500) ;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setLayout(new BorderLayout());
		Project p = cp.getProject();
		this.ressources=p.getResources();
		Vector v= new Vector();
		for(int i =0 ;i<ressources.size();i++)
		{
			v.add(ressources.get(i));
		}
		this.combo= new JComboBox(v);
		combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MajCombo();
            }
        });
		JLabel labelCombo=new JLabel("Choississez une ressource : ");
		JPanel haut=new JPanel();
		haut.add(labelCombo);
		haut.add(combo);		
		this.add(haut,BorderLayout.NORTH);
		Object[][] donnees = {{"Activités", "Estimé", "Consommé","Difference","Indicateur"},
				{ cp.getProjectTime()[0], cp.getProjectTime()[1],cp.indiceIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getProjectTime()[0],cp.getProjectTime()[1]),ControlProject.Max,ControlProject.Min1Project,ControlProject.Min2Project)},
				{ cp.getBudget()[0], cp.getBudget()[1],cp.indiceIndicator(cp.getBudget()[0],cp.getBudget()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getBudget()[0],cp.getBudget()[1]),ControlProject.Max,ControlProject.Min1Budget,ControlProject.Min2Budget)},
				{cp.getEtapesTime()[0], cp.getEtapesTime()[1],cp.indiceIndicator(cp.getEtapesTime()[0],cp.getEtapesTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getEtapesTime()[0],cp.getEtapesTime()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)},
				{ cp.getRessourcesTime()[0], cp.getRessourcesTime()[1],cp.indiceIndicator(cp.getRessourcesTime()[0],cp.getRessourcesTime()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getRessourcesTime()[0],cp.getRessourcesTime()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)},
				{ cp.getActivities()[0], cp.getActivities()[1],cp.indiceIndicator(cp.getActivities()[0],cp.getActivities()[1]),cp.alerteIndicator(cp.indiceIndicator(cp.getActivities()[0],cp.getActivities()[1]),ControlProject.Max,ControlProject.Min1Moy,ControlProject.Min2Moy)}};
		String[] nomsColonnes = {"Activités", "Estimé", "Consommé","Unité","Difference","Indicateur"};  
		JTable table = new JTable(donnees, nomsColonnes);
		this.bas.add(table);
		this.add(bas,BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();
		
	}
	private void MajCombo()
	{
		
	}
	
}

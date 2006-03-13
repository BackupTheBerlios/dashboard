package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import utils.Pair;

import control.ControlPlannable;
import control.ControlProject;
import entity.Activity;
import entity.Project;
import entity.Resource;
import entity.WorkBreakDownElement;
import entity.Working;

public class SubViewRessources  extends JFrame {
	
	private JComboBox combo;
	private ArrayList ressources;
	private JPanel bas=new JPanel();
	private ArrayList activites;
	private ArrayList sousActivite;
	private Project p;
	

	public SubViewRessources(ControlProject cp){
		super("Ressources pour le projet : "+cp.getNameP());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(500,500) ;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setLayout(new BorderLayout());
		this.p = cp.getProject();
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
		Object[][] donnees= new Object[((Resource)ressources.get(0)).workinsSize()+2][5];	
		String[] nomsColonnes = {"Activités", "Estimé", "Consommé","Difference","Indicateur"};
		donnees[0][0]="Activités";
		donnees[0][1]= "Estimé";
		donnees[0][2]="Consommé";
		donnees[0][3]="Difference";
		donnees[0][4]="Indicateur";
		float estime=0;
		float conso=0;
		float diff=0;
		this.activites=p.getSubActivities();
		int l=1;
		for(int j=0;j<this.activites.size();j++)
		{
			
			this.sousActivite=((Activity)activites.get(j)).getWbesRecursive();
			for(int m =0 ;m<this.sousActivite.size();m++)
			{			
				ControlPlannable cpa=new ControlPlannable((WorkBreakDownElement)this.sousActivite.get(m));
				ArrayList<Pair<String,Double>> map=cpa.getResourcesUsage();
				String key;
				for(Pair<String, Double> pair: map)
				{
					key=pair.getFirst();
					if(key==((Resource)ressources.get(0)).getName())
					{
						donnees[l][0]=((WorkBreakDownElement)this.sousActivite.get(m)).getName();
						donnees[l][1]=cpa.getPrevDuration();
						donnees[l][2]=cpa.getRealDuration();
						donnees[l][3]=cpa.getPrevDuration()-cpa.getRealDuration();
						
						//Indicateur
						donnees[l][4]="";
						
						estime+=cpa.getPrevDuration();
						conso+=cpa.getRealDuration();
						diff+=cpa.getPrevDuration()-cpa.getRealDuration();
						
						l++;
						System.out.println(l);
					}
				}
				
			}
		}
		donnees[((Resource)ressources.get(0)).workinsSize()+1][0]="Total";
		donnees[((Resource)ressources.get(0)).workinsSize()+1][1]=estime;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][2]=conso;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][3]=diff;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][4]="";
		
		JTable table = new JTable(donnees, nomsColonnes);
		table.getColumnModel().getColumn(0).setPreferredWidth(200); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.bas.add(table);
		this.add(bas,BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
		
	}
	private void MajCombo()
	{
		int i=this.combo.getSelectedIndex();
		this.bas.removeAll();
		Object[][] donnees= new Object[((Resource)ressources.get(i)).workinsSize()+2][5];	
		String[] nomsColonnes = {"Activités", "Estimé", "Consommé","Difference","Indicateur"};
		donnees[0][0]="Activités";
		donnees[0][1]= "Estimé";
		donnees[0][2]="Consommé";
		donnees[0][3]="Difference";
		donnees[0][4]="Indicateur";
		float estime=0;
		float conso=0;
		float diff=0;
		this.activites=p.getSubActivities();
		int l=1;
		for(int j=0;j<this.activites.size();j++)
		{
			
			this.sousActivite=((Activity)activites.get(j)).getWbesRecursive();
			for(int m =0 ;m<this.sousActivite.size();m++)
			{			
				ControlPlannable cpa=new ControlPlannable((WorkBreakDownElement)this.sousActivite.get(m));
				ArrayList<Pair<String,Double>> map=cpa.getResourcesUsage();
				String key;
				for(Pair<String, Double> pair: map)
				{
					key=pair.getFirst();
					if(key==((Resource)ressources.get(i)).getName())
					{
						donnees[l][0]=((WorkBreakDownElement)this.sousActivite.get(m)).getName();
						donnees[l][1]=cpa.getPrevDuration();
						donnees[l][2]=cpa.getRealDuration();
						donnees[l][3]=cpa.getPrevDuration()-cpa.getRealDuration();
						
						//Indicateur
						donnees[l][4]="";
						
						estime+=cpa.getPrevDuration();
						conso+=cpa.getRealDuration();
						diff+=cpa.getPrevDuration()-cpa.getRealDuration();						
						l++;
					}
				}
				
			}
		}
		donnees[((Resource)ressources.get(0)).workinsSize()+1][0]="Total";
		donnees[((Resource)ressources.get(0)).workinsSize()+1][1]=estime;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][2]=conso;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][3]=diff;
		donnees[((Resource)ressources.get(0)).workinsSize()+1][4]="";
		
		JTable table = new JTable(donnees, nomsColonnes);
		table.getColumnModel().getColumn(0).setPreferredWidth(200); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.bas.add(table);
		this.bas.updateUI();
		this.pack();
	}
	
}

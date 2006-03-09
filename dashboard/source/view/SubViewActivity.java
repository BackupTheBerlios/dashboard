package view;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import control.ControlPlannable;
import control.ControlProject;

import entity.Activity;
import entity.Project;
import entity.WBESet;
import entity.WorkBreakDownElement;



public class SubViewActivity extends JFrame{

	private ControlProject cp;
	private JPanel milieu=new JPanel();
	private JPanel bas=new JPanel();
	private JComboBox combo;
	private ArrayList activites;
	private ArrayList sousActivite;
	private Vector v;
	
	
	public SubViewActivity(ControlProject cp)
	{
		super("Activités  pour le projet : "+cp.getNameP());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500,500);
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		JLabel labelCombo=new JLabel("Choississez une activité : ");
		Project p=cp.getProject();
		this.activites=p.getSubActivities();
		this.v= new Vector();
		for(int i =0 ;i<activites.size();i++)
		{
			this.sousActivite=((Activity)activites.get(i)).getWbesRecursive();
			for(int j =0 ;j<this.sousActivite.size();j++)
			{
				v.add(this.sousActivite.get(j));
			}
		}
		this.combo= new JComboBox(v);
		combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MajCombo();
            }
        });
		
		JPanel PanelHaut = new JPanel();
		PanelHaut.add(labelCombo);
		PanelHaut.add(combo);
		this.add(PanelHaut,BorderLayout.NORTH);
		this.milieu.setLayout(new GridLayout(4,1,0,0));
		WorkBreakDownElement W = (WorkBreakDownElement) this.v.get(0);
		ControlPlannable cpa=new ControlPlannable(W);
		HashMap<String,Double> map=cpa.getResourcesUsage();	
		JLabel label=new JLabel("Ressources : "+map.size());
		JLabel label2=new JLabel("Temps estimés : "+cpa.getPrevDuration());
		JLabel label3=new JLabel("Temps consommé : "+cpa.getRealDuration());
		
		//Indicateur
		JLabel label4=new JLabel("Avancement : ");
		
		
		this.milieu.add(label);
		this.milieu.add(label2);
		this.milieu.add(label3);
		this.milieu.add(label4);
		TaskSeriesCollection dataset = new TaskSeriesCollection();
		TaskSeries tsR = new TaskSeries("Realization");
		TaskSeries tsP = new TaskSeries("Prevision");
		try {
			tsP.add(new Task("", new SimpleTimePeriod(cpa
					.getPrevStartDate(), cpa.getPrevEndDate())));
			tsR.add(new Task("", new SimpleTimePeriod(cpa
					.getRealStartDate(), cpa.getRealEndDate())));

		} catch (Exception e) {
			assert true;
		}
		dataset.add(tsP);
		dataset.add(tsR);
		JFreeChart chart = ChartFactory.createGanttChart("", "", "",
				dataset, true, false, false);
		JPanel daysChartPanel=new JPanel();
		daysChartPanel.setLayout(new java.awt.BorderLayout());
		daysChartPanel.add(java.awt.BorderLayout.CENTER,  new ChartPanel(chart));
		this.bas.add(daysChartPanel);
		this.add(milieu,BorderLayout.CENTER);
		this.add(bas,BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
}

private void MajCombo()
{
	
	int i=this.combo.getSelectedIndex();
	this.milieu.removeAll();
	this.bas.removeAll();
	this.milieu.setLayout(new GridLayout(4,1,0,0));
	WorkBreakDownElement W = (WorkBreakDownElement) this.v.get(i);
	ControlPlannable cp=new ControlPlannable(W);
	HashMap<String,Double> map=cp.getResourcesUsage();		
	JLabel label=new JLabel("Nombre de ressources : "+map.size());
	JLabel label2=new JLabel("Temps estimés : "+cp.getPrevDuration());
	JLabel label3=new JLabel("Temps consommé : "+cp.getRealDuration());
	JLabel label4=new JLabel("Avancement : ");
	this.milieu.add(label);
	this.milieu.add(label2);
	this.milieu.add(label3);
	this.milieu.add(label4);
	this.milieu.updateUI();
	TaskSeriesCollection dataset = new TaskSeriesCollection();
	TaskSeries tsR = new TaskSeries("Realization");
	TaskSeries tsP = new TaskSeries("Prevision");
	try {
		tsP.add(new Task("", new SimpleTimePeriod(cp
				.getPrevStartDate(), cp.getPrevEndDate())));
		tsR.add(new Task("", new SimpleTimePeriod(cp
				.getRealStartDate(), cp.getRealEndDate())));

	} catch (Exception e) {
		assert true;
	}
	dataset.add(tsP);
	dataset.add(tsR);
	JFreeChart chart = ChartFactory.createGanttChart("", "", "",
			dataset, true, false, false);
	JPanel daysChartPanel=new JPanel();
	daysChartPanel.setLayout(new java.awt.BorderLayout());
	daysChartPanel.add(java.awt.BorderLayout.CENTER,  new ChartPanel(chart));
	this.bas.add(daysChartPanel);
	this.bas.updateUI();
	this.pack();
}

}

package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import control.ControlPlannable;
import control.ControlProject;

import entity.Activity;
import entity.Project;

public class SubViewStep extends JFrame{
	
	private ControlProject cp;
	private JPanel milieu=new JPanel();
	private JPanel bas=new JPanel();
	private JComboBox combo;
	private ArrayList activites;

	public SubViewStep(ControlProject cp) {
			super("Itérations pour le projet : "+cp.getNameP());
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
			this.setVisible(true);
			this.setLayout(new GridLayout(3,1,0,0));
			JLabel labelCombo=new JLabel("Choississez une itération : ");
			Project p=cp.getProject();
			this.activites=p.getSubActivities();
			Vector v= new Vector();
			for(int i =0 ;i<activites.size();i++)
			{
				v.add(activites.get(i));
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
			this.add(PanelHaut);
			this.setLayout(new GridLayout(4,1,0,0));
			Activity a = (Activity) this.activites.get(0);
			JLabel label=new JLabel(a.getName());
			this.milieu.add(label);
			this.add(milieu);
			this.add(bas);
			this.pack();
	}
	
	private void MajCombo()
	{
		
		int i=this.combo.getSelectedIndex();
		this.milieu.removeAll();
		this.bas.removeAll();
		this.milieu.setLayout(new GridLayout(4,1,0,0));
		Activity a = (Activity) this.activites.get(i);
		ControlPlannable cp=new ControlPlannable(a);
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

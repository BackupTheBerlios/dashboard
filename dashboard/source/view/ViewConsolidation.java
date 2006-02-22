package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.Collection;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import control.ControlConsolidation;
import control.IndicatorState;


public class ViewConsolidation extends javax.swing.JFrame  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControlConsolidation controller;
	
	JTree arbreMenu;
	
	ChartPanel panelGraphic;
	
	public class TreeObjectElement{
		String name;
		int type;
		String id;
		
		public static final int  TYPE_PROJECT = 0;
		public static final int  TYPE_ALLWSETS = 1;
		public static final int  TYPE_ALLRESOURCES = 2;
		public static final int  TYPE_RESOURCE = 3;
		public static final int  TYPE_WBESET = 4;
		
		public TreeObjectElement(String name, int type, String id) {
			this.name = name;
			this.type = type;
			this.id = id;
	    }
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public int getType() {
			return type;
		}
		public String toString() {
			return name;
		}
	}

	public ViewConsolidation(ControlConsolidation controller) throws HeadlessException {
		super();
		this.controller = controller;
		
		DefaultMutableTreeNode noeudPere;
		DefaultMutableTreeNode noeudFils;
		DefaultMutableTreeNode racine;
		
		this.setTitle("consolidation sur le projet" + controller.getProjectName());
		
		//construction du JTree
		TreeObjectElement etiquette = new TreeObjectElement(controller.getProjectName(), TreeObjectElement.TYPE_PROJECT ,controller.getProjectName());
		racine = new DefaultMutableTreeNode(etiquette);
		noeudPere = new DefaultMutableTreeNode(new TreeObjectElement("groupes d'activités", TreeObjectElement.TYPE_ALLWSETS, null));
		
		String[][] wbeSets = this.controller.getWbeSetsIdAndName();
		for( int i = 0; i < wbeSets.length ; i++  ){
			etiquette = new TreeObjectElement(wbeSets[i][1],TreeObjectElement.TYPE_WBESET,wbeSets[i][0]);
			noeudFils = new DefaultMutableTreeNode(etiquette);
			noeudPere.add(noeudFils);
		}
		
		racine.add(noeudPere);
		
		noeudPere = new DefaultMutableTreeNode(new TreeObjectElement("ressources", TreeObjectElement.TYPE_ALLRESOURCES, null));
		String[][] ressources = this.controller.getResourcesIdAndName();
		for( int i = 0; i < ressources.length ; i++  ){
			etiquette = new TreeObjectElement(ressources[i][1], TreeObjectElement.TYPE_RESOURCE , ressources[i][0]);
			noeudFils = new DefaultMutableTreeNode(etiquette);
			noeudPere.add(noeudFils);
		}
		
	   racine.add(noeudPere);

	   this.arbreMenu = new JTree(racine);
	   this.arbreMenu.setModel(new DefaultTreeModel(racine));
	   
	   this.arbreMenu.addTreeSelectionListener(

			   new TreeSelectionListener(){

			              public void valueChanged(TreeSelectionEvent e){

			            	  DefaultMutableTreeNode leNoeud = (DefaultMutableTreeNode)

			                             arbreMenu.getLastSelectedPathComponent();
			            	  
			            	  Object objet = leNoeud.getUserObject();
			                       
			                       
			                    	   
			                    	   
			                 if(objet instanceof TreeObjectElement){
			            	  TreeObjectElement selectElt = (TreeObjectElement) objet; 
			                    	   JFreeChart chart = null;
			                    	   switch(selectElt.type){
			                    	         case TreeObjectElement.TYPE_PROJECT :
			                    	         case TreeObjectElement.TYPE_ALLWSETS :
			                    	        	 chart = createProjectChart();
			                    	        	 break;
			                    	        	 
			                    	         case TreeObjectElement.TYPE_ALLRESOURCES :
			                    	        	 chart = createallResourcesChart();
			                    	        	 break;
			                    	         case TreeObjectElement.TYPE_RESOURCE :
			                    	        	 chart = createResourceChart(selectElt.getId(), selectElt.getName());
			                    	        	 break;
			                    	         case TreeObjectElement.TYPE_WBESET :
			                    	        	 chart = createWbesetChart(selectElt.getId(), selectElt.getName());
			                    	        	 break;
			                    	      
			                    	   }
			                    	   panelGraphic.setChart(chart);
	                    	        	 
			                    	   
			                    	   
			                       }

			                 }

			              });

		//construction du chartPanel
	   this.panelGraphic = new ChartPanel(this.createProjectChart());
	 
	  JScrollPane scrollPane = new JScrollPane(this.arbreMenu);
	 	   this.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane, this.panelGraphic));

	 	   this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	 	   this.setSize(800,600);
	 	   // On récupère la taille de l'écran (la résolution)
	 	   
	 	this.pack();
	 	   
	 	 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	 	  
	 	  // et on place notre fenêtre au milieu
	 	   
	 	  this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
	 	  
	 	  this.setVisible(true);
	}


	
	
	private  DefaultPieDataset createProjectDataset()
    {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		Collection<IndicatorState> dataIndicator = controller.getChargeForAllWbeset();
		for(IndicatorState indic : dataIndicator){
			dataset.setValue(indic.getName(),indic.getValue());
		}
        return dataset;
    }
	
	private  DefaultPieDataset createResourceDataset(String idResource)
    {
		int i = 0;
		DefaultPieDataset dataset = new DefaultPieDataset();
		Collection<IndicatorState> dataIndicator = controller.getChargeByWbeSet(idResource);
		for(IndicatorState indic : dataIndicator){
			 i = 2;
			if(dataset.getIndex(indic.getName()) == -1 ){
				dataset.setValue(indic.getName(),indic.getValue());
			}else{
				while(dataset.getIndex(indic.getName() + i ) != -1 ){
					i++;
				}
				dataset.setValue(indic.getName() + i,indic.getValue());
			}
		}
        return dataset;
    }
	
	private  DefaultPieDataset createWbesetDataset(String idWbeset)
    {
		int i = 0;
		DefaultPieDataset dataset = new DefaultPieDataset();
		Collection<IndicatorState> dataIndicator = controller.getChargeByResources(idWbeset);
		for(IndicatorState indic : dataIndicator){
			 	i = 2;
				if(dataset.getIndex(indic.getName()) == -1 ){
					dataset.setValue(indic.getName(),indic.getValue());
				}else{
					while(dataset.getIndex(indic.getName() + i ) != -1 ){
						i++;
					}
					dataset.setValue(indic.getName() + i,indic.getValue());
				}
		}
        return dataset;
    }
	
	
	private  DefaultIntervalCategoryDataset createAllResourceDataset()
    {
		
		
		String[][] wsetsId = controller.getWbeSetsIdAndName();
		
		int position = 0;
		String[][] resourcesId = controller.getResourcesIdAndName();
		
		Double[][] valueByWbeset = new Double[wsetsId.length][resourcesId.length];
	
		Collection<IndicatorState> dataIndicator = null;
		for(int i=0; i < wsetsId.length ; i++){
			dataIndicator = controller.getChargeByResources(wsetsId[i][0]);
			for(IndicatorState indic : dataIndicator){
				position = 0;
				while(position < resourcesId.length && !(resourcesId[position][0]).equals(indic.getId()) ){
					position++;
				}
				if(position < resourcesId.length){
					valueByWbeset[i][position] = indic.getValue();
				}
				
			}
		}
		
		
		String[] seriesNames = new String[wsetsId.length];
		for(int i=0; i < wsetsId.length ; i++){
			seriesNames[i] = wsetsId[i][1];
		}
		
		String[] categoriesNames = new String[resourcesId.length];
		for(int i=0; i < resourcesId.length ; i++){
			categoriesNames[i] = resourcesId[i][1];
		}
		
		return new DefaultIntervalCategoryDataset(seriesNames, categoriesNames, valueByWbeset, valueByWbeset);
		
		
    }
	
	private  JFreeChart createProjectChart()
    {
			
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Répartion des charges sur le projet : " + controller.getProjectName(), this.createProjectDataset(), true, false, false);
        jfreechart.setBackgroundPaint(Color.WHITE);
        jfreechart.setNotify(false);
        return jfreechart;
    }
	
	private  JFreeChart createResourceChart(String idResource, String nameResource)
    {
			
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Répartition des charges pour la resource : " + nameResource, this.createResourceDataset(idResource), true, false, false);
        jfreechart.setBackgroundPaint(Color.WHITE);
        return jfreechart;
    }
	
	private  JFreeChart createWbesetChart(String idWbeSet, String nameWbeSet)
    {
			
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Répartition des charges pour le groupe d'activité : " + nameWbeSet, this.createWbesetDataset(idWbeSet), true, false, false);
        jfreechart.setBackgroundPaint(Color.WHITE);
        return jfreechart;
    }
	
	private  JFreeChart createallResourcesChart()
    {
			
		JFreeChart chart = ChartFactory.createBarChart3D("Charges de travail par ressources",
                "ressources",
                "charge",
                this.createAllResourceDataset(),
                PlotOrientation.HORIZONTAL,
                true, // show legend
                true,
                true
               );
		chart.setBackgroundPaint(Color.WHITE);
        return chart;
    }    
	 
}

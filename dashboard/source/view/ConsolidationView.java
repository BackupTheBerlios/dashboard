package view;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JMenuBar;
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

import control.ConsolidationHandler;
import control.IndicatorState;
import entity.Activity;
import entity.Resource;
import entity.WBESet;
import entity.WorkBreakDownElement;
import entity.Working;


public class ConsolidationView extends javax.swing.JFrame  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConsolidationHandler controller;
	
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
			return name.toString();
		}
	}

	public ConsolidationView(ConsolidationHandler controller) throws HeadlessException {
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
		System.out.println(""+ wbeSets.length);
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
	 	   
	 	   this.pack();
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
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		Collection<IndicatorState> dataIndicator = controller.getChargeByWbeSet(idResource);
		for(IndicatorState indic : dataIndicator){
			dataset.setValue(indic.getName(),indic.getValue());
		}
        return dataset;
    }
	
	private  DefaultPieDataset createWbesetDataset(String idWbeset)
    {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		Collection<IndicatorState> dataIndicator = controller.getChargeByResources(idWbeset);
		for(IndicatorState indic : dataIndicator){
			dataset.setValue(indic.getName(),indic.getValue());
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
			
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Répartition des charge pour le groupe d'activité : " + nameWbeSet, this.createWbesetDataset(idWbeSet), true, false, false);
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
    
    
	 public static void main(String[] args) throws Exception
	  {
		 //Project projet = new Project("2DB");
			HashMap<String,Activity>  activities= new HashMap<String,Activity> ();
			HashMap<String,WorkBreakDownElement>  workBreakDownElements = new HashMap<String,WorkBreakDownElement> ();
			HashMap<String,Resource>  resources = new HashMap<String,Resource> ();
			HashMap<String,Working>  workings = new HashMap<String, Working> ();
			ArrayList<WBESet> collection = new ArrayList<WBESet>();
			Activity activity;
			WorkBreakDownElement wbe;
			Resource resource;
			Working working;
			WBESet wbeset;
			
			activity = new Activity("1","Itération 1");
			activities.put(activity.getId(),activity);
			activity = new Activity("2","Iteration 2");
			activities.put(activity.getId(),activity);
			activity = new Activity("3","Iteration 4");
			activities.put(activity.getId(),activity);
			
			wbeset = new WBESet("1", "codage");
			
			wbe = new WorkBreakDownElement("1","Réaliser le cas 14");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("2","Réaliser le cas 15");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("3","Préparer l'intégration des L3");
			workBreakDownElements.put(wbe.getId(),wbe);	
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("4","Préparer la revue");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			collection.add(wbeset);
			
			wbeset = new WBESet("2", "realisation");
			
			
			wbe = new WorkBreakDownElement("5","Réaliser l'architecture");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("6","Déterminer la stratégie de test");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("7","Choisir les outils");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("8","Plannifier la prochaine itération");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			wbe = new WorkBreakDownElement("9","Cloturer l'itération");
			workBreakDownElements.put(wbe.getId(),wbe);
			
			wbeset.add(wbe);
			
			collection.add(wbeset);
			System.out.println("collection"+ collection.size());
			
			 resource = new Resource("1", "Tankoano Olivier");
			 resources.put(resource.getId(),resource);
			 resource = new Resource("2", "Allogo Etienne");
			 resources.put(resource.getId(),resource);
			 resource = new Resource("3", "Heidy Baubant");
			 resources.put(resource.getId(),resource);
			 resource = new Resource("4", "Guenatri Kamil");
			 resources.put(resource.getId(),resource);
			 
			 working = new Working("1","spécifier précisément le cas 14",21.9);
			 workings.put(working.getId(),working);
			 working = new Working("2","coder le cas 14",43.8);
			 workings.put(working.getId(),working);
			 working = new Working("3","coder le cas 14",72.8);
			 workings.put(working.getId(),working);
			 working = new Working("4","spécifier précisément le cas 15",235.9);
			 workings.put(working.getId(),working);
			 working = new Working("5","coder le cas 15",30.8);
			 workings.put(working.getId(),working);
			 working = new Working("6","coder le cas 15",90.8);
			 workings.put(working.getId(),working);
			 working = new Working("7","intégrer le cas 15 à l'ihm",100.9);
			 workings.put(working.getId(),working);
			 working = new Working("8","rédiger le document de formation",213.8);
			 workings.put(working.getId(),working);
			 working = new Working("9","controler le document de formation",1.8);
			 workings.put(working.getId(),working);
			 working = new Working("10","vérifier la cohérence des documents",122.9);
			 workings.put(working.getId(),working);
			 working = new Working("11","rédiger le power point",3.8);
			 workings.put(working.getId(),working);
			 working = new Working("12","se documenter sur java",2.8);
			 workings.put(working.getId(),working);
			 working = new Working("13","se documenter sur les outils de test",223.9);
			 workings.put(working.getId(),working);
			 working = new Working("14","rédiger la stratégie de test",24.8);
			 workings.put(working.getId(),working);
			 working = new Working("15","choisir un outil de test",200.8);
			 workings.put(working.getId(),working);
			 working = new Working("16","choisir l'environnement java",21.9);
			 workings.put(working.getId(),working);
			 working = new Working("17","choisir les prochain cas à implémenter",3.8);
			 workings.put(working.getId(),working);
			 working = new Working("18","estimer la charge pour chaque cas",2.8);
			 workings.put(working.getId(),working);
			 working = new Working("19","régrouper les documents pour livraison",21.9);
			 workings.put(working.getId(),working);
			 working = new Working("20","réaliser le site avec pog",42.8);
			 workings.put(working.getId(),working);
			 working = new Working("21","réaliser le diagramme d'architecture",546.8);
			 workings.put(working.getId(),working);
			 
			 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("1"));
			 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("2"));
			 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("3"));
			 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("4"));
			 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("5"));
			 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("6"));
			 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("7"));
			 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("8"));
			 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("9"));
			 
			 workBreakDownElements.get("1").addWorking(workings.get("1"));
			 workBreakDownElements.get("1").addWorking(workings.get("2"));
			 workBreakDownElements.get("1").addWorking(workings.get("3"));
			 workBreakDownElements.get("2").addWorking(workings.get("4"));
			 workBreakDownElements.get("2").addWorking(workings.get("5"));
			 workBreakDownElements.get("2").addWorking(workings.get("6"));
			 workBreakDownElements.get("2").addWorking(workings.get("7"));
			 workBreakDownElements.get("3").addWorking(workings.get("8"));
			 workBreakDownElements.get("3").addWorking(workings.get("9"));
			 workBreakDownElements.get("4").addWorking(workings.get("10"));
			 workBreakDownElements.get("4").addWorking(workings.get("11"));
			 workBreakDownElements.get("5").addWorking(workings.get("12"));
			 workBreakDownElements.get("5").addWorking(workings.get("21"));
			 workBreakDownElements.get("6").addWorking(workings.get("14"));
			 workBreakDownElements.get("6").addWorking(workings.get("15"));
			 workBreakDownElements.get("7").addWorking(workings.get("16"));
			 workBreakDownElements.get("7").addWorking(workings.get("17"));
			 workBreakDownElements.get("8").addWorking(workings.get("18"));
			 workBreakDownElements.get("8").addWorking(workings.get("19"));
			 workBreakDownElements.get("9").addWorking(workings.get("20"));
			 workBreakDownElements.get("9").addWorking(workings.get("13"));


			 resources.get("1").addWorking(workings.get("1"));
			 resources.get("1").addWorking(workings.get("2"));
			 resources.get("3").addWorking(workings.get("3"));
			 resources.get("1").addWorking(workings.get("4"));
			 resources.get("4").addWorking(workings.get("5"));
			 resources.get("1").addWorking(workings.get("6"));
			 resources.get("1").addWorking(workings.get("7"));
			 resources.get("2").addWorking(workings.get("8"));
			 resources.get("2").addWorking(workings.get("9"));
			 resources.get("2").addWorking(workings.get("10"));
			 resources.get("3").addWorking(workings.get("11"));
			 resources.get("3").addWorking(workings.get("12"));
			 resources.get("4").addWorking(workings.get("13"));
			 resources.get("4").addWorking(workings.get("14"));
			 resources.get("4").addWorking(workings.get("15"));
			 resources.get("4").addWorking(workings.get("16"));
			 resources.get("3").addWorking(workings.get("17"));
			 resources.get("3").addWorking(workings.get("18"));
			 resources.get("4").addWorking(workings.get("19"));
			 resources.get("2").addWorking(workings.get("20"));
			 resources.get("4").addWorking(workings.get("21"));

		 ConsolidationHandler controler = new ConsolidationHandler(collection ,"2DB");
	     @SuppressWarnings("unused") ConsolidationView view = new ConsolidationView(controler);
	  }
}

package view;

import javax.swing.* ;

import java.awt.* ;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.renderer.category.*;

import control.objVariation;



/*
 * Classe créant un histogramme montrant un indicateur de variation d'un projet à partir de données fournies en entrée
 * auteur : Yoann Lopes
 */
public class ViewProjectVariation extends JFrame
{

	public	ViewProjectVariation(Vector<objVariation> vectObjVar,String params)
	{
		super("Project Variation");
		Container container = this.getRootPane() ;
		container.setLayout(new BorderLayout());
		
		//Panel contenant les boutons de paramétrage du graphique
		JPanel haut = new JPanel() ;
		haut.setLayout(new GridLayout(1,2)) ;
		
	    Vector<String> data = new Vector<String>();
	    data.add("Group");
	    int i=0;
	    while(!vectObjVar.get(i).getRessource().equals("group"))
	    {
	    	data.add(vectObjVar.get(i).getRessource());
	    	i++;
	    }
	    JComboBox comboRessource = new JComboBox(data);
	    JPanel panneauListe = new JPanel() ;
	    panneauListe.setLayout(new GridLayout(2,1)) ;
	    panneauListe.add(comboRessource) ;
	    haut.add(panneauListe) ;
	    //comboRessource.
	    
	    JRadioButton rbtIteration= new JRadioButton("Par itérations");
	    JRadioButton rbtSemaine= new JRadioButton("Par semaines");
	    ButtonGroup group = new ButtonGroup() ;
	    rbtIteration.setSelected(true) ;
	    group.add(rbtIteration) ;
	    group.add(rbtSemaine) ;
	    JPanel panneauRadio = new JPanel() ;
	    panneauRadio.setLayout(new GridLayout(2,1)) ;
	    panneauRadio.add(rbtIteration) ;
	    panneauRadio.add(rbtSemaine) ;
	    haut.add(panneauRadio) ;
	    
	    container.add(haut,BorderLayout.SOUTH) ;
		
		
		// Partie concernant la création du graphique
		DefaultCategoryDataset dataset = this.extractDataSet(vectObjVar,params) ;
		JFreeChart chart = ChartFactory.createBarChart("Project Variation","Itérations","Heures",dataset,PlotOrientation.VERTICAL,true,false,false);
		
		CategoryPlot plo = chart.getCategoryPlot() ;
		NumberAxis timeAxis = new NumberAxis("Heures"); 
		NumberTickUnit ntu = new NumberTickUnit(1);
		timeAxis.setTickUnit(ntu);
		plo.setRangeAxis(timeAxis);
		
		CategoryAxis ca = plo.getDomainAxis() ;
		ca.setTickLabelFont(new Font("sansSerif",Font.PLAIN,14)) ;
		plo.setDomainAxis(ca) ;		
		
		BarRenderer br = (BarRenderer)plo.getRenderer() ;
		br.setItemMargin(0) ;		
		plo.setRenderer(br) ;
		
		chart = new JFreeChart("Project Variation", plo) ;
		
		ChartPanel p = new ChartPanel(chart) ;
		
		container.add(p,BorderLayout.CENTER) ;
		
	
		this.setSize(600,600) ;
		this.setVisible(true);
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                }});
	}
	

	public DefaultCategoryDataset extractDataSet(Vector<objVariation> vect,String params)
	{
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		int vectorLength = vect.size() ;
		objVariation ov ;
		for (int i=0 ; i<vectorLength ; i++)
		{
			ov = vect.get(i) ;
			if(ov.getRessource().equals(params))
			{	
				dcd.addValue(ov.getTempsEstime(),"Estimé",ov.getIteration()) ;
				dcd.addValue(ov.getTempsReel(),"Réel",ov.getIteration()) ;
			}
		}
		return dcd ;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Vector<objVariation> vect = new Vector<objVariation>() ;
		
		objVariation obj11 = new objVariation("it1",4,6,"Yoann",2);
		vect.add(obj11) ;
		
		objVariation obj12 = new objVariation("it1",4,5,"kamil",2);
		vect.add(obj12) ;
		
		objVariation objSum1 = new objVariation("it1",8,11,"group",2);
		vect.add(objSum1) ;
		
		objVariation obj21 = new objVariation("it2",15,7,"Yoann",3) ;
		vect.add(obj21) ;
		
		objVariation obj22 = new objVariation("it2",17,7,"kamil",3) ;
		vect.add(obj22) ;
		
		objVariation objSum2 = new objVariation("it2",32,14,"group",2);
		vect.add(objSum2) ;
		
		objVariation obj31 = new objVariation("it3",12,20,"Yoann",5) ;
		vect.add(obj31) ;
		
		objVariation obj32 = new objVariation("it3",14,20,"kamil",5) ;
		vect.add(obj32);
		
		objVariation objSum3 = new objVariation("it3",26,40,"group",2);
		vect.add(objSum3) ;
		
		ViewProjectVariation test = new ViewProjectVariation(vect,"group") ;
	}

}

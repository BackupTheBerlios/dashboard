package view;

import javax.swing.* ;
import java.awt.* ;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.renderer.category.*;

import entity.objVariation;

public class ViewProjectVariation extends JFrame
{

	public	ViewProjectVariation(Vector<objVariation> vectObjVar)
	{
		super("Project Variation");
		Container container = this.getRootPane() ;
		container.setLayout(new BorderLayout());
		
		DefaultCategoryDataset dataset = this.extractDataSet(vectObjVar) ;
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
		
		container.add(p) ;
		
		this.setSize(600,600) ;
		this.setVisible(true);
		
		this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                }});
	}
	

	public DefaultCategoryDataset extractDataSet(Vector<objVariation> vect)
	{
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		int vectorLength = vect.size() ;
		objVariation ov ;
		for (int i=0 ; i<vectorLength ; i++)
		{
			ov = vect.get(i) ;
			dcd.addValue(ov.getTempsEstime(),"Estimé",ov.getIteration()) ;
			dcd.addValue(ov.getTempsReel(),"Réel",ov.getIteration()) ;
		}
		return dcd ;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Vector<objVariation> vect = new Vector<objVariation>() ;
		
		objVariation obj1 = new objVariation("it1",4.4,6,"Yoann",2) ;
		vect.add(obj1) ;
		
		objVariation obj2 = new objVariation("it2",15,7,"Yoann",3) ;
		vect.add(obj2) ;
		
		objVariation obj3 = new objVariation("it3",12,20,"Yoann",5) ;
		vect.add(obj3) ;
		
		ViewProjectVariation test = new ViewProjectVariation(vect) ;
	}

}

package view;

import javax.swing.* ;

import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Vector<objVariation> v; 
	private String params;
	public	ViewProjectVariation(final String param)
	{
		super("Project Variation ");
		
		params=param;
		Vector<objVariation> vect = new Vector<objVariation>() ;
		
		objVariation obj11 = new objVariation("level1",16,17,"Tankoano Olivier","tt",2);
		vect.add(obj11) ;
		
		objVariation obj12 = new objVariation("level1",16,15,"Allogo Etienne","aa",2);
		vect.add(obj12) ;
		
		objVariation obj13 = new objVariation("level1",20,22,"Heidy Baubant","bb",2);
		vect.add(obj13) ;
		
		objVariation obj14 = new objVariation("level1",16,15,"Guenatri Kamil","kk",2);
		vect.add(obj14) ;
		
		objVariation objSum1 = new objVariation("level1",68,69,"group","gr",2);
		vect.add(objSum1) ;
		
		objVariation obj21 = new objVariation("level2",24,20,"Tankoano Olivier","tt",2);
		vect.add(obj21) ;
		
		objVariation obj22 = new objVariation("level2",24,21,"Allogo Etienne","aa",2);
		vect.add(obj22) ;
		
		objVariation obj23 = new objVariation("level2",30,26,"Heidy Baubant","bb",2);
		vect.add(obj23) ;
		
		objVariation obj24 = new objVariation("level2",24,22,"Guenatri Kamil","kk",2);
		vect.add(obj24) ;
		
		objVariation objSum2 = new objVariation("level2",102,89,"group","gr",2);
		vect.add(objSum2) ; 
		
		objVariation obj31 = new objVariation("level3",24,33,"Tankoano Olivier","tt",2);
		vect.add(obj31) ;
		
		objVariation obj32 = new objVariation("level3",24,30,"Allogo Etienne","aa",2);
		vect.add(obj32) ;
		
		objVariation obj33 = new objVariation("level3",30,31,"Heidy Baubant","bb",2);
		vect.add(obj33) ;
		
		objVariation obj34 = new objVariation("level3",24,32,"Guenatri Kamil","kk",2);
		vect.add(obj34) ;
		
		objVariation objSum3 = new objVariation("level3",102,126,"group","gr",2);
		vect.add(objSum3) ;
		
		v=vect;
		
		//JDesktopPane jdp = new JDesktopPane();
		//Container container = new Container(;)
		Container container = this.getContentPane() ;
		container.setLayout(new BorderLayout());
		
		//Panel contenant les boutons de paramétrage du graphique
		JPanel haut = new JPanel() ;
		haut.setLayout(new GridLayout(1,2)) ;
		
	    Vector<String> data = new Vector<String>();
	    data.add("group");
	    int i=0;
	    while(!vect.get(i).getRessource().equals("group"))
	    {
	    	data.add(vect.get(i).getRessource());
	    	i++;
	    }
	    
	    final JComboBox comboRessource = new JComboBox(data);
	    comboRessource.setSelectedItem(params);
	    
	    JPanel panneauListe = new JPanel() ;
	    panneauListe.setLayout(new GridLayout(2,1)) ;
	    panneauListe.add(comboRessource) ;
	    haut.add(panneauListe) ;
	    comboRessource.addActionListener(new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent ev)
                            {
                                 refresh (  comboRessource.getSelectedItem().toString()) ;
                                 comboRessource.setSelectedItem(params);
                                 
                            }
                        });
	    
	    JRadioButton rbtIteration= new JRadioButton("By level");
	    JRadioButton rbtSemaine= new JRadioButton("By week");
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
		DefaultCategoryDataset dataset = this.extractDataSet(vect,params) ;
		JFreeChart chart = ChartFactory.createBarChart("Project Variation"  ,"Levels","Hours",dataset,PlotOrientation.VERTICAL,true,false,false);
		
		CategoryPlot plo = chart.getCategoryPlot() ;
		NumberAxis timeAxis = new NumberAxis("Heures"); 
		NumberTickUnit ntu = new NumberTickUnit(10);
		timeAxis.setTickUnit(ntu);
		plo.setRangeAxis(timeAxis);
		
		CategoryAxis ca = plo.getDomainAxis() ;
		ca.setTickLabelFont(new Font("sansSerif",Font.PLAIN,14)) ;
		plo.setDomainAxis(ca) ;		
		
		BarRenderer br = (BarRenderer)plo.getRenderer() ;
		br.setItemMargin(0) ;		
		plo.setRenderer(br) ;
		
		chart = new JFreeChart("Project Variation for " + params , plo) ;
		
		ChartPanel p = new ChartPanel(chart) ;
		
		container.add(p,BorderLayout.CENTER) ;
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400) ;
		
		this.setVisible(true);

	}
	
	public void refresh(String p)
	{
	 
    	ViewProjectVariation test = new ViewProjectVariation(p) ;
    	 
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
		
	}

}

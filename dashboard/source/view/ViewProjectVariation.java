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
 * Classe cr�ant un histogramme montrant un indicateur de variation d'un projet � partir de donn�es fournies en entr�e
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
		v=vect;
		
		//JDesktopPane jdp = new JDesktopPane();
		//Container container = new Container(;)
		Container container = this.getContentPane() ;
		container.setLayout(new BorderLayout());
		
		//Panel contenant les boutons de param�trage du graphique
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
	    
	    JRadioButton rbtIteration= new JRadioButton("Par it�rations");
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
		
		
		// Partie concernant la cr�ation du graphique
		DefaultCategoryDataset dataset = this.extractDataSet(vect,params) ;
		JFreeChart chart = ChartFactory.createBarChart("Project Variation"  ,"It�rations","Heures",dataset,PlotOrientation.VERTICAL,true,false,false);
		
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
		
		chart = new JFreeChart("Project Variation for " + params , plo) ;
		
		ChartPanel p = new ChartPanel(chart) ;
		
		container.add(p,BorderLayout.CENTER) ;
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400) ;
		
		this.setVisible(true);
		/*
		this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                }});
                */
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
				dcd.addValue(ov.getTempsEstime(),"Estim�",ov.getIteration()) ;
				dcd.addValue(ov.getTempsReel(),"R�el",ov.getIteration()) ;
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

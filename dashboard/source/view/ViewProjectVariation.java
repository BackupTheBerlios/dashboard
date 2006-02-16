package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import test.TestEntity;

import control.C_ObjVariation;
import control.ControlEnvironment;
import control.ControlProject;
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
	private Vector<objVariation> vect; 
	private String params;
	private C_ObjVariation var;
	private static ControlProject cp;
	
	public	ViewProjectVariation(final String param,ControlProject nameP)
	{
		super("Project Variation for "+nameP.getP().getName());
		
		
		params=param;
		cp=nameP; 
		
		/* 	
		objVariation obj11 = new objVariation("It1",16,17,"Tankoano Olivier","tt",2);
		vect.add(obj11) ;
		
		objVariation obj12 = new objVariation("It1",16,15,"Allogo Etienne","aa",2);
		vect.add(obj12) ;
		
		objVariation obj13 = new objVariation("It1",20,22,"Heidy Baubant","bb",2);
		vect.add(obj13) ;
		
		objVariation obj14 = new objVariation("It1",16,15,"Guenatri Kamil","kk",2);
		vect.add(obj14) ;
		
		objVariation objSum1 = new objVariation("It1",68,69,"group","gr",2);
		vect.add(objSum1) ;
		
		objVariation obj21 = new objVariation("It2",24,20,"Tankoano Olivier","tt",2);
		vect.add(obj21) ;
		
		objVariation obj22 = new objVariation("It2",24,21,"Allogo Etienne","aa",2);
		vect.add(obj22) ;
		
		objVariation obj23 = new objVariation("It2",30,26,"Heidy Baubant","bb",2);
		vect.add(obj23) ;
		
		objVariation obj24 = new objVariation("It2",24,22,"Guenatri Kamil","kk",2);
		vect.add(obj24) ;
		
		objVariation objSum2 = new objVariation("It2",102,89,"group","gr",2);
		vect.add(objSum2) ; 
		*/
		
		
		var = new C_ObjVariation(cp.getP());
		vect=var.getDataVariation();
		
		//JDesktopPane jdp = new JDesktopPane();
		//Container container = new Container(;)
		Container container = this.getContentPane() ;
		container.setLayout(new BorderLayout());
		
		//Panel contenant les boutons de paramétrage du graphique
		JPanel haut = new JPanel() ;
		haut.setLayout(new GridLayout(1,2)) ;
		
	    Vector<String> data = new Vector<String>();
	    data.add("group");
	    //data.add("Tankoano Olivier");
	   
	    int i=0;
	    for(i=0;i<var.getAllRessources().size();i++)
	    {
	    	data.add(var.getAllRessources().get(i).getName());
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
	    
	    JRadioButton rbtIteration= new JRadioButton("By iteration");
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
		JFreeChart chart = ChartFactory.createBarChart("Project Variation"  ,"Iterations","Hours",dataset,PlotOrientation.VERTICAL,true,false,false);
		
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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);

	}
	
	public void refresh(String p)
	{
	 
    	ViewProjectVariation t = new ViewProjectVariation(p,cp) ;
    	 
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
 
	 public static void main(String args[]) {
	    
		 ControlEnvironment envC= new ControlEnvironment(TestEntity.createEnvironment()); 
		 ViewProjectVariation t = new ViewProjectVariation("group",envC.getControlProjects().get(0)) ;
	    }
}

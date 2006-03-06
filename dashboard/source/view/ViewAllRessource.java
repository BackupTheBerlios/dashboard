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
import org.jfree.data.general.DefaultPieDataset;


import control.*;
import examples.TestEntity;



/*
 * Classe créant un histogramme montrant un indicateur de variation d'un projet à partir de données fournies en entrée
 * auteur : Yoann Lopes
 */
public class ViewAllRessource extends JFrame
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Vector<objVariation> vect; 
	
	private ControlObjVariation var;
	private static ControlProject cp;
	private ChartPanel p;
	private ChartPanel p1;
	private Container container; 
	
	public	ViewAllRessource(ControlProject nameP)
	{
		super("Mesure sur les ressources pour "+nameP.getProject().getName());
		
		
		
		cp=nameP; 
		
		var = new ControlObjVariation(cp.getProject());
		vect=var.getRessourcesVariation();
	
		
		//JDesktopPane jdp = new JDesktopPane();
		//Container container = new Container(;)
		container = this.getContentPane() ;
		container.setLayout(new BorderLayout());
		
		//Panel contenant les boutons de paramétrage du graphique
		JPanel haut = new JPanel() ;
		haut.setLayout(new GridLayout(1,2)) ;
		
	  
	    
	    JRadioButton rbtTempsReel= new JRadioButton("Charge réel");
	    JRadioButton rbtNbtaches= new JRadioButton("Nombre de taches");
	    
	    //masque  chart 
	    rbtNbtaches.addActionListener(new ActionListener ()
                {
	    			public void actionPerformed (ActionEvent ev)
	    			{
	    				p.setVisible(false);
	    				container.add(p1,BorderLayout.CENTER) ;
	    				p1.setVisible(true);
	    			}
                });
	    
	    // masque pie chart
	    rbtTempsReel.addActionListener(new ActionListener ()
                {
	    			public void actionPerformed (ActionEvent ev)
	    			{
	    				p.setVisible(true);
	    				container.add(p,BorderLayout.CENTER) ;
	    				p1.setVisible(false);
	    			}
                });
	    
	    ButtonGroup group = new ButtonGroup() ;
	    rbtTempsReel.setSelected(true) ;
	    group.add(rbtTempsReel) ;
	    group.add(rbtNbtaches) ;
	    JPanel panneauRadio = new JPanel() ;
	    panneauRadio.setLayout(new GridLayout(2,1)) ;
	    panneauRadio.add(rbtTempsReel) ;
	    panneauRadio.add(rbtNbtaches) ;
	    haut.add(panneauRadio) ;
	    
	    container.add(haut,BorderLayout.SOUTH) ;
		
	    DefaultPieDataset pieData = this.extractPieDataSet(vect,"tempsReel") ;
		JFreeChart chart = ChartFactory.createPieChart3D("Charges réel pour chaque ressource" ,pieData,true,false,false);
		p = new ChartPanel(chart) ;
		container.add(p,BorderLayout.CENTER) ;

		// pie chart 
		DefaultPieDataset pieData1 = this.extractPieDataSet(vect,"nbTaches") ;
		JFreeChart chart1 = ChartFactory.createPieChart3D("Nombre de taches pour chaque ressource"  ,pieData1,true,false,false);
		p1 = new ChartPanel(chart1) ;
		
		
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400) ;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);

	}
	
 
	 
	public DefaultPieDataset extractPieDataSet(Vector<objVariation> vect,String param)
	{
		DefaultPieDataset dpd = new DefaultPieDataset();
		int vectorLength = vect.size();
		objVariation ov;
		
		
		for(int i=0;i<vectorLength;i++)
		{
			ov = vect.get(i);
			// System.out.println(ov.getIdRessource() + "-" +ov.getRessource()+"-"+ov.getIteration()+"-" + ov.getTempsReel() );
			//System.out.println(ov.getIdRessource()"-"+param);
			if(param.equals("nbTaches"))
			{
				dpd.setValue(ov.getRessource(),ov.getNbTaches());
			}
			
			if(param.equals("tempsReel"))
			{
				dpd.setValue(ov.getRessource(),ov.getTempsReel());
			}
		}
		return dpd;
	}
	/**
	 * @param args
	 */
 
	 public static void main(String args[]) {
	 
		// ControlEnvironment envC= new ControlEnvironment(TestEntity.createEnvironment()); 
		 // ViewProjectVariation t = new ViewProjectVariation("group",envC.getControlProjects().get(1)) ;
	 
	    }
}

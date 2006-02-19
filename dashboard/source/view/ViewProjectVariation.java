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


import control.C_ObjVariation;
import control.ControlEnvironment;
import control.ControlProject;
import control.objVariation;
import examples.TestEntity;



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
	private ChartPanel p;
	private ChartPanel p1;
	private Container container; 
	
	public	ViewProjectVariation(final String param,ControlProject nameP)
	{
		super("Project Variation for "+nameP.getP().getName());
		
		
		params=param;
		cp=nameP; 
		
		var = new C_ObjVariation(cp.getP());
		vect=var.getDataVariation();
		
		//JDesktopPane jdp = new JDesktopPane();
		//Container container = new Container(;)
		container = this.getContentPane() ;
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
	    JRadioButton rbtAllProject= new JRadioButton("For all project");
	    
	    //masque bar chart
	    rbtAllProject.addActionListener(new ActionListener ()
                {
	    			public void actionPerformed (ActionEvent ev)
	    			{
	    				p.setVisible(false);
	    				comboRessource.setVisible(false);
	    				container.add(p1,BorderLayout.CENTER) ;
	    				p1.setVisible(true);
	    			}
                });
	    
	    // masque pie chart
	    rbtIteration.addActionListener(new ActionListener ()
                {
	    			public void actionPerformed (ActionEvent ev)
	    			{
	    				p.setVisible(true);
	    				comboRessource.setVisible(true);
	    				container.add(p,BorderLayout.CENTER) ;
	    				p1.setVisible(false);
	    			}
                });
	    
	    ButtonGroup group = new ButtonGroup() ;
	    rbtIteration.setSelected(true) ;
	    group.add(rbtIteration) ;
	    group.add(rbtAllProject) ;
	    JPanel panneauRadio = new JPanel() ;
	    panneauRadio.setLayout(new GridLayout(2,1)) ;
	    panneauRadio.add(rbtIteration) ;
	    panneauRadio.add(rbtAllProject) ;
	    haut.add(panneauRadio) ;
	    
	    container.add(haut,BorderLayout.SOUTH) ;
		
		
		// Partie concernant la création du graphique du bar chart 
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
		p = new ChartPanel(chart) ;
		container.add(p,BorderLayout.CENTER) ;

		// pie chart 
		DefaultPieDataset pieData = this.extractPieDataSet(vect,params) ;
		JFreeChart chart1 = ChartFactory.createPieChart3D("Project Variation for " +params ,pieData,true,false,false);
		p1 = new ChartPanel(chart1) ;
		
		
		
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
	public DefaultCategoryDataset extractDataSet(Vector<objVariation> vect,String param)
	{
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		int vectorLength = vect.size() ;
		objVariation ov ;
		for (int i=0 ; i<vectorLength ; i++)
		{
			ov = vect.get(i) ;
			if(ov.getRessource().equals(param))
			{	
				dcd.addValue(ov.getTempsEstime(),"Estimé",ov.getIteration()) ;
				dcd.addValue(ov.getTempsReel(),"Réel",ov.getIteration()) ;
			}
		}
		return dcd ;
	}
	
	public DefaultPieDataset extractPieDataSet(Vector<objVariation> vect,String param)
	{
		DefaultPieDataset dpd = new DefaultPieDataset();
		int vectorLength = vect.size();
		objVariation ov;
		double reel=0.0;
		double estime=0.0;
		
		for(int i=0;i<vectorLength;i++)
		{
			ov = vect.get(i);
			//System.out.println(ov.getIdRessource() + "-" +ov.getRessource()+"-"+ov.getIteration()+"-" + ov.getTempsEstime() );
			//System.out.println(ov.getIdRessource()"-"+param);
			if(ov.getRessource().equals(param))
			{
				reel+=ov.getTempsReel();
				estime+=ov.getTempsEstime();
			}
		}
		
		
		dpd.setValue("Estimé",estime);
		dpd.setValue("Réel",reel);
		
		return dpd;
	}
	/**
	 * @param args
	 */
 
	 public static void main(String args[]) {
	    
		 ControlEnvironment envC= new ControlEnvironment(TestEntity.createEnvironment()); 
		 ViewProjectVariation t = new ViewProjectVariation("group",envC.getControlProjects().get(0)) ;
	    }
}

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;

import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.general.DefaultPieDataset;

public class ViewResourceUsage extends JFrame
{
private ChartPanel p;
private Container container; 
	public ViewResourceUsage(HashMap<String,Double> map)
	{
		/* 'map' contient les couples nom-charge_de_travail à afficher*/
		
			super("Utilisation des ressources");
			
			container = this.getContentPane() ;
			container.setLayout(new BorderLayout());
			
			// pie chart 
			DefaultPieDataset pieData = this.extractPieDataSet(map) ;
			JFreeChart chart = ChartFactory.createPieChart("Utilisation des ressources" ,pieData,true,false,false);
			p = new ChartPanel(chart) ;
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(400,400) ;
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
			this.setVisible(true);
			p.setVisible(true); 
			container.add(p,BorderLayout.CENTER) ;
			
			
		}
		
		/*public void refresh(String p)
		{
		 
	    	ViewProjectVariation t = new ViewProjectVariation(p,cp) ;
	    	 
		}*/
		public DefaultPieDataset extractPieDataSet(HashMap<String,Double> map)
		{
			DefaultPieDataset dpd = new DefaultPieDataset();
			
			Set listKey=map.keySet();
			Iterator i = listKey.iterator();
			String key = new String();
			while (i.hasNext())
			{	key=(String)i.next();
				System.out.println(key + " - " + map.get(key));
				
				dpd.setValue(key,map.get(key));
			}
			return dpd;
		}
		
		
		public static void main(String args[]) 
		{
			HashMap<String,Double> map = new HashMap<String,Double>();
			map.put("eric", 12.5);
			map.put("jo", 18.7);
			map.put("lysie", 5.0);
			map.put("aline", 50.0);
			ViewResourceUsage v = new ViewResourceUsage(map);
			v.setVisible(true);
		}
			
		
	}

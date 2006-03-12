package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;

import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.general.DefaultPieDataset;

import utils.Pair;

public class ViewResourceUsage extends JFrame
{
	
private ChartPanel p;
private Container container;

	public ViewResourceUsage(String title, ArrayList<Pair<String, Double>> map)
	{
		/* 'map' contient les couples nom-charge_de_travail à afficher*/
		
			super("Charges par ressource");
			
			container = this.getContentPane() ;
			container.setLayout(new BorderLayout());
			
			// pie chart 
			DefaultPieDataset pieData = this.extractPieDataSet(map) ;
			JFreeChart chart = ChartFactory.createPieChart(title ,pieData,true,false,false);
			p = new ChartPanel(chart) ;
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(400,400) ;
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
			container.add(p,BorderLayout.CENTER) ;			
		}
		
		
	
		public DefaultPieDataset extractPieDataSet(ArrayList<Pair<String, Double>> map)
		{
			DefaultPieDataset dpd = new DefaultPieDataset();
			
			for(Pair<String, Double> pair: map)
			{				
				String key = pair.getFirst();
				Double value = pair.getSecond();
				dpd.setValue(key,value);
			}
			return dpd;
		}
		
		
		
		public static void main(String args[]) 
		{
			ArrayList<Pair<String, Double>> map = new ArrayList<Pair<String, Double>>();
			map.add(new Pair<String, Double>("eric", 12.5));
			map.add(new Pair<String, Double>("jo", 18.7));
			map.add(new Pair<String, Double>("lysie", 5.0));
			map.add(new Pair<String, Double>("aline", 50.0));
			ViewResourceUsage v = new ViewResourceUsage("activité i", map);
			v.setVisible(true);
		}
			
		
	}

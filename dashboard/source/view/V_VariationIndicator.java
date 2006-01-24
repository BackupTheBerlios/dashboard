package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class V_VariationIndicator extends JFrame
{
  /**
	 * 
	 */
  private static final long serialVersionUID = -8087441051938732626L;
  public static final int PIE_CHART = 0;
  public static final int XY_CHART = 1;
  public static final int CATEGORY_CHART = 2;

  
  
  public static void main(String[] args) throws IOException  
  {  
  V_VariationIndicator exemple= new V_VariationIndicator(); 
  }
  
  
  public V_VariationIndicator() throws IOException  
  {
    JFreeChart chart = createChart(2);

    // write chart as JPEG file
    ChartUtilities.saveChartAsJPEG(new File("chart.jpg"), chart, 500,300);

    BufferedImage image = chart.createBufferedImage(500,300);

    JLabel lblChart = new JLabel();
    lblChart.setHorizontalAlignment(JLabel.CENTER);
    lblChart.setVerticalAlignment(JLabel.CENTER);
    lblChart.setIcon(new ImageIcon(image));
    
    String[] data = {"one", "two", "three", "four"};
    JComboBox dataList = new JComboBox(data);
    
    JRadioButton rbt1= new JRadioButton("week");
 
    /*
    dataList.addActionListener(new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent ev)
                            {
                            	
                            	
                                
                            }
                        }); */
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(lblChart, BorderLayout.CENTER);
    this.getContentPane().add(dataList, BorderLayout.SOUTH);
    this.getContentPane().add(rbt1,BorderLayout.WEST);
    this.setSize(600,400);
    this.setVisible(true);

    this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                }});
  }

  private JFreeChart createChart(int k)  
  {
  
    	  /*
        String[] seriesNames = new String[] {"2001", "2002"};
        String[] categoryNames = new String[] {"First Quater",
                                               "Second Quater"};
        Number[][] categoryData = new Integer[][] {{new Integer(20),
                                                    new Integer(35)},
                                                   {new Integer(40),
                                                    new Integer(60)}
                                                  };
        */
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        //DatasetGroup set = new DatasetGroup();
        
        categoryDataset.addValue(12.3*k,"estimé","it1"); 
        categoryDataset.addValue(13.0*k,"réel","1t1");
        
        categoryDataset.addValue(16.3*k,"estimé","it2"); 
        categoryDataset.addValue(10.0*k,"réel","1t2");
        // Comparable 
        //categoryDataset.getV//seriesNames,
                //categoryNames,
                //categoryData);

        return ChartFactory.createBarChart3D("Sample Category Chart",
                                                     "Quarters",
                                                     "Sales",
                                                     categoryDataset,
                                                     PlotOrientation.VERTICAL,
                                                     true, // show legend
                                                     false,
                                                     false
                                                    );
      
       
    }
}



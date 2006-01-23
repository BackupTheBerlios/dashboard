package test;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

public class ChartExample extends JFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -8087441051938732626L;
public static final int PIE_CHART = 0;
  public static final int XY_CHART = 1;
  public static final int CATEGORY_CHART = 2;

  public static void main(String[] args) throws Exception
  {
    ChartExample chartExample = new ChartExample(CATEGORY_CHART );
  }

  public ChartExample(int chartType) throws Exception
  {
    JFreeChart chart = createChart(chartType);

    // write chart as JPEG file
    ChartUtilities.saveChartAsJPEG(new File("chart.jpg"), chart, 500,300);

    BufferedImage image = chart.createBufferedImage(500,300);

    JLabel lblChart = new JLabel();
    lblChart.setHorizontalAlignment(JLabel.CENTER);
    lblChart.setVerticalAlignment(JLabel.CENTER);
    lblChart.setIcon(new ImageIcon(image));

    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(lblChart, BorderLayout.CENTER);
    this.setSize(600,400);
    this.setVisible(true);

    this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                        System.exit(0);
                }});
  }

  private JFreeChart createChart(int chartType) throws Exception
  {
    switch (chartType)
    {
      case 0:
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("JavaWorld", new Integer(75));
        pieDataset.setValue("Other", new Integer(25));

        return ChartFactory.createPieChart("Sample Pie Chart",
                                            pieDataset,
                                            true ,// show legend
                                            false,
                                            false
                                          );
      case 1:
        XYSeries series = new XYSeries("Average Size");
        series.add(20.0, 10.0);
        series.add(40.0, 20.0);
        series.add(70.0, 50.0);
        XYDataset xyDataset = new XYSeriesCollection(series);

        return ChartFactory.createXYAreaChart("Sample XY Chart",
                                              "Height",
                                              "Weight",
                                              xyDataset,
                                              PlotOrientation.VERTICAL,
                                              true, // show legend
                                              false,
                                              false
                                              
                                             );
      case 2:
        String[] seriesNames = new String[] {"2001", "2002"};
        String[] categoryNames = new String[] {"First Quater",
                                               "Second Quater"};
        Number[][] categoryData = new Integer[][] {{new Integer(20),
                                                    new Integer(35)},
                                                   {new Integer(40),
                                                    new Integer(60)}
                                                  };
        CategoryDataset categoryDataset = new DefaultCategoryDataset();
        DatasetGroup set = new DatasetGroup();
     
        
        
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
      
      default:
        throw new Exception("Please try 0, 1");
    }
  }
}


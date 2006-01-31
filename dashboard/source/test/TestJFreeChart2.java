package test;
import javax.swing.* ;
import java.util.*;
import java.text.*;

import org.jfree.chart.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TestJFreeChart2  extends javax.swing.JFrame {
    
    
    
    
    public TestJFreeChart2() {
        super("2DB") ;
        initGUI() ;
    }
    
    
    public void doExit() {
        dispose() ;
    }
    
    
    private void initGUI() {
        setSize(550, 400) ;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    /**
     *
     * @param args
     */    
    public static void main(String[] args) {
       
        XYSeries series = new XYSeries("Linux Users");
        series.add(1995, 0.5);
        series.add(2000, 3.0);
        series.add(2010, 20.0);
        series.add(2020, 50.0);
        XYDataset dataset = new XYSeriesCollection(series);
         
        JFreeChart chart = ChartFactory.createXYAreaChart(
        "Linux Users",
        "Year",
        "Millions",
        dataset,
        org.jfree.chart.plot.PlotOrientation.VERTICAL,
        true,
        false,
        false);
                
        TestJFreeChart2 inst = new TestJFreeChart2();
        ChartPanel p = new ChartPanel(chart);
        inst.getContentPane().add(p);
        inst.setVisible(true) ;
        
    }
}
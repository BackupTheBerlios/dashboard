package test;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.beans.PropertyVetoException ;
import java.util.*;
import java.text.*;

import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.xy.*;
import org.jfree.data.gantt.*;
import org.jfree.data.category.*;
import org.jfree.data.time.*;

public class KamilChart  extends javax.swing.JFrame {
    
    
    private static Date makeDate(String sDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(sDate);
    }
    
    
    public KamilChart() {
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
        XYSeries series = new     XYSeries  ("Linux Users");
        series.add(1995, 200);
        series.add(1995, 300);
        series.add(2010, 6520);
        series.add(2020, 1230);
        IntervalXYDataset dataset = new XYSeriesCollection(series);
    	
        JFreeChart chart = ChartFactory.createTimeSeriesChart( 
    	"Linux Users",
    	"Year",
    	"Millions",
    	dataset,
    
        true,
        true,
        false);
    	/*
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
          */      
        KamilChart inst = new KamilChart();
        ChartPanel p = new ChartPanel(chart);
        inst.getContentPane().add(p);
        inst.setVisible(true) ;
        
    }
}
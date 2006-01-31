package test;

import javax.swing.*;
import java.util.*;
import java.text.*;

import org.jfree.chart.*;
import org.jfree.data.gantt.*;
import org.jfree.data.time.*;

public class TestJFreeChart extends javax.swing.JFrame {

	private static Date makeDate(String sDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(sDate);
	}

	public TestJFreeChart() {
		super("2DB");
		initGUI();
	}

	public void doExit() {
		dispose();
	}

	private void initGUI() {
		setSize(550, 400);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		TaskSeriesCollection dataset = new TaskSeriesCollection();
		TaskSeries ts = new TaskSeries("Durée de phase");
		try {
			ts.add(new Task("Lancement", new SimpleTimePeriod(
					makeDate("30/09/2005"), makeDate("24/10/2005"))));
			ts.add(new Task("Elaboration", new SimpleTimePeriod(
					makeDate("24/10/2005"), makeDate("20/12/2005"))));
			ts.add(new Task("Glander", new SimpleTimePeriod(
					makeDate("20/12/2005"), makeDate("05/01/2006"))));
			ts.add(new Task("Construction", new SimpleTimePeriod(
					makeDate("05/01/2006"), makeDate("30/01/2006"))));
		} catch (Exception e) {
			System.out.println("Erreur date!");
		}
		dataset.add(ts);

		JFreeChart chart = ChartFactory.createGanttChart("Gantt des phases",
				"Phases", "Dates", dataset, true, false, false);

		TestJFreeChart inst = new TestJFreeChart();
		ChartPanel p = new ChartPanel(chart);
		inst.getContentPane().add(p);
		inst.setVisible(true);

	}
}
package examples;

import utils.Functions;
import entity.*;
import control.*;

/*
 * 
 */

/**
 * @author étienne ALLOGO
 * 
 */
public class TestEntity 
{

	/**
	 * @param args
	 */
	public static Environment createEnvironment() {
		Environment env = new Environment();
		env.getProjects().add(create2DBTestProject());
		env.getProjects().add(createPSITestProject());
		return env;
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static Project create2DBTestProject() {
		// project creation
		Project project = new Project("2DB", "Decisionnal dashbord",400000.0,3500000.0);

		WBESet wsDocs = new WBESet("wsDocs", "documents");
		WBESet wsGes = new WBESet("wsGes", "gestion de projet");
		project.getWbeSets().add(wsDocs);
		project.getWbeSets().add(wsGes);
		
		project.getWbeSets().add(wsDocs);
		project.getWbeSets().add(wsGes);

		try {

			// iterations creation
			Activity it1 = new Activity("1", "Itération 1");
			project.getSubActivities().add(it1);
			
			
			Activity it2 = new Activity("2", "Itération 2");
			project.getSubActivities().add(it2);
			
			
			// wbes creation
			WorkBreakDownElement wbe1 = new WorkBreakDownElement("wbe1",
					"Mettre en place le projet", Functions
							.stringToDate("20-09-2005"), Functions
							.stringToDate("05-10-2005"), new Double(15), Functions
							.stringToDate("25-09-2005"), Functions
							.stringToDate("12-10-2005"), null);
			it1.getWbes().add(wbe1);
			wsGes.getWorkBreakDowElements().add(wbe1);
			
			WorkBreakDownElement wbe2 = new WorkBreakDownElement("wbe2",
					"Recueillir les exigences", Functions
							.stringToDate("05-10-2005"), Functions
							.stringToDate("20-10-2005"), new Double(4), Functions
							.stringToDate("12-10-2005"), Functions
							.stringToDate("29-10-2005"), null

			);
			it1.getWbes().add(wbe2);
			wsGes.getWorkBreakDowElements().add(wbe2);			
			
			WorkBreakDownElement wbe3 = new WorkBreakDownElement("wbe3",
					"Rédiger les documents", Functions.stringToDate("20-10-2005"),
					Functions.stringToDate("28-10-2005"), new Double(27), Functions
							.stringToDate("29-10-2005"), Functions
							.stringToDate("05-11-2005"), null

			);
			it1.getWbes().add(wbe3);
			wsDocs.getWorkBreakDowElements().add(wbe3);
			
			WorkBreakDownElement wbe4 = new WorkBreakDownElement("wbe4",
					"Coder un prototype", Functions.stringToDate("28-10-2005"),
					Functions.stringToDate("20-11-2005"), new Double(50), Functions
							.stringToDate("05-11-2005"), Functions
							.stringToDate("25-11-2005"), null

			);
			it2.getWbes().add(wbe4);
			
			WorkBreakDownElement wbe5 = new WorkBreakDownElement("wbe5",
					"Mettre à jour les documents", Functions
							.stringToDate("20-11-2005"), Functions
							.stringToDate("30-11-2005"), new Double(5), Functions
							.stringToDate("25-11-2005"), Functions
							.stringToDate("12-12-2005"), null

			);
			it2.getWbes().add(wbe5);
			wsDocs.getWorkBreakDowElements().add(wbe5);
			
			
			// resources creation
			Resource r1 = new Resource("r1", "Tankoano Olivier");
			project.getResources().add(r1);
			Resource r2 = new Resource("r2", "Allogo Etienne");
			project.getResources().add(r2);
			Resource r3 = new Resource("r3", "Heidy Baubant");
			project.getResources().add(r3);
			Resource r4 = new Resource("r4", "Guenatri Kamil");
			project.getResources().add(r4);

			// workings creation
			Working w11 = new Working("w11", "", 20.0, r1);
			wbe1.getWorkings().add(w11);
			Working w12 = new Working("w12", "", 30.0, r2);
			wbe1.getWorkings().add(w12);
			Working w13 = new Working("w13", "", 5.0, r3);
			wbe1.getWorkings().add(w13);

			Working w21 = new Working("w21", "", 12.0, r4);
			wbe2.getWorkings().add(w21);
			Working w22 = new Working("w22", "", 42.0, r4);
			wbe2.getWorkings().add(w22);

			Working w31 = new Working("w31", "", 5.0, r1);
			wbe3.getWorkings().add(w31);

			Working w41 = new Working("w41", "", 55.0, r2);
			wbe4.getWorkings().add(w41);

			Working w51 = new Working("w51", "", 180.0, r3);
			wbe5.getWorkings().add(w51);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return project;
	}

	
	
	public static Project createPSITestProject() 
	{
		// project creation
		Project project = new Project("PSI", "projet PSI", 300000.0,500000.0);
		WBESet wsDocs = new WBESet("wsDocs", "documents");
		WBESet wsGes = new WBESet("wsGes", "gestion de projet");
		project.getWbeSets().add(wsDocs);
		project.getWbeSets().add(wsGes);
		try {

			// iterations creation
			Activity it1 = new Activity("11", "Itération 1");
			project.getSubActivities().add(it1);
			Activity it2 = new Activity("12", "Itération 2");
			project.getSubActivities().add(it2);

			// wbes creation
			WorkBreakDownElement wbe1 = new WorkBreakDownElement("wbe1",
					"Mettre en place le projet", Functions
							.stringToDate("25-09-2005"), Functions
							.stringToDate("01-10-2005"), new Double(41), Functions
							.stringToDate("26-09-2005"), Functions
							.stringToDate("10-10-2005"), null);
			it1.getWbes().add(wbe1);
		
			wsGes.getWorkBreakDowElements().add(wbe1);
			
			WorkBreakDownElement wbe2 = new WorkBreakDownElement("wbe2",
					"Recueillir les exigences", Functions
							.stringToDate("01-10-2005"), Functions
							.stringToDate("27-10-2005"), new Double(10), Functions
							.stringToDate("10-10-2005"), Functions
							.stringToDate("29-10-2005"), null

			);
			it1.getWbes().add(wbe2);
			wsGes.getWorkBreakDowElements().add(wbe2);			
			
			WorkBreakDownElement wbe3 = new WorkBreakDownElement("wbe3",
					"Rédiger les documents", Functions.stringToDate("27-10-2005"),
					Functions.stringToDate("20-11-2005"), new Double(17), Functions
							.stringToDate("29-10-2005"), Functions
							.stringToDate("25-11-2005"), null

			);
			it1.getWbes().add(wbe3);
			wsDocs.getWorkBreakDowElements().add(wbe3);
			
			WorkBreakDownElement wbe4 = new WorkBreakDownElement("wbe4",
					"Coder un prototype", Functions.stringToDate("20-11-2005"),
					Functions.stringToDate("29-11-2005"), new Double(1), Functions
							.stringToDate("25-11-2005"), Functions
							.stringToDate("29-11-2005"),null

			);
			it2.getWbes().add(wbe4);
			
			WorkBreakDownElement wbe5 = new WorkBreakDownElement("wbe5",
					"Mettre à jour les documents", Functions
							.stringToDate("29-11-2005"), Functions
							.stringToDate("30-11-2005"), new Double(15), Functions
							.stringToDate("29-11-2005"), Functions
							.stringToDate("03-12-2005"), null

			);
			it2.getWbes().add(wbe5);
			wsDocs.getWorkBreakDowElements().add(wbe5);
			
			// resources creation
			Resource r1 = new Resource("r1", "Avetisian Gohar");
			project.getResources().add(r1);
			Resource r2 = new Resource("r2", "Condé Mike");
			project.getResources().add(r2);
			Resource r3 = new Resource("r3", "Canay Kurvin");
			project.getResources().add(r3);
			Resource r4 = new Resource("r4", "Badaoui Kasem");
			project.getResources().add(r4);

			// workings creation
			Working w11 = new Working("w11", "", 30.0, r1);
			wbe1.getWorkings().add(w11);
			Working w12 = new Working("w12", "", 40.0, r2);
			wbe1.getWorkings().add(w12);
			Working w13 = new Working("w13", "", 15.0, r3);
			wbe1.getWorkings().add(w13);

			Working w21 = new Working("w21", "", 22.0, r4);
			wbe2.getWorkings().add(w21);
			Working w22 = new Working("w22", "", 52.0, r4);
			wbe2.getWorkings().add(w22);

			Working w31 = new Working("w31", "", 15.0, r1);
			wbe3.getWorkings().add(w31);

			Working w41 = new Working("w41", "", 65.0, r2);
			wbe4.getWorkings().add(w41);

			Working w51 = new Working("w51", "", 210.0, r3);
			wbe5.getWorkings().add(w51);

		} catch (Exception e) {
			assert true;
		}

		return project;
	}

}

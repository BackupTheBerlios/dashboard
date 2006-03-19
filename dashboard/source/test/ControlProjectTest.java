package test;

import java.util.Date;

import control.ControlProject;
import entity.Activity;
import entity.Project;
import entity.WorkBreakDownElement;

import junit.framework.TestCase;

public class ControlProjectTest extends TestCase {

	/*
	 * Test method for 'control.ControlProject.ControlProject(Project)'
	 */
	public void testControlProject() {
		
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getProject()==p);		
	}

	/*
	 * Test method for 'control.ControlProject.getNameP()'
	 */
	public void testGetNameP() {
		Project p= new Project();
		p.setName("Projet de test");
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getNameP()=="Projet de test");	
	}

	/*
	 * Test method for 'control.ControlProject.getProject()'
	 */
	public void testGetProject() {
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getProject()==p);	
	}

	/*
	 * Test method for 'control.ControlProject.getProjectTime()'
	 */
	public void testGetProjectTime() {
		
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getProjectTime()[0]==p.getPrevWorkAmount());	
		assertTrue(cp.getProjectTime()[1]==p.getRealWorkAmount());			
	}

	/*
	 * Test method for 'control.ControlProject.getBudget()'
	 */
	public void testGetBudget() {
		
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getBudget()[0]==p.getPrevBudget());	
		assertTrue(cp.getBudget()[1]==p.getRealBudget());		
	}

	/*
	 * Test method for 'control.ControlProject.getEtapesTime()'
	 */
	public void testGetEtapesTime() {
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getEtapesTime()[0]==p.getPrevWorkAmount());	
		assertTrue(cp.getEtapesTime()[1]==p.getRealWorkAmount());			
	}

	/*
	 * Test method for 'control.ControlProject.getActivities()'
	 */
	public void testGetActivities() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList<Activity>();
		Activity A1=new Activity("1","A1");
		Activity A2=new Activity("2","A2");
		Activity A3=new Activity("3","A3");
		test.add(A1);
		test.add(A2);
		test.add(A3);
		Project p= new Project();
		p.setSubActivities(test);
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getActivities()[0]==p.getPrevWorkAmount()/p.getSubActivities().size());
		assertTrue(cp.getActivities()[1]==p.getRealWorkAmount()/p.getSubActivities().size());	
	}

	/*
	 * Test method for 'control.ControlProject.getRessourcesTime()'
	 */
	public void testGetRessourcesTime() {
		
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setRessourcesTime(test);
		assertTrue(cp.getRessourcesTime()==test);	
	}

	/*
	 * Test method for 'control.ControlProject.setBudget(double[])'
	 */
	public void testSetBudget() {
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setBudget(test);
		assertTrue(cp.getBudget()==test);	
	}

	/*
	 * Test method for 'control.ControlProject.setActivitiesTime(double[])'
	 */
	public void testSetActivitiesTime() {
		
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setActivitiesTime(test);
		assertTrue(cp.getActivities()==test);	
	}

	/*
	 * Test method for 'control.ControlProject.setEtapesTime(double[])'
	 */
	public void testSetEtapesTime() {
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setEtapesTime(test);
		assertTrue(cp.getEtapesTime()==test);	
	}

	/*
	 * Test method for 'control.ControlProject.setRessourcesTime(double[])'
	 */
	public void testSetRessourcesTime() {
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setActivitiesTime(test);
		assertTrue(cp.getRessourcesTime()==test);
	}

	/*
	 * Test method for 'control.ControlProject.setProject(double[])'
	 */
	public void testSetProject() {
		double[]test=new double[2];
		test[1]=3;
		test[1]=4;
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setProject(test);
		assertTrue(cp.getProjectTime()==test);		
	}

	/*
	 * Test method for 'control.ControlProject.setNameP(String)'
	 */
	public void testSetNameP() {
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		cp.setNameP("Projet de test");
		assertTrue(cp.getNameP()=="Projet de test");
	}

	/*
	 * Test method for 'control.ControlProject.setPoject(Project)'
	 */
	public void testSetPoject() {

		Project p= new Project();
		p.setName("Projet de test");
		ControlProject cp=new ControlProject(p);
		cp.setPoject(p);
		assertTrue(cp.getProject()==p);
	}

	/*
	 * Test method for 'control.ControlProject.EtapeIndicator()'
	 */
	public void testEtapeIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.RessourcesIndicator()'
	 */
	public void testRessourcesIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.ActivitiesIndicator()'
	 */
	public void testActivitiesIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.indiceIndicator(double, double)'
	 */
	public void testIndiceIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.alerteIndicator(double, double, double, double)'
	 */
	public void testAlerteIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.projectIndicator(double, double)'
	 */
	public void testProjectIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.budgetIndicator(double, double)'
	 */
	public void testBudgetIndicator() {

	}

	/*
	 * Test method for 'control.ControlProject.getEtapeProgress()'
	 */
	public void testGetEtapeProgress() {

	}

	/*
	 * Test method for 'control.ControlProject.getRessourcesNumber()'
	 */
	public void testGetRessourcesNumber() {
		Project p= new Project();
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getRessourcesNumber()==p.getResources().size());
	}

	/*
	 * Test method for 'control.ControlProject.getNextEtapeStartDate()'
	 */
	public void testGetNextEtapeStartDate() {

	}

	/*
	 * Test method for 'control.ControlProject.getProjectPrevEndDate()'
	 */
	public void testGetProjectPrevEndDate() {
		
		Project p= new Project();
		Activity A=new Activity("0","A2");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList<WorkBreakDownElement>();
		work.add(w);
		work.add(w2);
		A.setWbes(work);
		java.util.ArrayList<Activity> activite=new java.util.ArrayList<Activity>();
		activite.add(A);
		p.setSubActivities(activite);
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getProjectPrevEndDate()==p.getPrevEndDate());

	}

	/*
	 * Test method for 'control.ControlProject.getProjectRealEndDate()'
	 */
	public void testGetProjectRealEndDate() {
		Project p= new Project();
		Activity A=new Activity("0","A2");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList<WorkBreakDownElement>();
		work.add(w);
		work.add(w2);
		A.setWbes(work);
		java.util.ArrayList<Activity> activite=new java.util.ArrayList<Activity>();
		activite.add(A);
		p.setSubActivities(activite);
		ControlProject cp=new ControlProject(p);
		assertTrue(cp.getProjectRealEndDate()==p.getRealEndDate());
		
	}

}
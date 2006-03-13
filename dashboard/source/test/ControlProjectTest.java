package test;

import control.ControlProject;
import entity.Project;

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
		assertTrue(cp.getBudget()[0]==p.getPrevBudget());	
		assertTrue(cp.getBudget()[1]==p.getRealBudget());			
	}

	/*
	 * Test method for 'control.ControlProject.getActivities()'
	 */
	public void testGetActivities() {

	}

	/*
	 * Test method for 'control.ControlProject.getRessourcesTime()'
	 */
	public void testGetRessourcesTime() {

	}

	/*
	 * Test method for 'control.ControlProject.setBudget(double[])'
	 */
	public void testSetBudget() {

	}

	/*
	 * Test method for 'control.ControlProject.setActivitiesTime(double[])'
	 */
	public void testSetActivitiesTime() {

	}

	/*
	 * Test method for 'control.ControlProject.setEtapesTime(double[])'
	 */
	public void testSetEtapesTime() {

	}

	/*
	 * Test method for 'control.ControlProject.setRessourcesTime(double[])'
	 */
	public void testSetRessourcesTime() {

	}

	/*
	 * Test method for 'control.ControlProject.setProject(double[])'
	 */
	public void testSetProject() {

	}

	/*
	 * Test method for 'control.ControlProject.setNameP(String)'
	 */
	public void testSetNameP() {

	}

	/*
	 * Test method for 'control.ControlProject.setPoject(Project)'
	 */
	public void testSetPoject() {

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

	}

	/*
	 * Test method for 'control.ControlProject.getProjectRealEndDate()'
	 */
	public void testGetProjectRealEndDate() {

	}

	/*
	 * Test method for 'control.ControlProject.getTreeModel()'
	 */
	public void testGetTreeModel() {

	}

}

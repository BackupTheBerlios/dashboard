package test;

import java.util.ArrayList;
import java.util.Date;

import control.ControlObjVariation;

import entity.Activity;
import entity.Project;
import entity.Resource;
import entity.WBESet;
import entity.WorkBreakDownElement;
import entity.Working;
import junit.framework.TestCase;

public class ControlObjVariationTest extends TestCase {

	/*
	 * Test method for 'control.ControlObjVariation.getDataVariation()'
	 */
	public void testGetDataVariation() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();
		Resource r=new Resource("1","ress1");
		Resource r2=new Resource("2","ress2");
		resources.add(r);
		resources.add(r2);
		p.setResources(resources);
		java.util.ArrayList<Activity> test=new java.util.ArrayList<Activity>();
		Activity A1=new Activity("1","it1");
		Activity A2=new Activity("2","it2");
		WorkBreakDownElement w = new WorkBreakDownElement ("1","testName1",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		WorkBreakDownElement w3 = new WorkBreakDownElement ("3","testName3",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),12.11);	
		Working working1 = new Working("1","blablabla",10.5,r);
		Working working5 = new Working("5","blablablasrth",10.0,r);
		java.util.ArrayList<Working> wk1 = new java.util.ArrayList<Working>() ;
		wk1.add(working1) ;
		w.setWorkings(wk1) ;
		Working working2 = new Working("2","tacos",15.8,r2);
		java.util.ArrayList<Working> wk2 = new java.util.ArrayList<Working>() ;
		wk2.add(working2);
		wk2.add(working5);
		w2.setWorkings(wk2) ;
		Working working3 = new Working("3","gloubiboulga",2.0,r);
		Working working4 = new Working("4","zgzgzr",30.1,r2);
		java.util.ArrayList<Working> wk3 = new java.util.ArrayList<Working>() ;
		wk3.add(working3) ;
		wk3.add(working4);
		w3.setWorkings(wk3);
		WBESet tmp= new WBESet("1", "WBES1");
		WBESet tmp2= new WBESet("2", "WBES2");
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList<WorkBreakDownElement>();
		java.util.ArrayList<WorkBreakDownElement> work2=new java.util.ArrayList<WorkBreakDownElement>();
		work.add(w);
		work.add(w2);
		work2.add(w3) ;
		tmp.setWorkBreakDowElements(work) ;
		tmp2.setWorkBreakDowElements(work2);		
		java.util.ArrayList<WBESet> wbes=new java.util.ArrayList<WBESet>();
		wbes.add(tmp) ;
		wbes.add(tmp2) ;
		p.setWbeSets(wbes);
		A1.setWbes(work) ;
		A2.setWbes(work2);		
		test.add(A1) ;
		test.add(A2) ;
		p.setSubActivities(test) ;
		ControlObjVariation c = new ControlObjVariation(p) ;
		assertTrue(c.getDataVariation().get(0).getTempsReel()==20.5) ;
		assertTrue(c.getDataVariation().get(1).getTempsReel()==15.8) ;
		assertTrue(c.getDataVariation().get(2).getTempsReel()==2.0) ;
		assertTrue(c.getDataVariation().get(3).getTempsReel()==30.1) ;
		assertTrue(c.getDataVariation().get(4).getTempsReel()==36.3) ;
		assertTrue(c.getDataVariation().get(5).getTempsReel()==32.1) ;
	}

	/*
	 * Test method for 'control.ControlObjVariation.getRessourcesVariation()'
	 */
	public void testGetRessourcesVariation() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();
		Resource r=new Resource("1","ress1");
		Resource r2=new Resource("2","ress2");
		resources.add(r);
		resources.add(r2);
		p.setResources(resources);
		java.util.ArrayList<Activity> test=new java.util.ArrayList<Activity>();
		Activity A1=new Activity("1","it1");
		Activity A2=new Activity("2","it2");
		WorkBreakDownElement w = new WorkBreakDownElement ("1","testName1",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		WorkBreakDownElement w3 = new WorkBreakDownElement ("3","testName3",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),12.11);	
		Working working1 = new Working("1","blablabla",10.5,r);
		Working working5 = new Working("5","blablablasrth",10.0,r);
		java.util.ArrayList<Working> wk1 = new java.util.ArrayList<Working>() ;
		wk1.add(working1) ;
		w.setWorkings(wk1) ;
		Working working2 = new Working("2","tacos",15.8,r2);
		java.util.ArrayList<Working> wk2 = new java.util.ArrayList<Working>() ;
		wk2.add(working2);
		wk2.add(working5);
		w2.setWorkings(wk2) ;
		Working working3 = new Working("3","gloubiboulga",2.0,r);
		Working working4 = new Working("4","zgzgzr",30.1,r2);
		java.util.ArrayList<Working> wk3 = new java.util.ArrayList<Working>() ;
		wk3.add(working3) ;
		wk3.add(working4);
		w3.setWorkings(wk3);
		WBESet tmp= new WBESet("1", "WBES1");
		WBESet tmp2= new WBESet("2", "WBES2");
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList<WorkBreakDownElement>();
		java.util.ArrayList<WorkBreakDownElement> work2=new java.util.ArrayList<WorkBreakDownElement>();
		work.add(w);
		work.add(w2);
		work2.add(w3) ;
		tmp.setWorkBreakDowElements(work) ;
		tmp2.setWorkBreakDowElements(work2);		
		java.util.ArrayList<WBESet> wbes=new java.util.ArrayList<WBESet>();
		wbes.add(tmp) ;
		wbes.add(tmp2) ;
		p.setWbeSets(wbes);
		A1.setWbes(work) ;
		A2.setWbes(work2);		
		test.add(A1) ;
		test.add(A2) ;
		p.setSubActivities(test) ;
		ControlObjVariation c = new ControlObjVariation(p) ;
		assertTrue(c.getRessourcesVariation().get(0).getTempsReel()==22.5 && c.getRessourcesVariation().get(0).getNbTaches()==3) ;
		assertTrue(c.getRessourcesVariation().get(1).getTempsReel()==45.9 && c.getRessourcesVariation().get(1).getNbTaches()==2 ) ;		
	}

	/*
	 * Test method for 'control.ControlObjVariation.getAllRessources()'
	 */
	public void testGetAllRessources() {
			ArrayList<Resource> ressources = new ArrayList<Resource>() ;
			Resource r1 = new Resource("testID1","testName1") ;
			Resource r2 = new Resource("testID2","testName2") ;
			ressources.add(r1) ;
			ressources.add(r2) ;
			Project p=new Project("idA", "nom", 100.0, 200.0);
			p.setResources(ressources);
			ControlObjVariation c = new ControlObjVariation(p) ;
			assertEquals(ressources,c.getAllRessources()) ;
	}

}

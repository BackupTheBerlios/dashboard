package test;

import java.util.Date;

import entity.Activity;
import entity.Project;
import entity.Resource;
import entity.WBESet;
import entity.WorkBreakDownElement;

import junit.framework.TestCase;

public class ProjectTest extends TestCase {

	/*
	 * Test method for 'entity.Project.Project(String, String, Double, Double)'
	 */
	public void testProjectStringStringDoubleDouble() {
		Project p=new Project("idA", "nom", 100.0, 200.0);
		assertTrue(p.getId()=="idA");
		assertTrue(p.getName()=="nom");
		assertTrue(p.getPrevBudget()==100.0);
		assertTrue(p.getRealBudget()==200.0);
	}

	/*
	 * Test method for 'entity.Project.Project()'
	 */
	public void testProject() {
		Project p=new Project();
		assertTrue(p.getId()==null);
		assertTrue(p.getName()==null);
	}

	/*
	 * Test method for 'entity.Project.getResources()'
	 */
	public void testGetResources() {
		
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();
		Resource r1=new Resource("1","r1");
		Resource r2=new Resource("2","r2");
		resources.add(r1);
		resources.add(r2);
		p.setResources(resources);
		assertTrue(resources.equals(p.getResources()));
	}

	/*
	 * Test method for 'entity.Project.setResources(ArrayList<Resource>)'
	 */
	public void testSetResources() {

		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();
		Resource r1=new Resource("1","r1");
		Resource r2=new Resource("2","r2");
		resources.add(r1);
		resources.add(r2);
		p.setResources(resources);
		assertTrue(resources.equals(p.getResources()));
	}

	/*
	 * Test method for 'entity.Project.getWbeSets()'
	 */
	public void testGetWbeSets() {
		Project p=new Project("idP","nom",100.0,200.0);
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		
		WBESet tmp= new WBESet("2dsf", "sljhf");
		tmp.add(w);
		tmp.add(w2);
		WBESet tmp2= new WBESet("kjhkjh", "tgfhgf");
		tmp2.add(w);
		tmp2.add(w2);
		java.util.ArrayList<WBESet> work=new java.util.ArrayList<WBESet>();
		work.add(tmp);
		work.add(tmp2);
		p.setWbeSets(work);
		assertTrue(work.equals(p.getWbeSets()));
	}

	/*
	 * Test method for 'entity.Project.setWbeSets(ArrayList<WBESet>)'
	 */
	public void testSetWbeSets() {
		Project p=new Project("idP","nom",100.0,200.0);
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		WBESet tmp= new WBESet("2dsf", "sljhf");
		tmp.add(w);
		tmp.add(w2);
		WBESet tmp2= new WBESet("kjhkjh", "tgfhgf");
		tmp2.add(w);
		tmp2.add(w2);
		java.util.ArrayList<WBESet> work=new java.util.ArrayList<WBESet>();
		work.add(tmp);
		work.add(tmp2);
		p.setWbeSets(work);
		assertTrue(work.equals(p.getWbeSets()));
	}

	/*
	 * Test method for 'entity.Project.findResourceById(String)'
	 */
	public void testFindResourceById() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Resource> resources = new java.util.ArrayList<Resource>();
		Resource r1=new Resource("1","r1");
		Resource r2=new Resource("2","r2");
		resources.add(r1);
		resources.add(r2);
		p.setResources(resources);
		try
		{
			Resource r3=p.findResourceById("1");
			assertTrue(r1.equals(r3));
			assert(true);
		}
		catch (Exception e) 
		{			
			fail();
		}
		try
		{
			Resource r3=p.findResourceById("32585");
			fail();
		}
		catch (Exception e) 
		{			
			assert(true);
		}
		
		
	}

	/*
	 * Test method for 'entity.Project.findWbeSetById(String)'
	 */
	public void testFindWbeSetById() {
		
		Project p=new Project("idP","nom",100.0,200.0);
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		WBESet tmp= new WBESet("WBE1", "WBE1");
		tmp.add(w);
		tmp.add(w2);
		WBESet tmp2= new WBESet("WBE2", "WBE2");
		tmp2.add(w);
		tmp2.add(w2);
		java.util.ArrayList<WBESet> work=new java.util.ArrayList<WBESet>();
		work.add(tmp);
		work.add(tmp2);
		p.setWbeSets(work);
		try
		{
			WBESet w3=p.findWbeSetById("WBE2");
			assertTrue(tmp2.equals(w3));
			assert(true);
		}
		catch (Exception e) 
		{			
			fail();
		}
		try
		{
			WBESet w3=p.findWbeSetById("pasbon");
			fail();
		}
		catch (Exception e) 
		{			
			assert(true);
		}
		
	}

	/*
	 * Test method for 'entity.Project.getPrevBudget()'
	 */
	public void testGetPrevBudget() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		assertTrue(p.getPrevBudget()==1000.0);
		
	}

	/*
	 * Test method for 'entity.Project.setPrevBudget(Double)'
	 */
	public void testSetPrevBudget() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		p.setPrevBudget(2000.00);
		assertTrue(p.getPrevBudget()==2000.00);
	}

	/*
	 * Test method for 'entity.Project.getRealBudget()'
	 */
	public void testGetRealBudget() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		assertTrue(p.getRealBudget()==2000.0);
	}

	/*
	 * Test method for 'entity.Project.setRealBudget(Double)'
	 */
	public void testSetRealBudget() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		p.setRealBudget(3000.00);
		assertTrue(p.getRealBudget()==3000.00);
	}

	/*
	 * Test method for 'entity.Project.getImportNumbers()'
	 */
	public void testGetImportNumbers() {
		Project p= new Project("ida", "nom", 1000.0, 2000.0);
		java.util.ArrayList<Activity> test=new java.util.ArrayList<Activity>();
		Activity A1=new Activity("1","A1");
		Activity A2=new Activity("2","A2");
		Activity A3=new Activity("3","A3");
		test.add(A1);
		test.add(A2);
		test.add(A3);
		p.setSubActivities(test);
		int res []=p.getImportNumbers();
		assertTrue(res.length==3);
		}

}

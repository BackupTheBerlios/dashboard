package entity;

import java.util.Date;

import junit.framework.TestCase;

public class ActivityTest extends TestCase {

	/*
	 * Test method for 'entity.Activity.getPrevWorkAmount()'
	 */
	public void testGetPrevWorkAmount() {
	Activity A=new Activity("0","A2");
	java.util.ArrayList<Activity> test=new java.util.ArrayList();
	Activity A1=new Activity("1","A1");
	WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
	WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
	java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
	work.add(w);
	work.add(w2);
	A1.setWbes(work);
	test.add(A1);
	Activity A2=new Activity("2","A2");
	A2.setWbes(work);
	test.add(A2);
	Activity A3=new Activity("3","A3");
	A3.setWbes(work);
	test.add(A3);
	A.setSubActivities(test);
	//72.72=12.12*6
	assertTrue(72.72==A.getPrevWorkAmount());
	
	}

	/*
	 * Test method for 'entity.Activity.getRealWorkAmount()'
	 */
	public void testGetRealWorkAmount() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		Activity A3=new Activity("3","A3");
		A3.setWbes(work);
		test.add(A3);
		A.setSubActivities(test);
		//63.36=3*10.01+3*11.11
		assertTrue(63.36==A.getRealWorkAmount());
	}

	/*
	 * Test method for 'entity.Activity.getRealStartDate()'
	 */
	public void testGetRealStartDate() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		Activity A3=new Activity("3","A3");
		A3.setWbes(work);
		test.add(A3);
		A.setSubActivities(test);
		//63.36=3*10.01+3*11.11
		assertTrue(new Date(2006, 10, 10)==A.getRealStartDate());
	}

	/*
	 * Test method for 'entity.Activity.getRealEndDate()'
	 */
	public void testGetRealEndDate() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		Activity A3=new Activity("3","A3");
		A3.setWbes(work);
		test.add(A3);
		A.setSubActivities(test);
		//63.36=3*10.01+3*11.11
		assertTrue(new Date(2006, 9, 9)==A.getRealEndDate());
	}

	/*
	 * Test method for 'entity.Activity.getPrevStartDate()'
	 */
	public void testGetPrevStartDate() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		Activity A3=new Activity("3","A3");
		A3.setWbes(work);
		test.add(A3);
		A.setSubActivities(test);
		//63.36=3*10.01+3*11.11
		assertTrue(new Date(2006, 12, 12)==A.getPrevStartDate());
	}

	/*
	 * Test method for 'entity.Activity.getPrevEndDate()'
	 */
	public void testGetPrevEndDate() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		Activity A3=new Activity("3","A3");
		A3.setWbes(work);
		test.add(A3);
		A.setSubActivities(test);
		//63.36=3*10.01+3*11.11
		assertTrue(new Date(2006, 11, 11)==A.getPrevEndDate());
	}

	/*
	 * Test method for 'entity.Activity.getName()'
	 */
	public void testGetName() {
		
		Activity test= new Activity("2","essai");
		assertTrue("essai"==test.getName());

	}

	/*
	 * Test method for 'entity.Activity.getId()'
	 */
	public void testGetId() {
		Activity test= new Activity("2","essai");
		assertTrue("2"==test.getId());
	}

	/*
	 * Test method for 'entity.Activity.Activity(String, String)'
	 */
	public void testActivityStringString() {
		Activity test= new Activity("2","essai");
		assertTrue("2"==test.getId());
		assertTrue("essai"==test.getName());
	}

	/*
	 * Test method for 'entity.Activity.Activity()'
	 */
	public void testActivity() {
		Activity test= new Activity();
		assertTrue(null==test.getId());
		assertTrue(null==test.getName());
		
	}

	/*
	 * Test method for 'entity.Activity.setId(String)'
	 */
	public void testSetId() {
		
		Activity test= new Activity("2","essai");
		test.setId("3");
		assertTrue("essai"==test.getId());
	}

	/*
	 * Test method for 'entity.Activity.setName(String)'
	 */
	public void testSetName() {
		
		Activity test= new Activity("2","essai");
		test.setName("essai2");
		assertTrue("essai2"==test.getName());
	}

	/*
	 * Test method for 'entity.Activity.getSubActivities()'
	 */
	public void testGetSubActivities() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		Activity A2=new Activity("2","A2");
		Activity A3=new Activity("3","A3");
		test.add(A1);
		test.add(A2);
		test.add(A3);
		A.setSubActivities(test);
		assertTrue(test.equals(A.getSubActivities()));
	}

	/*
	 * Test method for 'entity.Activity.setSubActivities(ArrayList<Activity>)'
	 */
	public void testSetSubActivities() {
		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		Activity A2=new Activity("2","A2");
		Activity A3=new Activity("3","A3");
		test.add(A1);
		test.add(A2);
		test.add(A3);
		A.setSubActivities(test);
		assertTrue(test.equals(A.getSubActivities()));
	}

	/*
	 * Test method for 'entity.Activity.getWbes()'
	 */
	public void testGetWbes() {
		
		Activity A=new Activity("0","A2");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A.setWbes(work);
		assertTrue(work.equals(A.getWbes()));
	}

	/*
	 * Test method for 'entity.Activity.setWbes(ArrayList<WorkBreakDownElement>)'
	 */
	public void testSetWbes() {
		
		Activity A=new Activity("0","A2");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A.setWbes(work);
		assertTrue(work.equals(A.getWbes()));
	}

	/*
	 * Test method for 'entity.Activity.findActivityById(String)'
	 */
	public void testFindActivityById() {

		Activity A=new Activity("0","A2");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		Activity A2=new Activity("2","A2");
		Activity A3=new Activity("3","A3");
		test.add(A1);
		test.add(A2);
		test.add(A3);
		A.setSubActivities(test);
		try
		{
			Activity A4=A.findActivityById("3");
			assertTrue(A4.equals(A3));
			assert(true);
		}
		catch (Exception e) 
		{			
			fail();
		}
		try
		{
			Activity A4=A.findActivityById("Pasbon");
			fail();
		}
		catch (Exception e) 
		{			
			assert(true);
		}
	}

	/*
	 * Test method for 'entity.Activity.findWbeById(String)'
	 */
	public void testFindWbeById() {
		
		Activity A=new Activity("0","A2");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A.setWbes(work);
		try
		{
			WorkBreakDownElement w3=A.findWbeById("testId2");
			assertTrue(w2.equals(w3));
			assert(true);
		}
		catch (Exception e) 
		{			
			fail();
		}
		try
		{
			WorkBreakDownElement w3=A.findWbeById("Pasbon");
			fail();
		}
		catch (Exception e) 
		{			
			assert(true);
		}
		

	}

	/*
	 * Test method for 'entity.Activity.getWbesRecursive()'
	 */
	public void testGetWbesRecursive() {
		Activity A=new Activity("0","A");
		java.util.ArrayList<Activity> test=new java.util.ArrayList();
		Activity A1=new Activity("1","A1");
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		WorkBreakDownElement w2 = new WorkBreakDownElement ("testId2","testName2",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),10.01);
		java.util.ArrayList<WorkBreakDownElement> work=new java.util.ArrayList();
		work.add(w);
		work.add(w2);
		A1.setWbes(work);
		test.add(A1);
		Activity A2=new Activity("2","A2");
		A2.setWbes(work);
		test.add(A2);
		A.setWbes(work);
		java.util.ArrayList<WorkBreakDownElement> res=A.getWbesRecursive();
		assertTrue(res.contains(w));
		assertTrue(res.contains(w2));
		
	}

}

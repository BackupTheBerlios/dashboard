package test;
import entity.WorkBreakDownElement;
import entity.Working;

import java.util.*;
import junit.framework.TestCase;

public class WorkBreakDownElementTest extends TestCase {

	/*
	 * Test method for 'entity.WorkBreakDownElement.getPrevWorkAmount()'
	 */
	public void testGetPrevWorkAmount() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getPrevWorkAmount()==12.12);
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getRealWorkAmount()'
	 */
	public void testGetRealWorkAmount() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getRealWorkAmount()==11.11);

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getRealStartDate()'
	 */
	public void testGetRealStartDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getRealStartDate()==new Date(2006, 10, 10));

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getRealEndDate()'
	 */
	public void testGetRealEndDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getRealStartDate()==new Date(2006,9, 9));

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getPrevStartDate()'
	 */
	public void testGetPrevStartDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getPrevStartDate()==new Date(2006,12, 12));

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getPrevEndDate()'
	 */
	public void testGetPrevEndDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getPrevEndDate()==new Date(2006,11, 11));

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getName()'
	 */
	public void testGetName() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getName()=="testName");

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getId()'
	 */
	public void testGetId() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getId()=="testId");

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.WorkBreakDownElement(String, String, Date, Date, Double, Date, Date, Double)'
	 */
	public void testWorkBreakDownElementStringStringDateDateDoubleDateDateDouble() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getId()=="testId" && w.getName()=="testName" && w.getPrevEndDate()==new Date(2006,11, 11)&& w.getPrevStartDate()==new Date(2006,12, 12) && w.getRealStartDate()==new Date(2006,9, 9) && w.getRealStartDate()==new Date(2006, 10, 10) && w.getRealWorkAmount()==11.11 && w.getPrevWorkAmount()==12.12); 
		
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.WorkBreakDownElement()'
	 */
	public void testWorkBreakDownElement() {
		WorkBreakDownElement w = new WorkBreakDownElement ("testId","testName",new Date(2005, 12, 12),new Date(2006, 11, 11),12.12,new Date(2006, 10, 10),new Date(2006, 9, 9),11.11);
		assertTrue(w.getId()==null && w.getName()==null && w.getPrevEndDate()==null && w.getPrevStartDate()==null && w.getRealStartDate()==null && w.getRealStartDate()==null && w.getRealWorkAmount()==null && w.getPrevWorkAmount()==null); 
		
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setId(String)'
	 */
	public void testSetId() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setId("toto");
		assertTrue(w.getId()==null); 
		

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setName(String)'
	 */
	public void testSetName() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setName("toto");
		assertTrue(w.getName()=="toto"); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setPrevEndDate(Date)'
	 */
	public void testSetPrevEndDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setPrevEndDate(new Date(2006,12, 12));
		assertTrue(w.getPrevEndDate()==new Date(2006,12, 12)); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setPrevStartDate(Date)'
	 */
	public void testSetPrevStartDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setPrevStartDate(new Date(2006,12, 12));
		assertTrue(w.getPrevStartDate()==new Date(2006,12, 12)); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setPrevWorkAmount(Double)'
	 */
	public void testSetPrevWorkAmount() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setPrevWorkAmount(10.2);
		assertTrue(w.getPrevWorkAmount()==10.2); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setRealEndDate(Date)'
	 */
	public void testSetRealEndDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setRealEndDate(new Date(2006,12, 12));
		assertTrue(w.getRealEndDate()==new Date(2006,12, 12)); 
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setRealStartDate(Date)'
	 */
	public void testSetRealStartDate() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setRealStartDate(new Date(2006,12, 12));
		assertTrue(w.getRealStartDate()==new Date(2006,12, 12)); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setRealWorkAmount(Double)'
	 */
	public void testSetRealWorkAmount() {
		WorkBreakDownElement w = new WorkBreakDownElement ();
		w.setRealWorkAmount(10.2);
		assertTrue(w.getRealWorkAmount()==10.2); 

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getWorkings()'
	 */
	public void testGetWorkings() {
		/* en cours
		WorkBreakDownElement w = new WorkBreakDownElement ();
		java.util.ArrayList<Working> workings = new java.util.ArrayList<Working>();
		w.setRealWorkAmount(10.2);
		assertTrue(getWorkings()==10.2); 
		*/
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setWorkings(ArrayList<Working>)'
	 */
	public void testSetWorkings() {
			
	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.findWorkingById(String)'
	 */
	public void testFindWorkingById() {

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.getWbeSets()'
	 */
	public void testGetWbeSets() {

	}

	/*
	 * Test method for 'entity.WorkBreakDownElement.setWbeSets(ArrayList<WBESet>)'
	 */
	public void testSetWbeSets() {

	}

	/*
	 * Test method for 'entity.Plannable.toString()'
	 */
	public void testToString() {

	}

}

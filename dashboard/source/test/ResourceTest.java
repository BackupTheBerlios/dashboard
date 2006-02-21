package test;

import entity.Resource;
import entity.Working;
import junit.framework.TestCase;
import java.util.Collection;
import java.util.ArrayList;

public class ResourceTest extends TestCase {

	/*
	 * Test method for 'entity.Resource.getId()'
	 */
	public void testGetId() {
		Resource r = new Resource("testID","testName") ;
		assertTrue(r.getId()=="testID") ;
	}

	/*
	 * Test method for 'entity.Resource.getName()'
	 */
	public void testGetName() {
		Resource r = new Resource("testID","testName") ;
		assertTrue(r.getName()=="testName") ;
	}

	/*
	 * Test method for 'entity.Resource.toString()'
	 */
	public void testToString() {
		Resource r = new Resource("testID","testName") ;
		assertTrue(r.toString()=="testName") ;
	}

	/*
	 * Test method for 'entity.Resource.getWorkings()'
	 */
	public void testGetWorkings() {
		Working w1 = new Working("testWorking1") ;
		Working w2 = new Working("testWorking2") ;
		Collection<Working> workingsTest = new ArrayList<Working>() ;
		workingsTest.add(w1) ;
		workingsTest.add(w2) ;
		
		Resource r = new Resource("testID") ;
		r.workings = workingsTest ;
		assertEquals(workingsTest,r.getWorkings()) ;
	}

	/*
	 * Test method for 'entity.Resource.setName(String)'
	 */
	public void testSetName() {
		Resource r = new Resource("testID") ;
		r.setName("testName") ;
		assertTrue(r.getName()=="testName") ;
	}

	/*
	 * Test method for 'entity.Resource.addWorking(Working)'
	 */
	public void testAddWorking() {
		Working w1 = new Working("testWorking1") ;
		Working w2 = new Working("testWorking2") ;
		Collection<Working> workingsTest = new ArrayList<Working>() ;
		workingsTest.add(w1) ;		
		Resource r = new Resource("testID") ;
		r.workings = workingsTest ;
		r.addWorking(w2) ;
		workingsTest.add(w2) ;
		assertEquals(workingsTest,r.getWorkings()) ;
	}

	/*
	 * Test method for 'entity.Resource.addWorkingsAll(Collection<? extends Working>)'
	 */
	public void testAddWorkingsAll() {
		Working w1 = new Working("testWorking1") ;
		Working w2 = new Working("testWorking2") ;
		Working w3 = new Working("testWorking3") ;
		Collection<Working> workingsTest = new ArrayList<Working>() ;
		Collection<Working> workingsTest2 = new ArrayList<Working>() ;
		workingsTest.add(w1) ;
		workingsTest2.add(w2) ;
		workingsTest2.add(w3) ;
		
		Resource r = new Resource("testID") ;
		r.workings = workingsTest ;
		r.addWorkingsAll(workingsTest2) ;
		workingsTest.add(w2) ;
		workingsTest.add(w3) ;
		assertEquals(workingsTest,r.getWorkings()) ;
	}

	/*
	 * Test method for 'entity.Resource.isWorkingsEmpty()'
	 */
	public void testIsWorkingsEmpty() {
		Resource r = new Resource("testID") ;
		
		//test quand il n'y a pas de workings
		assertTrue(r.isWorkingsEmpty()) ;
		
		//test quand il y a des workings
		Working w = new Working("testWorking");
		r.addWorking(w) ;
		assertFalse(r.isWorkingsEmpty()) ;		
	}

	/*
	 * Test method for 'entity.Resource.iteratorOnWorkings()'
	 */
	public void testIteratorOnWorkings() {
		
	}

	/*
	 * Test method for 'entity.Resource.workinsSize()'
	 */
	public void testWorkinsSize() {
		Working w1 = new Working("testWorking1") ;
		Working w2 = new Working("testWorking2") ;
		Collection<Working> workingsTest = new ArrayList<Working>() ;
		workingsTest.add(w1) ;
		workingsTest.add(w2) ;
		
		Resource r = new Resource("testID") ;
		r.workings = workingsTest ;
		assertTrue(workingsTest.size() == r.workinsSize()) ;
	}

}

package test;
import entity.*;
import junit.framework.TestCase;

public class WBESetTest extends TestCase {

	/*
	 * Test method for 'entity.WBESet.WBESet(String, String)'
	 */
	public void testWBESet() {
		WBESet w = new WBESet ("test1","test2");
		assertTrue (w.getId()=="test1" && w.getName()=="test2");
	}

	/*
	 * Test method for 'entity.WBESet.getId()'
	 */
	public void testGetId() {
		WBESet w = new WBESet ("test1","test2");
		assertTrue (w.getId()=="test1");

	}

	/*
	 * Test method for 'entity.WBESet.getName()'
	 */
	public void testGetName() {
		WBESet w = new WBESet ("test1","test2");
		assertTrue (w.getName()=="test2");
	}

	/*
	 * Test method for 'entity.WBESet.setName(String)'
	 */
	public void testSetName() {
		WBESet w = new WBESet ("test1","test2");
		w.setName("test3");
		assertTrue (w.getName()=="test3");

	}

	/*
	 * Test method for 'entity.WBESet.add(WorkBreakDownElement)'
	 */
	public void testAdd() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement();
		w.add(w2);
		assertTrue (w.contains(w2));

	}

	/*
	 * Test method for 'entity.WBESet.contains(Object)'
	 */
	public void testContainsTrue() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement();
		w.add(w2);
		assertTrue (w.contains(w2));
		
	}
	
	public void testContainsFalse() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement();
		assertFalse (w.contains(w2));
		
		
	}

	/*
	 * Test method for 'entity.WBESet.isEmpty()'
	 */
	public void testIsEmptyTrue() {
		WBESet w = new WBESet ("test1","test2");
		assertTrue (w.isEmpty());
	}
	public void testIsEmptyFalse() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement();
		w.add(w2);
		assertFalse (w.isEmpty());
	}

	/*
	 * Test method for 'entity.WBESet.size()'
	 */
	public void testSizeZero() {
		WBESet w = new WBESet ("test1","test2");
		assertTrue (w.size()==0);
	}
	public void testSizeDeux() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement();
		w.add(w2);
		WorkBreakDownElement w3=new WorkBreakDownElement();
		w.add(w3);
		assertTrue (w.size()==2);
	}

	/*
	 * Test method for 'entity.WBESet.getWorkBreakDowElements()'
	 */
	public void testGetWorkBreakDowElements() {
		WBESet w = new WBESet ("test1","test2");
		WorkBreakDownElement w2=new WorkBreakDownElement("toto","tata",null,null,null,null,null,null);
		w.add(w2);
		java.util.Collection<WorkBreakDownElement> work = new java.util.ArrayList<WorkBreakDownElement>();
		work.add(w2);
		assertEquals(w.getWorkBreakDowElements(),work);
		
		
	}

	/*
	 * Test method for 'entity.WBESet.setWorkBreakDowElements(Collection<WorkBreakDownElement>)'
	 */
	public void testSetWorkBreakDowElements() {
		WBESet w = new WBESet ("test1","test2");
		java.util.Collection<WorkBreakDownElement> work = new java.util.ArrayList<WorkBreakDownElement>();
		w.setWorkBreakDowElements(work);
		assertTrue(w.getWorkBreakDowElements()==work);
	}

}

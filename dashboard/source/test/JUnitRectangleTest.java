package test;

import junit.framework.TestCase;

public class JUnitRectangleTest extends TestCase {

	/*
	 * Test method for 'test.JUnitRectangle.setLargeur(double)'
	 */
	public void testSetLargeur() {
		JUnitRectangle r = new JUnitRectangle(10,20);
		try 
		{
			r.setLargeur(-1);
			fail();
		} 
		catch (Exception e) 
		{			
		}		
		
		try 
		{
			r.setLargeur(10);
			assertTrue(r.getLargeur() == 10);
		} catch (Exception e) 
		{
			fail();
		}		
	}

	/*
	 * Test method for 'test.JUnitRectangle.getSurface()'
	 */
	public void testGetSurface() 
	{
		JUnitRectangle r = new JUnitRectangle(10,20);
		try 
		{
			r.setLargeur(10);
			r.setLongueur(20);
			assertTrue(r.getSurface() == 200);
		} catch (Exception e) 
		{
			fail();
		}	
	}

	
	/*
	 * Test method for 'test.JUnitRectangle.estCarre()'
	 */
	public void testEstCarre() {
		JUnitRectangle r = new JUnitRectangle(10,20);
		try 
		{
			r.setLargeur(10);
			r.setLongueur(10);
			assertTrue(r.estCarre());
			r.setLargeur(20);
			assertTrue(!r.estCarre());
		} catch (Exception e) 
		{
			fail();
		}	
	}

}




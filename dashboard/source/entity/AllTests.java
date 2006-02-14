package entity;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for entity");
		//$JUnit-BEGIN$
		suite.addTestSuite(ActivityTest.class);
		suite.addTestSuite(ProjectTest.class);
		//$JUnit-END$
		return suite;
	}

}

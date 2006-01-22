package control;


/*
 *  Java interface "IIndicator.java" generated from Poseidon for UML.
 *  Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 *  Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */

/**
 * <p></p>
 */
public interface IIndicator {
	
	///////////////////////////////////////
	// operations
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public  Double getTresholdMax();
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public  Double getTresholdMin();
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public  IndicatorState compute();
	
} // end IIndicator










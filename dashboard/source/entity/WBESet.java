package entity;

/*
 * Java class "WBESet.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class WBESet {

  ///////////////////////////////////////
  // attributes


/**
 * <p>Represents ...</p>
 */
    private String name; 

   ///////////////////////////////////////
   // associations

/**
 * <p></p>
 * 
 * @poseidon-type WorkBreakDowElement
 */
    private java.util.Collection<WorkBreakDownElement> workBreakDowElements = new java.util.TreeSet<WorkBreakDownElement>(); // of type WorkBreakDowElement

/**
 * @return Returns the name.
 */
public String getName() {
	return name;
}

/**
 * @param name The name to set.
 */
public void setName(String name) {
	this.name = name;
}

/* (non-Javadoc)
 * @see java.util.Collection#add(E)
 */
public boolean add(WorkBreakDownElement workBreakDownElement) {
	return workBreakDowElements.add(workBreakDownElement);
}

/* (non-Javadoc)
 * @see java.util.Collection#contains(java.lang.Object)
 */
public boolean contains(Object workBreakDownElement) {
	return workBreakDowElements.contains(workBreakDownElement);
}

/* (non-Javadoc)
 * @see java.util.Collection#isEmpty()
 */
public boolean isEmpty() {
	return workBreakDowElements.isEmpty();
}

/* (non-Javadoc)
 * @see java.util.Collection#size()
 */
public int size() {
	return workBreakDowElements.size();
}

 } // end WBESet







package entity;

import java.io.Serializable;

/*
 * Java class "WBESet.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class WBESet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////
	// attributes
	/**
	 * <p>Represente l'identifiant permettant de caract�riser de fa�on unique tout ensemble de t�ches</p>
	 */
	private String id;
	
	/**
	 * <p>Represente le nom du groupe (caract�ristique � afficher</p>
	 */
	private String name; 
	
	///////////////////////////////////////
	// associations
	
	/**
	 * <p>Collection de t�ches(WorkBreakDownElement) permettant de r�f�rencer les t�ches du groupe</p>
	 * 
	 */
	private java.util.Collection<WorkBreakDownElement> workBreakDowElements = new java.util.ArrayList<WorkBreakDownElement>(); // of type WorkBreakDowElement
	
	
	/**
	 * @param id
	 * @param name
	 */
	public WBESet(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}

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
	public void add(WorkBreakDownElement workBreakDownElement) {
		workBreakDowElements.add(workBreakDownElement);
		workBreakDownElement.getWbeSets().add(this);
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

	public java.util.Collection<WorkBreakDownElement> getWorkBreakDowElements() {
		return workBreakDowElements;
	}

	public void setWorkBreakDowElements(java.util.Collection<WorkBreakDownElement> workBreakDowElements) {
		this.workBreakDowElements = workBreakDowElements;
	}
	
	
	
} // end WBESet







package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Java class "Resource.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class Resource {

  ///////////////////////////////////////
  // attributes
  ///////////////////////////////////////

	private String id;
/**
 * <p>Represents ...</p>
 */
    private String name; 

   ///////////////////////////////////////
   // associations
   ///////////////////////////////////////

/**
 * <p></p>
 * 
 * @poseidon-type Working
 */
    public java.util.Collection<Working> workings = new ArrayList<Working>(); // of type Working

/**
 * @return Returns the id.
 */
public String getId() {
	return id;
}

/**
 * @param id
 * @param name
 */
public Resource(String id, String name) {
	super();
	// TODO Auto-generated constructor stub
	this.id = id;
	this.name = name;
}

/**
 * @return Returns the name.
 */
public String getName() {
	return name;
}

public String toString() {
	return name;
}

/**
 * @return Returns the workings.
 */
public java.util.Collection<Working> getWorkings() {
	return workings;
}

/**
 * @param name The name to set.
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @param workings The workings to set.
 */
public void setWorkings(java.util.Collection<Working> workings) {
	this.workings = workings;
}

/* (non-Javadoc)
 * @see java.util.Collection#add(E)
 */
public boolean addWorking(Working arg0) {
	return workings.add(arg0);
}

/* (non-Javadoc)
 * @see java.util.Collection#addAll(java.util.Collection)
 */
public boolean addWorkingsAll(Collection<? extends Working> arg0) {
	return workings.addAll(arg0);
}

/* (non-Javadoc)
 * @see java.util.Collection#isEmpty()
 */
public boolean isWorkingsEmpty() {
	return workings.isEmpty();
}

/* (non-Javadoc)
 * @see java.util.Collection#iterator()
 */
public Iterator<Working> iteratorOnWorkings() {
	return workings.iterator();
}

/* (non-Javadoc)
 * @see java.util.Collection#size()
 */
public int workinsSize() {
	return workings.size();
}
    

    

 } // end Resource







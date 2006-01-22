package entity;
/*
 * Java class "Plannable.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */
import java.util.Date;


/**
 * <p></p>
 */
public abstract class Plannable {
	
	///////////////////////////////////////
	// attributes
	
	
	/**
	 * <p>Represents ...</p>
	 */
	protected Date dateDebutEff; 
	
	/**
	 * <p>Represents ...</p>
	 */
	protected Date dateFinEff; 
	
	/**
	 * <p>Represents ...</p>
	 */
	protected Double estime ; 
	
	/**
	 * <p>Represents ...</p>
	 */
	protected Double reel ;
	///////////////////////////////////////
	// operations
	
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Double getPrevisionsDelais();
	
	/**
	 * <p>Does ...</p>
	 * 
	 * 
	 * @return 
	 */
	public abstract Double getPrevisionsCharges();
	
	/**
	 * @return Returns the dateDebutEff.
	 */
	public Date getDateDebutEff() {
		return dateDebutEff;
	}
	
	/**
	 * @return Returns the dateFinEff.
	 */
	public Date getDateFinEff() {
		return dateFinEff;
	}
	
	/**
	 * @return Returns the previsions.
	 */
	public Double getEstime() {
		return estime ;
	}
	
	/**
	 * @param dateDebutEff The dateDebutEff to set.
	 */
	public void setDateDebutEff(Date dateDebutEff) {
		this.dateDebutEff = dateDebutEff;
	}
	
	/**
	 * @param dateFinEff The dateFinEff to set.
	 */
	public void setDateFinEff(Date dateFinEff) {
		this.dateFinEff = dateFinEff;
	}
	
	/**
	 * @param previsions The previsions to set.
	 */
	public void setEstime(Double previsions) {
		this.estime = previsions;
	}

	public Double getReel() {
		return reel;
	}
	
 
	public void setReel(Double reel) {
		this.reel = reel;
	}
	
} // end Plannable







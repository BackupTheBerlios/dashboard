package control;
/*
 * Java class "IndicatorState.java" generated from Poseidon for UML.
 * Poseidon for UML is developed by <A HREF="http://www.gentleware.com">Gentleware</A>.
 * Generated with <A HREF="http://jakarta.apache.org/velocity/">velocity</A> template engine.
 */


/**
 * <p></p>
 */
public class IndicatorState {
	
	///////////////////////////////////////
	// attributes
	
	String name;
	
	String id;
	
	/**
	 * <p>Represents ...</p>
	 */
	private int led; 
	
	/**
	 * <p>Represents ...</p>
	 */
	private Double value = new Double(0.0);

	/**
	 * @return Returns the led.
	 */
	public int getLed() {
		return led;
	}

	/**
	 * @return Returns the value.
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param led The led to set.
	 */
	public void setLed(int led) {
		this.led = led;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	
	/**
	 * @param value The value to set.
	 */
	public void plusValue(Double value) {
		this.value = this.value + value;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	} 
} // end IndicatorState







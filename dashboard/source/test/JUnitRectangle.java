package test;

public class JUnitRectangle {

	private double longueur;
	private double largeur;
	
	 
	/**
	 * @param longueur
	 * @param largeur
	 */
	public JUnitRectangle(double longueur, double largeur){
		// TODO Auto-generated constructor stub		
		longueur = 0;
		largeur=0;
	}


	/**
	 * @return Returns the largeur.
	 */
	public double getLargeur() {
		return largeur;
	}
	
	
	/**
	 * @param largeur The largeur to set.
	 */
	public void setLargeur(double d) throws Exception{
		if(d < 0)
		{			
			throw new Exception("Dimension invalide!");
		}
		this.largeur = d;
	}


	/**
	 * @return Returns the longueur.
	 */
	public double getLongueur() {
		return longueur;
	}


	/**
	 * @param longueur The longueur to set.
	 */
	public void setLongueur(double d) throws Exception{
		if(d < 0)
		{			
			throw new Exception("Dimension invalide!");
		}
		this.longueur = d;
	}
	
	public double getSurface()
	{
		return longueur*largeur;
	}
	
	
	public boolean estCarre()
	{
		return longueur == largeur;		
	}
	
	
	
}

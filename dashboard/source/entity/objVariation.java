package entity;

public class objVariation
{
	private String iteration ;
	private double tempsEstime ;
	private double tempsReel ;
	private String ressource ;
	private int	numSemaine ;
	
	public objVariation(String it, double estim, double reel, String ress, int num)
	{
		this.iteration = it ;
		this.tempsEstime = estim ;
		this.tempsReel = reel ;
		this.ressource = ress ;
		this.numSemaine = num ;
	}
	
	public String getIteration()
	{
		return this.iteration ;
	}
	
	public double getTempsEstime()
	{
		return this.tempsEstime ;
	}
	
	public double getTempsReel()
	{
		return this.tempsReel ;
	}
	
	public String getRessource()
	{
		return this.ressource ;
	}
	
	public int getNumSemaine()
	{
		return this.numSemaine ;
	}
	
	public void setIteration(String it)
	{
		this.iteration = it ;
	}
	
	public void setTempsEstime(double estim)
	{
		this.tempsEstime = estim ;
	}
	
	public void setTempsReel(double reel)
	{
		this.tempsReel = reel ;
	}
	
	public void setRessource(String ress)
	{
		this.ressource = ress ;
	}
	
	public void setNumSemaine(int num)
	{
		this.numSemaine = num ;
	}
}

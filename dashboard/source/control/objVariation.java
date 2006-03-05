package control;

public class objVariation
{
	private String iteration ;
	private double tempsEstime ;
	private double tempsReel ;
	private String ressource ;
	private String idRessource; 
	private int	nbTaches ;
	
	public objVariation(String it, double estim, double reel, String ress,String id, int num)
	{
		this.iteration = it ;
		this.tempsEstime = estim ;
		this.tempsReel = reel ;
		this.ressource = ress ;
		this.idRessource=id;
		this.nbTaches = num ;
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
	
 
	
	public int getNbTaches() {
		return nbTaches;
	}

	public void setNbTaches(int nbTaches) {
		this.nbTaches = nbTaches;
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
	
	 

	public String getIdRessource() {
		return idRessource;
	}

	public void setIdRessource(String idRessource) {
		this.idRessource = idRessource;
	}
}

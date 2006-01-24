package control;
/**
 * <p>Classe permettant de fournir un sous ensemble de vues données pour le calcul de l'indicateur : Variation estimations/réalisations </p>
 * @author Kamil Guenatri
 *
 */
public class C_ObjVariation {

	private String duration; // duration name 
	private String worker; // worker name
	private double estimation; // estimation tume
	private double realisation; // realisation time
	
	public C_ObjVariation(String dur,String work,double est,double real)
	{
		duration=dur;
		worker=work;
		estimation=est;
		realisation=real;
	}

	public String getDuration() {
		return duration;
	}

	public double getEstimation() {
		return estimation;
	}

	public double getRealisation() {
		return realisation;
	}

	public String getWorker() {
		return worker;
	}

} // end 

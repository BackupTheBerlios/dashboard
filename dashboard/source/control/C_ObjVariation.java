package control;

 
import java.util.Iterator;
import java.util.Vector;

import entity.*;
/**
 * <p>Classe permettant de fournir un sous ensemble de vues données pour le calcul de l'indicateur : Variation estimations/réalisations </p>
 * @author Kamil Guenatri
 *
 */
public class C_ObjVariation {

	 private Project p;
	 private java.util.Collection<WorkBreakDownElement> allWBE = new java.util.ArrayList<WorkBreakDownElement>(); // of type WorkBreakDownElement 
	 
	 public C_ObjVariation(Project pp)
	 {
		 p=pp;
		 allWBE=null;
	 }
	 
	 private java.util.Collection<WorkBreakDownElement> extractWBEFromActivity(Activity a)
	 {
		 
		return a.getWorkBreakDownElements();
		 	
	 } 
	 public void extractWbes()
	 {
		 int taille=p.ActivitiesSize();
		 int i;
		 for(i=0;i<taille;i++)
		 {
			 allWBE.addAll(extractWBEFromActivity( ((Activity[])p.getActivities().toArray()[i]);
		 }
	 }
	 private Vector<objVariation> wbesToObjVariation (String params)
	 {
		 Vector<objVariation> res = new Vector<objVariation>() ;
		 WorkBreakDownElement[] tab=  (WorkBreakDownElement[]) allWBE.toArray(); 
		 int i,k;
		 for(i=0;i<tab.length;i++)
		 {
			  
				 java.util.Collection <Working> wk=tab[i].getWorkings();
				 Working[] tabWk = (Working[]) wk.toArray();
				 if(tabWk.length==1)// one ressource working
				 {
					 objVariation data=new objVariation(tab[i].getActivity().getDuration(),
							 tab[i].getEstime(),
							 tab[i].getReel(),
							 tabWk[1].getName(),0);// num week not implement for the moment
					 res.add(data);
				 }
				 else
				 	{
					 for(k=0;k<tabWk.length;k++)
					 {
						 objVariation data=new objVariation(tab[i].getActivity().getDuration(),
								 tab[i].getEstime(),
								 tab[i].getReel(),
								 tabWk[k].getName(),0);// num week not implement for the moment
						 res.add(data);
					 }
				 	}
			 
		 }
		 return res;
	 }
} // end 

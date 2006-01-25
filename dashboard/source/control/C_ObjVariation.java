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
		 for(i=0;i<taile;i++)
		 {
			 allWBE.addAll(extractWBEFromActivity(p.getActivities().toArray()[i]<Activity>));
		 }
	 }
	 private Vector<objVariation> wbesToObjVariation (String params)
	 {
		 Vector<objVariation> res = new Vector<objVariation>() ;
		 WorkBreakDownElement[] tab=allWBE.toArray(); 
		 int i;
		 for(i=0;i<tab.length;i++)
		 {
			 if(params.equals("Group"))
			 {
				 java.util.Collection <Working> wk=tab[i].getWorkings();
				 if(wk.size()=1)// one ressource working
				 {
					 objVariation data=new objVariation(tab[i].getActivity().getDuration(),tab[i].getEstime(),tab[i].getReel(),tab[i].)
				 }
			 }
		 }
	 }
} // end 

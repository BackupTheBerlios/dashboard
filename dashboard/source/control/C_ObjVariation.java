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
	 Resource[] allRessources ; // of type WorkBreakDownElement 
	 int [] allLevels;
	
	 
	 public C_ObjVariation(Project pp)
	 {
		 p=pp;
		 allRessources=(Resource[]) p.getResources().toArray();
		 allLevels=p.getImportNumbers();
		
		 //allWBE=null;
	 }
	 
	 
	 private java.util.Collection<WorkBreakDownElement> extractWBEFromActivity(Activity a)
	 {		 
		return a.getWbes();		 	
	 }
	 
	 
	 public Vector <objVariation> getDataVariation()
	 {
		 int i,j,k,l,longVect ;
		 
		 Vector <objVariation> res = new Vector<objVariation>() ;
		 int nbrRs=allRessources.length;
		 int nbrLv=allLevels.length;
		 
		 longVect =(nbrRs+1)*nbrLv;
		 
		 for(i=0;i<longVect;i++)
		 {
			 objVariation obj= new objVariation("",0.0,0.0,"","",0);
			 res.add(obj);
		 }
		 for(i=0;i<allLevels.length;i++)// pour chaque level
		 {
			 //recuperer les activités
			 Activity[] act = (Activity[]) p.findByImportNumber(i).toArray();
			 java.util.Collection<WorkBreakDownElement> aux = new java.util.ArrayList<WorkBreakDownElement>();
			 for(k=0;k<act.length;k++)
			 {
				 aux.addAll(extractWBEFromActivity(act[i]));
			 }
			 WorkBreakDownElement[] wbes=(WorkBreakDownElement[]) aux.toArray();
			 for(j=0;j<allRessources.length;j++)// pour chaque ressource
			 {
				 for(k=0;k<wbes.length;k++)
				 {
					 Working [] wk =(Working[]) wbes[k].getWorkings().toArray();
					 for(l=0;l<wk.length;l++)
					 {
						 if(allRessources[j].getId().equals(wk[l].getResource().getId()))
						 {
							 int coord=(i*nbrRs)+j;
							 String lev="level"+allLevels[i];
							 double est=res.get(coord).getTempsEstime()+wbes[k].getPrevWorkAmount();
							 double reel=res.get(coord).getTempsReel()+wbes[k].getRealWorkAmount();
							 String rs=allRessources[j].getName();
							 String idRs=allRessources[j].getId();
							 int numSem=0;//not implement for the moment
							
							 res.get(coord).setIteration(lev);
							 res.get(coord).setTempsEstime(est);
							 res.get(coord).setTempsReel(reel);
							 res.get(coord).setRessource(rs);
							 res.get(coord).setIdRessource(idRs);
							 res.get(coord).setNumSemaine(numSem);
						 }
					 }// enf for l
					  
				 } //end for k
			 }// end for j
		  }//end for i
		 
		 // calcul du total de chaque level
		 for(i=0;i<nbrLv;i++)
		 {
			 int coord=(nbrLv*nbrRs)+i;
			 String lev=res.get(i*nbrRs).getIteration();
			 double est=0.0;
			 double reel=0.0;
			 String rs="group";
			 String idRs=p.getId();
			 int numSem=0;
			 for(j=0;j<nbrRs;j++)
			 {
				 int xy=(i*nbrRs)+j;
				 est+=res.get(xy).getTempsEstime();
				 reel+=res.get(xy).getTempsReel();
			 }
			 res.get(coord).setIteration(lev);
			 res.get(coord).setTempsEstime(est);
			 res.get(coord).setTempsReel(reel);
			 res.get(coord).setRessource(rs);
			 res.get(coord).setIdRessource(idRs);
			 res.get(coord).setNumSemaine(numSem);
		 }
		 return res;
	 }
	 
} // end 

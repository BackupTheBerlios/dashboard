package control;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import entity.*;
/**
 * <p>Classe permettant de fournir un sous ensemble de vues données pour le calcul de l'indicateur : Variation estimations/réalisations </p>
 * @author Kamil Guenatri
 *
 */
public class ControlObjVariation {

	 private Project p;
	 ArrayList<Resource> allRessources ; // of type WorkBreakDownElement 
	 int [] allLevels;
	
	 
 
	 
	 
	 public ControlObjVariation(Project pp) {
		// TODO Auto-generated constructor stub
		 p=pp;
		 allRessources= p.getResources();
		 allLevels=p.getImportNumbers();
	}


	private ArrayList <WorkBreakDownElement> extractWBEFromActivity(Activity a)
	 {		 
		return ((ArrayList <WorkBreakDownElement>)a.getWbes());		 	
	 }
	 
	 
	 public Vector <objVariation> getDataVariation()
	 {
		 int i,j,k,l,longVect ;
		 
		 //System.out.println(allLevels.toString());
		 Vector <objVariation> res = new Vector<objVariation>() ;
		 int nbrRs=allRessources.size();
		 int nbrLv=allLevels.length;
		 
		 longVect =(nbrRs+1)*nbrLv;
		 
		 //System.out.println("rs "+allRessources.get(0).getName() );
		 for(i=0;i<longVect;i++)
		 {
			 objVariation obj= new objVariation("",0.0,0.0,"","",0);
			 res.add(obj);
		 }
		 //recuperer les activités
		 ArrayList <Activity> act =  p.getSubActivities();
		 /*ArrayList <WorkBreakDownElement>wbes = new java.util.ArrayList<WorkBreakDownElement>();
		 for(k=0;k<act.size();k++)
		 {
			 ArrayList <WorkBreakDownElement> aux=extractWBEFromActivity(act.get(k));
			 for(int x=0;x<aux.size();x++)
			 {
				 wbes.add(aux.get(x));
				// system.out.println();
			 }
			 
		 }*/
		/* for(int x=0;x<wbes.size();x++)
		 {
			 //wbes.add(aux.get(x));
			 System.out.println(wbes.get(x).getName());
		 }*/
		 for(i=0;i<allLevels.length;i++)// pour chaque level
		 {
			 ArrayList <WorkBreakDownElement>wbes = new java.util.ArrayList<WorkBreakDownElement>();
			 wbes=extractWBEFromActivity(act.get(i));
			// ArrayList <WorkBreakDownElement> wbes=  aux ;
			 for(j=0;j<allRessources.size();j++)// pour chaque ressource
			 {
				 
				 
				 for(k=0;k<wbes.size();k++)
				 {
					 ArrayList <Working> wk =  wbes.get(k).getWorkings() ;
					 for(l=0;l<wk.size();l++)
					 {
						 if(allRessources.get(j).getId().equals(wk.get(l).getResource().getId()))
						 {
							 
							 int coord=(i*nbrRs)+j;
							 String lev=act.get(i).getName(); 
							 //String lev="iteration"+allLevels[i];
							 double est=res.get(coord).getTempsEstime()+wbes.get(k).getPrevWorkAmount();
							 double reel=res.get(coord).getTempsReel()+wbes.get(k).getRealWorkAmount();
							 String rs=allRessources.get(j).getName();
							 String idRs=allRessources.get(j).getId();
							 int numSem=0;//not implement for the moment
							
							 
							 res.get(coord).setIteration(lev);
							 res.get(coord).setTempsEstime(est);
							 res.get(coord).setTempsReel(reel);
							 res.get(coord).setRessource(rs);
							 res.get(coord).setIdRessource(idRs);
							 res.get(coord).setNumSemaine(numSem);
							 /*
							 if(allRessources.get(j).getId().equals("r1"))
							 {
								 System.out.println(lev + "-"+ est+);
							 }*/
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
			 res.get(coord).setIteration(act.get(i).getName());
			 res.get(coord).setTempsEstime(est);
			 res.get(coord).setTempsReel(reel);
			 res.get(coord).setRessource(rs);
			 res.get(coord).setIdRessource(idRs);
			 res.get(coord).setNumSemaine(numSem);
		 }
		 for(i=0;i<res.size();i++)
		 {
			   System.out.println(res.get(i).getIteration()+"--"+res.get(i).getRessource()+"--"+res.get(i).getTempsReel());
		 }
		 return res;
	 }


	public ArrayList<Resource> getAllRessources() {
		return allRessources;
	}
	 
} // end 


package control;
import java.util.ArrayList;
import java.util.HashMap;

import entity.*;

/**
 * <p>Classe permettant de fournir au vues(fenetres), les donnees necessaires a leur construction....</p>
 * <p>Pour la consolidation, ces donnees sont construite a partir des groupes d'activites (WBEset).</p>
 * <p>Pour chaque vue, une fonction de generation d'indicateur sera implementee.</p>
 * @author �tienne ALLOGO
 *
 */
public class ConsolidationHandler {
	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByResourceView.</p>
	 * 
	 * 
	 * @param WBEset
	 * @return HashMap<String idResource, workAmount Double>
	 */
    public HashMap<String, IndicatorState> getChargeByResources(WBESet groupeActivite) {  
    	
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String, IndicatorState> resultForView = new HashMap<String, IndicatorState>();
    	String idResource = null;
    	IndicatorState tempIndicState = null;
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WorkBreakDownElement wbe : groupeActivite.getWorkBreakDowElements()){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attach�e
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				//ajouter la charge du working � la valeur(charge)
        			//associ�e � la valeur de la ressource dans la Map
    				idResource = working.getResource().getId();
    				if(resultForView.containsKey(idResource)){
    					
    					resultForView.get(idResource).plusValue(working.getWorkAmount());
    				}
    				//si la resource n'est pas referenc�e dans la map, on l'ajoute. 
    				else{
    					tempIndicState = new IndicatorState();
    					
    					resultForView.put(idResource,tempIndicState);
    				}
    			}

    		}
    	}
    	return resultForView;
    } 

	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByWBEView.</p>
	 * 
	 * 
	 * @param WBEsets 
	 * @return HashMap<String idResource, workAmount Double>
	 */
	public HashMap<String,Double> getByWBEViewIndicators(ArrayList<WBESet> WBEsets) { 
		HashMap<String,Double> resultForView = new HashMap<String,Double>();
	    return resultForView;
	} 


}

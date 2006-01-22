
package control;
import java.util.ArrayList;
import java.util.HashMap;

import entity.*;

/**
 * <p>Classe permettant de fournir au vues(fenetres), les donnees necessaires a leur construction....</p>
 * <p>Pour la consolidation, ces donnees sont construite a partir des groupes d'activites (WBEset).</p>
 * <p>Pour chaque vue, une fonction de generation d'indicateur sera implementee.</p>
 * @author étienne ALLOGO
 *
 */
public class ConsolidationHandler {
	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByResourceView.</p>
	 * 
	 * 
	 * @param WBEsets 
	 * @return 
	 */
    public HashMap<String,Double> getChargeByResources(WBESet groupeActivite) {  
    	
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String,Double> resultForView = new HashMap<String,Double>();
    	HashMap<String,Resource> resources = new HashMap<String,Resource>();
    	String idResource = null;
    	Double temp;
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WorkBreakDownElement wbe : groupeActivite.getWorkBreakDowElements()){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//ajouter la charge du working à la valeur(charge)
    			//associé à la valeur de la ressource dans la Map
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				idResource = working.getResource().getId();
    				if(resultForView.containsKey(idResource)){
    					temp = resultForView.get(idResource);
    					temp += working.getWorkAmount();
    				}
    				//si la resource n'est pas referencé dans la map, on l'ajoute. 
    				else{
    					resultForView.put(idResource, working.getWorkAmount());
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
	 * @return 
	 */
	public HashMap<String,Double> getByWBEViewIndicators(ArrayList<WBESet> WBEsets) { 
		HashMap<String,Double> resultForView = new HashMap<String,Double>();
	    return resultForView;
	} 


}


package control;
import java.util.ArrayList;
import java.util.Collection;
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
	 * @param WBEset
	 * @return HashMap<String idResource, workAmount Double>
	 */
    public Collection<IndicatorState> getChargeByResources(WBESet groupeActivite) {  
    	
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String, IndicatorState> resultForView = new HashMap<String, IndicatorState>();
    	String idResource = null;
    	IndicatorState tempIndicState = null;
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WorkBreakDownElement wbe : groupeActivite.getWorkBreakDowElements()){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attachée
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				//ajouter la charge du working à la valeur(charge) associée à la valeur de la ressource dans la Map
    				idResource = working.getResource().getId();
    				//si la resource est pas referencée dans la map. 
    				if(resultForView.containsKey(idResource)){
    					//on ajoute la charge du working au total pour la ressource
    					resultForView.get(idResource).plusValue(working.getWorkAmount());
    				}
    				else{
    					//on crée le nouvel indicateur et on l'initialise les valeurs
    					tempIndicState = new IndicatorState();
    					tempIndicState.setName(working.getResource().getName());
    					tempIndicState.setValue(working.getWorkAmount());
    					
    					//on le rajoute à la Map
    					resultForView.put(idResource,tempIndicState);
    				}
    			}

    		}
    	}
    	
    	return resultForView.values(); //collection d'indicateur state
    } 

	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByWBEView.</p>
	 * 
	 * 
	 * @param WBEsets 
	 * @return HashMap<String idResource, workAmount Double>
	 */
	public Collection<IndicatorState> getByWBEViewIndicators(ArrayList<WBESet> wBEsets) { 
    	//Map contenant les id et les charges pour chaque resource
    	ArrayList<IndicatorState> resultForView = new ArrayList<IndicatorState>();
    	IndicatorState tempIndicState = null;
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WBESet wbeSet : wBEsets){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(WorkBreakDownElement wbe : wbeSet.getWorkBreakDowElements()){
    			//on crée le nouvel indicateur et on l'initialise les valeurs
				tempIndicState = new IndicatorState();
				tempIndicState.setName(wbe.getName());
				tempIndicState.setValue(wbe.getReel());
    			resultForView.add(tempIndicState);

    		}
    	}
    	
    	return resultForView; //collection d'indicateur state
	} 


}

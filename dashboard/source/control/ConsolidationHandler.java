
package control;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
	 * @return Collection<IndicatorState> indicateur à afficher
	 */
	
	
	private HashMap<String,WBESet> collectionOfWbeSets = new HashMap<String, WBESet>();
	private String projectName;
	
	public ConsolidationHandler(Project projet) {
		
		super();
		this.projectName = projet.getName();
		
		Collection<WorkBreakDownElement> works =  projet.getWbesRecursive();
		
		WBESet temp = null;
		WorkBreakDownElement tempwbe = null;
		for(WorkBreakDownElement wbe :  works){
			 tempwbe = new WorkBreakDownElement(wbe.getId(), wbe.getName(), wbe.getPrevStartDate(), wbe.getPrevEndDate() , wbe.getPrevWorkAmount(),wbe.getRealStartDate(), wbe.getRealEndDate() , wbe.getRealWorkAmount());
			for(WBESet wbeset:  wbe.getWbeSets() ){
				if(! this.collectionOfWbeSets.containsKey(wbeset.getId())){
					temp = new WBESet(wbeset.getId(), wbeset.getName());
					this.collectionOfWbeSets.put(temp.getId() , temp);
				}
				
				this.collectionOfWbeSets.get(wbeset.getId()).add(tempwbe);

			}
		}
		
	}

    public Collection<IndicatorState> getChargeByResources(String wbesetId) {  
    	
    	WBESet groupeActivite = collectionOfWbeSets.get(wbesetId);
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String, IndicatorState> indicatorStatesHashMap = new HashMap<String, IndicatorState>();
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
    				if(indicatorStatesHashMap.containsKey(idResource)){
    					//on ajoute la charge du working au total pour la ressource
    					indicatorStatesHashMap.get(idResource).plusValue(working.getWorkAmount());
    				}
    				else{
    					//on crée le nouvel indicateur et on l'initialise les valeurs
    					tempIndicState = new IndicatorState();
    					tempIndicState.setName(working.getResource().getName());
    					tempIndicState.setId(working.getResource().getId());
    					tempIndicState.setValue(working.getWorkAmount());
    					
    					//on le rajoute à la Map
    					indicatorStatesHashMap.put(idResource,tempIndicState);
    				}
    			}

    		}
    	}
    	
    	return indicatorStatesHashMap.values(); //collection d'indicateur state
    } 
    
public Collection<IndicatorState> getChargeByWbeSet(String idResource) {  
	//Map contenant les id et les charges pour chaque resource
	ArrayList<IndicatorState> resultForView = new ArrayList<IndicatorState>();
	IndicatorState tempIndicState = null;
	
	//Pour chaque workBreakDownElemnt du WBEset
	for( WBESet wbeSet : this.collectionOfWbeSets.values()){
		tempIndicState = new IndicatorState();
		tempIndicState.setName(wbeSet.getName());
		tempIndicState.setId(wbeSet.getId());
		
		//Pour chaque working contenu dans le workBreakDownElemnt 
		for(WorkBreakDownElement wbe : wbeSet.getWorkBreakDowElements()){
//			Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attachée
    			if((working.getResource().getId() != null) && (working.getResource().getId().equals(idResource))){
    				tempIndicState.plusValue(working.getWorkAmount());
    			}

    		}
			
			
			

		}
		
		resultForView.add(tempIndicState);
	}
	
	return resultForView; //collection d'indicateur state
    } 

	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByWBEView.</p>
	 * 
	 * 
	 * @param WBEsets 
	 * @return Collection<IndicatorState> indicateur à afficher
	 */
	public Collection<IndicatorState> getChargeForAllWbeset() { 
    	//Map contenant les id et les charges pour chaque resource
    	ArrayList<IndicatorState> resultForView = new ArrayList<IndicatorState>();
    	IndicatorState tempIndicState = null;
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WBESet wbeSet : this.collectionOfWbeSets.values()){
    		tempIndicState = new IndicatorState();
    		tempIndicState.setName(wbeSet.getName());
    		tempIndicState.setId(wbeSet.getId());
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(WorkBreakDownElement wbe : wbeSet.getWorkBreakDowElements()){
    			//on crée le nouvel indicateur et on l'initialise les valeurs
				
    			tempIndicState.plusValue(wbe.getRealWorkAmount());
    			

    		}
    		
    		resultForView.add(tempIndicState);
    	}
    	
    	return resultForView; //collection d'indicateur state
	}


	public String[][] getWbeSetsIdAndName(){
		
		String[][] names = new String[this.collectionOfWbeSets.size()][2];
		int i = 0;
		for( WBESet wbeSet : this.collectionOfWbeSets.values()){
			names[i][0] = wbeSet.getId();
			names[i][1] = wbeSet.getName();	
			i++;
		}
	
		return names;
		
	}

	public String[][] getResourcesIdAndName() {
		
    
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String, String[]> resources = new HashMap<String, String[]>();
    	String idResource = null;
    	String nameResource = null;
    	String[] name;
		
		for( WBESet wbeSet : this.collectionOfWbeSets.values()){
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WorkBreakDownElement wbe : wbeSet.getWorkBreakDowElements()){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attachée
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				//ajouter la charge du working à la valeur(charge) associée à la valeur de la ressource dans la Map
    				idResource = working.getResource().getId();
    				nameResource = working.getResource().getName();
    				//si la resource est pas referencée dans la map. 
    				if(!(resources.containsKey(idResource))){
    					//on crée le nouvel indicateur et on l'initialise les valeurs
    					name = new String[2];
    					name[0] = idResource;
    					name[1] = nameResource;    					
    					//on le rajoute à la Map
    					resources.put(idResource,name);
    				}
    			}

    		}
    	}
    	
    	
		}
		
		String[][] names = new String[resources.size()][2];
		int i = 0;
		for( String[]nameAndId : resources.values()){
			names[i] = nameAndId;
			i++;
		}
	
		return names;
		
	}
	
	


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


}

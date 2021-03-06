
package control;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import entity.Project;
import entity.WBESet;
import entity.WorkBreakDownElement;
import entity.Working;

/**
 * <p>Classe permettant de fournir au vues(fenetres), les donnees necessaires a leur construction....</p>
 * <p>Pour la consolidation, ces donnees sont construite a partir des groupes d'activites (WBEset).</p>
 * <p>Pour chaque vue, une fonction de generation d'indicateur sera implementee.</p>
 * @author �tienne ALLOGO
 *
 */
public class ControlConsolidation {
	
	/**
	 * <p>Methode permettant de generer les indicateurs pour la vue ByResourceView.</p>
	 * 
	 * 
	 * @param WBEset
	 * @return Collection<IndicatorState> indicateur � afficher
	 */
	
	
	private HashMap<String,WBESet> collectionOfWbeSets = new HashMap<String, WBESet>();
	private String projectName;
	
	public ControlConsolidation(Project projet) {
		
		super();
		this.projectName = projet.getName();		
		for(WBESet wset :projet.getWbeSets()){
			collectionOfWbeSets.put(wset.getId(),wset);
		}
	
		
	}

    public ControlConsolidation(ControlProject project) {
		this(project.getProject());
	}

	public Collection<IndicatorState> getChargeByResources(String wbesetId) {  
    	
    	WBESet groupeActivite = collectionOfWbeSets.get(wbesetId);
    	//Map contenant les id et les charges pour chaque resource
    	HashMap<String, IndicatorState> indicatorStatesHashMap = new HashMap<String, IndicatorState>();
    	String idResource = null;
    	IndicatorState tempIndicState = null;
    	IndicatorState other = new IndicatorState();
    	
    	other.setName("other");
    	other.setId("other");
    	
    	//Pour chaque workBreakDownElemnt du WBEset
    	for( WorkBreakDownElement wbe : groupeActivite.getWorkBreakDowElements()){
    		
    		//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attach�e
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				//ajouter la charge du working � la valeur(charge) associ�e � la valeur de la ressource dans la Map
    				idResource = working.getResource().getId();
    				//si la resource est pas referenc�e dans la map. 
    				if(indicatorStatesHashMap.containsKey(idResource)){
    					//on ajoute la charge du working au total pour la ressource
    					indicatorStatesHashMap.get(idResource).plusValue(working.getWorkAmount());
    				}
    				else{
    					if(working.getWorkAmount() != null && working.getWorkAmount() != 0.0 ){
    					//on cr�e le nouvel indicateur et on l'initialise les valeurs
    					tempIndicState = new IndicatorState();
    					tempIndicState.setName(working.getResource().getName());
    					tempIndicState.setId(working.getResource().getId());
    					tempIndicState.setValue(working.getWorkAmount());
    					
    					//on le rajoute � la Map
    					indicatorStatesHashMap.put(idResource,tempIndicState);
    					}
    					
    				}
    			}

    		}
    		/*
    		if(wbe.getRealWorkAmount() >  wbe.getRealWorkAmountOfKnownWorkings()){
				//on cr�e le nouvel indicateur et on l'initialise les valeurs
				other.plusValue(wbe.getRealWorkAmount() -  wbe.getRealWorkAmountOfKnownWorkings());
				
				
			}
    	}
    	
    	if(other.getValue() > 0.0 )
    		//on le rajoute � la Map
				indicatorStatesHashMap.put(idResource,other);
		*/
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
			//Pour chaque working contenu dans le workBreakDownElemnt 
    		for(Working working : wbe.getWorkings() ){
    			
    			//on verifie s'il ya une ressource attach�e
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
	 * @return Collection<IndicatorState> indicateur � afficher
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
    			//on cr�e le nouvel indicateur et on l'initialise les valeurs
				
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
    			
    			//on verifie s'il ya une ressource attach�e
    			if((working.getResource().getId() != null) && (working.getResource().getId().length()!=0)){
    				//ajouter la charge du working � la valeur(charge) associ�e � la valeur de la ressource dans la Map
    				idResource = working.getResource().getId();
    				nameResource = working.getResource().getName();
    				//si la resource est pas referenc�e dans la map. 
    				if(!(resources.containsKey(idResource))){
    					//on cr�e le nouvel indicateur et on l'initialise les valeurs
    					name = new String[2];
    					name[0] = idResource;
    					name[1] = nameResource;    					
    					//on le rajoute � la Map
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

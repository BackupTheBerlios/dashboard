import java.util.HashMap;

import entity.*;

/* CVStest pour OLivier*/

/**
 * 
 */

/**
 * @author étienne
 *
 */
public class TestEntity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Project projet = new Project("2DB");
		HashMap<String,Activity>  activities= new HashMap<String,Activity> ();
		HashMap<String,WorkBreakDownElement>  workBreakDownElements = new HashMap<String,WorkBreakDownElement> ();
		HashMap<String,Resource>  resources = new HashMap<String,Resource> ();
		HashMap<String,Working>  workings = new HashMap<String, Working> ();
		
		Activity activity;
		WorkBreakDownElement wbe;
		Resource resource;
		Working working;
		
		activity = new Activity("1","Itération 1");
		activities.put(activity.getId(),activity);
		activity = new Activity("2","Iteration 2");
		activities.put(activity.getId(),activity);
		activity = new Activity("3","Iteration 4");
		activities.put(activity.getId(),activity);
		
		wbe = new WorkBreakDownElement("1","Réaliser le cas 14");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("2","Réaliser le cas 15");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("3","Préparer l'intégration des L3");
		workBreakDownElements.put(wbe.getId(),wbe);	
		wbe = new WorkBreakDownElement("4","Préparer la revue");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("5","Réaliser l'architecture");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("6","Déterminer la stratégie de test");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("7","Choisir les outils");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("8","Plannifier la prochaine itération");
		workBreakDownElements.put(wbe.getId(),wbe);
		wbe = new WorkBreakDownElement("9","Cloturer l'itération");
		workBreakDownElements.put(wbe.getId(),wbe);
		
		 resource = new Resource("1", "Tankoano Olivier");
		 resources.put(resource.getId(),resource);
		 resource = new Resource("2", "Allogo Etienne");
		 resources.put(resource.getId(),resource);
		 resource = new Resource("3", "Heidy Baubant");
		 resources.put(resource.getId(),resource);
		 resource = new Resource("4", "Guenatri Kamil");
		 resources.put(resource.getId(),resource);
		 
		 working = new Working("1","spécifier précisément le cas 14",21.9);
		 workings.put(working.getId(),working);
		 working = new Working("2","coder le cas 14",43.8);
		 workings.put(working.getId(),working);
		 working = new Working("3","coder le cas 14",72.8);
		 workings.put(working.getId(),working);
		 working = new Working("4","spécifier précisément le cas 15",235.9);
		 workings.put(working.getId(),working);
		 working = new Working("5","coder le cas 15",30.8);
		 workings.put(working.getId(),working);
		 working = new Working("6","coder le cas 15",90.8);
		 workings.put(working.getId(),working);
		 working = new Working("7","intégrer le cas 15 à l'ihm",100.9);
		 workings.put(working.getId(),working);
		 working = new Working("8","rédiger le document de formation",213.8);
		 workings.put(working.getId(),working);
		 working = new Working("9","controler le document de formation",1.8);
		 workings.put(working.getId(),working);
		 working = new Working("10","vérifier la cohérence des documents",122.9);
		 workings.put(working.getId(),working);
		 working = new Working("11","rédiger le power point",3.8);
		 workings.put(working.getId(),working);
		 working = new Working("12","se documenter sur java",2.8);
		 workings.put(working.getId(),working);
		 working = new Working("13","se documenter sur les outils de test",223.9);
		 workings.put(working.getId(),working);
		 working = new Working("14","rédiger la stratégie de test",24.8);
		 workings.put(working.getId(),working);
		 working = new Working("15","choisir un outil de test",200.8);
		 workings.put(working.getId(),working);
		 working = new Working("16","choisir l'environnement java",21.9);
		 workings.put(working.getId(),working);
		 working = new Working("17","choisir les prochain cas à implémenter",3.8);
		 workings.put(working.getId(),working);
		 working = new Working("18","estimer la charge pour chaque cas",2.8);
		 workings.put(working.getId(),working);
		 working = new Working("19","régrouper les documents pour livraison",21.9);
		 workings.put(working.getId(),working);
		 working = new Working("20","réaliser le site avec pog",42.8);
		 workings.put(working.getId(),working);
		 working = new Working("21","réaliser le diagramme d'architecture",546.8);
		 workings.put(working.getId(),working);
		 
		 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("1"));
		 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("2"));
		 activities.get("1").addWorkBreakDownElement(workBreakDownElements.get("3"));
		 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("4"));
		 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("5"));
		 activities.get("2").addWorkBreakDownElement(workBreakDownElements.get("6"));
		 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("7"));
		 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("8"));
		 activities.get("3").addWorkBreakDownElement(workBreakDownElements.get("9"));
		 
		 workBreakDownElements.get("1").addWorking(workings.get("1"));
		 workBreakDownElements.get("1").addWorking(workings.get("2"));
		 workBreakDownElements.get("1").addWorking(workings.get("3"));
		 workBreakDownElements.get("2").addWorking(workings.get("4"));
		 workBreakDownElements.get("2").addWorking(workings.get("5"));
		 workBreakDownElements.get("2").addWorking(workings.get("6"));
		 workBreakDownElements.get("2").addWorking(workings.get("7"));
		 workBreakDownElements.get("3").addWorking(workings.get("8"));
		 workBreakDownElements.get("3").addWorking(workings.get("9"));
		 workBreakDownElements.get("4").addWorking(workings.get("10"));
		 workBreakDownElements.get("4").addWorking(workings.get("11"));
		 workBreakDownElements.get("5").addWorking(workings.get("12"));
		 workBreakDownElements.get("5").addWorking(workings.get("21"));
		 workBreakDownElements.get("6").addWorking(workings.get("14"));
		 workBreakDownElements.get("6").addWorking(workings.get("15"));
		 workBreakDownElements.get("7").addWorking(workings.get("16"));
		 workBreakDownElements.get("7").addWorking(workings.get("17"));
		 workBreakDownElements.get("8").addWorking(workings.get("18"));
		 workBreakDownElements.get("8").addWorking(workings.get("19"));
		 workBreakDownElements.get("9").addWorking(workings.get("20"));
		 workBreakDownElements.get("9").addWorking(workings.get("13"));


		 resources.get("2").addWorking(workings.get("1"));
		 resources.get("1").addWorking(workings.get("2"));
		 resources.get("2").addWorking(workings.get("3"));
		 resources.get("3").addWorking(workings.get("4"));
		 resources.get("1").addWorking(workings.get("5"));
		 resources.get("4").addWorking(workings.get("6"));
		 resources.get("1").addWorking(workings.get("7"));
		 resources.get("3").addWorking(workings.get("8"));
		 resources.get("4").addWorking(workings.get("9"));
		 resources.get("3").addWorking(workings.get("10"));
		 resources.get("4").addWorking(workings.get("11"));
		 resources.get("1").addWorking(workings.get("12"));
		 resources.get("4").addWorking(workings.get("13"));
		 resources.get("1").addWorking(workings.get("14"));
		 resources.get("1").addWorking(workings.get("15"));
		 resources.get("4").addWorking(workings.get("16"));
		 resources.get("3").addWorking(workings.get("17"));
		 resources.get("3").addWorking(workings.get("18"));
		 resources.get("1").addWorking(workings.get("19"));
		 resources.get("1").addWorking(workings.get("20"));
		 resources.get("4").addWorking(workings.get("21"));

		 //System.out.println( activities);
		 //System.out.println( resources);
		 //System.out.println(workings);
		 //System.out.println(workings);
		 //System.out.println(resources.get("2").getWorkings());
		 projet.addAllActivities(activities.values());
		 System.out.println(projet.getActivities());

		
	}

}

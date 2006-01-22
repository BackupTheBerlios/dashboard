
package control;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Activity;
import entity.Plannable;
import entity.Project;
import entity.Resource;
import entity.WorkBreakDownElement;
import entity.Working;

public class ParserHandler extends DefaultHandler{
	
	private Project project =  null;
	private Activity activity = null;
	private WorkBreakDownElement wbe = null;
	private Resource resource = null;
	private Working working = null;
	private boolean inName = false;
	private boolean inAmount = false;
	private boolean inDateDebutEff = false;
	private boolean inDateFinEff = false;
	private String baliseNiveauCourant = null;
	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private Plannable plannable = null;
	

	
 
   
   // simple constructeur
   public ParserHandler(){
      super();	
      
   }
   //methode SAX de
   //d�tection de l'�v�nement "ouverture de balise"
   public void startElement(String uri,
                         String localName,
                         String qName,
                         Attributes attributes)
                  throws SAXException{
      System.out.println(uri+" "+localName+" "+qName);
      
      if(qName.equals("project")){
    	  baliseNiveauCourant = qName;
    	  try{
           	String id = attributes.getValue("id");
           	if(id == null )
           		throw new Exception("id projet non pr�cis�");
              project = new Project(id);
              plannable = project;
              System.out.println("project id: " + project.getId());
           }catch(Exception e){
           	//attribut manquant
              throw new SAXException(e);
           }
    	  
      }
      else if(qName.equals("activity")){
    	 baliseNiveauCourant = qName; 
         try{
         	String id = attributes.getValue("id");
         	if(id == null )
           		throw new Exception("id activit� non pr�cis�");
            activity = new Activity(id);
            plannable = activity;
         }catch(Exception e){
         	//attribut manquant
            throw new SAXException(e);
         }
         
      }
      else if(qName.equals("workbreakdownelement")){
    	  baliseNiveauCourant = qName;
          try{
          	String id = attributes.getValue("id");
          	System.out.println("wbe id: " + id);
          	if(id == null )
           		throw new Exception("id wbe non pr�cis�");
          	wbe = new WorkBreakDownElement(id);
          	plannable = wbe;
          }catch(Exception e){
          	//attribut manquant
             throw new SAXException(e);
          }
          
      }
      else if(qName.equals("working")){
    	  baliseNiveauCourant = qName;
          try{
          	String id = attributes.getValue("id");
          	if(id == null )
           		throw new Exception("id working non pr�cis�");
          	working = new Working(id);
          }catch(Exception e){
          	//attribut manquant
             throw new SAXException(e);
          }
          
       }
      else if(qName.equals("name")){
         inName = true;	
      }
      else if(qName.equals("amount")){
           inAmount = true;	
       }
      else if(qName.equals("datedebuteff")){
          inDateDebutEff = true;	
      }
      else if(qName.equals("datefineff")){
          inDateFinEff = true;	
      }else if(qName.equals("resources")){
          
      }else if(qName.equals("working-resource")){
    	  try{
            	String id = attributes.getValue("id");
            	if(id == null )
             		throw new Exception("id working non pr�cis�");
            	working.setResource(project.getResource(id));
            }catch(Exception e){
            	//attribut manquant
               throw new SAXException(e);
            }
      }else if(qName.equals("resource")){
    	  baliseNiveauCourant = qName;
          try{
          	String id = attributes.getValue("id");
          	System.out.println("resource id: " + id);
          	if(id == null )
           		throw new Exception("id resource non pr�cis�");
          	resource = new Resource(id);
          }catch(Exception e){
          	//attribut manquant
             throw new SAXException(e);
          }
      }      
      else{
         //erreur, on peut lever une exception
         throw new SAXException("Balise "+qName+" inconnue.");	
      }
   }
   //d�tection fin de balise
   public void endElement(String uri,
                       String localName,
                       String qName)
                throws SAXException{
      if(qName.equals("project")){
      }else if(qName.equals("activity")){
      	 project.addActivity(activity);
      	 activity = null;

      }else if(qName.equals("workbreakdownelement")){
    	 activity.addWorkBreakDownElement(wbe);
         
      }else if(qName.equals("working")){
    	 wbe.addWorking(working);
         
      }else if(qName.equals("resource")){
	
      }else if(qName.equals("working-resource")){
	
      }else if(qName.equals("resources")){
	
      }else if(qName.equals("name")){
         inName = false;	
      }else if(qName.equals("amount")){
         inAmount = false;	
      }else if(qName.equals("datedebuteff")){
          inDateDebutEff = false;	
      }
      else if(qName.equals("datefineff")){
          inDateFinEff = false;	
      }else{
         //erreur, on peut lever une exception
         throw new SAXException("Balise "+qName+" inconnue.");	
      }          	
   }
   //d�tection de caract�res
   public void characters(char[] ch,
                       int start,
                       int length)
                throws SAXException{
      String lecture = (new String(ch,start,length)).trim().replace('_',' ');
      if(inName){
    	 if(baliseNiveauCourant.equals("project")){
    		 project.setName(lecture);	
    	 }else if(baliseNiveauCourant.equals("activity")){
    		 activity.setName(lecture);	
      	 }else if(baliseNiveauCourant.equals("workbreakdownelement")){
    		 wbe.setName(lecture);	
      	 }else if(baliseNiveauCourant.equals("working")){
    		 working.setName(lecture);	
      	 }else if(baliseNiveauCourant.equals("resource")){
    		 resource.setName(lecture);	
    		 project.addResource(resource);
      	 }
      }else if(inAmount){
         working.setWorkAmount(new Double(lecture));	
      }else if(inDateDebutEff){
    	  try {
			plannable.setDateDebutEff(dateFormat.parse(lecture)) ;
			System.out.println(plannable.getDateDebutEff() + " : ");
			
		} catch (ParseException e) {
			throw new SAXException(lecture+": mauvais format de date.");
			
		}	
      }else if(inDateFinEff){
    	  try {
  			plannable.setDateFinEff(dateFormat.parse(lecture)) ;
  			System.out.println(plannable.getDateFinEff() + " : ");
  			
  		} catch (ParseException e) {
  			throw new SAXException(lecture+": mauvais format de date.");
  			
  		}	
      }          	
   }
   //d�but du parsing
   public void startDocument() throws SAXException {
   	  System.out.println("D�but du parsing");
   }
   //fin du parsing
   public void endDocument() throws SAXException {
   	  System.out.println("Fin du parsing");
   	  System.out.println("Resultats du parsing");
   	  for(Activity a : project.getActivities()){
   	     System.out.println(a);
   	  }
   	for(Resource r : project.getResources()){
  	     System.out.println("\t" + r);
  	  }
   }
   
   // test
   public static void main(String[] args){
      try{
         // cr�ation d'une fabrique de parseurs SAX
         SAXParserFactory fabrique = SAXParserFactory.newInstance();
			
         // cr�ation d'un parseur SAX
         SAXParser parseur = fabrique.newSAXParser();
			
         // lecture d'un fichier XML avec un DefaultHandler
         File fichier = new File("./source/control/ExempleSAX.xml");
         DefaultHandler gestionnaire = new ParserHandler();
         parseur.parse(fichier, gestionnaire);
		
      }catch(ParserConfigurationException pce){
         System.out.println("Erreur de configuration du parseur");
         System.out.println("Lors de l'appel � SAXParser.newSAXParser()");
      }catch(SAXException se){
         System.out.println("Erreur de parsing");
         System.out.println("Lors de l'appel � parse()");
         se.printStackTrace();
      }catch(IOException ioe){
         System.out.println("Erreur d'entr�e/sortie");
         System.out.println("Lors de l'appel � parse()");
      }
   }	
}
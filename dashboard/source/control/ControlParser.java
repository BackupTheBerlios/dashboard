
package control;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import view.ViewConsolidation;
import entity.Activity;
import entity.Project;
import entity.Resource;
import entity.WBESet;
import entity.WorkBreakDownElement;
import entity.Working;

public class ControlParser extends DefaultHandler{
	
	
	private ArrayList<Activity> activityHierrarchy = new ArrayList<Activity>();
	
	private static HashMap<String, BaliseType> typeBalise = new  HashMap<String, BaliseType>();
	
	{ 
	      BaliseType tempTypeBalise;
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.PROJECT;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("project",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.ACTIVITY;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("activity",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.WORKBREAKDOWN;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("workbreakdownelement",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.WORKING;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("working",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.NAME;
	      tempTypeBalise.type = ControlParser.TYPE_TEXT;
	      typeBalise.put("name",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.AMOUNT;
	      tempTypeBalise.type = ControlParser.TYPE_TEXT;
	      typeBalise.put("amount",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.START_DATE_REAL;
	      tempTypeBalise.type = ControlParser.TYPE_TEXT;
	      typeBalise.put("datedebuteff",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.END_DATE_REAL;
	      tempTypeBalise.type = ControlParser.TYPE_TEXT;
	      typeBalise.put("datefineff",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.RESOURCE;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("resource",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.DDB;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("PSI-2DB",tempTypeBalise);
	      
	      tempTypeBalise = new BaliseType();
	      tempTypeBalise.intName = ControlParser.WSET;
	      tempTypeBalise.type = ControlParser.TYPE_NODE;
	      typeBalise.put("wbeset",tempTypeBalise);
	}
	
	private WorkBreakDownElement wbe = null;
	public Project project = null;
	private Resource resource = null;
	private Working working = null;
	private WBESet wbeset = null;
	
	private boolean inWorking = false;
	private boolean inWBE = false; 
	private int baliseNiveauCourant = -1;
	private String temp = new String("");
	
	
	public File file;
	static final int PROJECT = 0;
	static final int ACTIVITY = 1;
	static final int WORKBREAKDOWN = 2;
	static final int WORKING = 3;
	static final int NAME = 4;
	static final int AMOUNT = 5;
	static final int START_DATE_REAL = 6;
	static final int END_DATE_REAL = 7;
	static final int RESOURCE = 8;
	static final int DDB = 9;
	static final int WSET = 10;
	
	static final int TYPE_TEXT = 0;
	static final int TYPE_NODE = 1;
	
	public class BaliseType{
		public int intName;
		public int type;
		public Object lastValue;
		
		
	}

	
	

	
   
   // simple constructeur
   public ControlParser(Project p){
      super();	
      /// temporaire normalement projet à importer
      project  = p;
      activityHierrarchy.add(0, project);

  
      
   }
   
   public void setFileWithFileSystem(){
	   file = ControlParser.loadSystemFile();
   }
    
   public static File loadSystemFile(){
	   try{
		   JFileChooser selecteur = new JFileChooser(); 
		   Filters filtre = new Filters();
		   selecteur.addChoosableFileFilter(filtre);
		   selecteur.setAcceptAllFileFilterUsed(false);
		   if(selecteur.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) { 
			   return selecteur.getSelectedFile(); 
		   }
	   
	   	}
	   	catch(Exception e){
	   		return null;
	   	}
	   	return null;
   }

   //methode SAX de
   //détection de l'événement "ouverture de balise"
   public void startElement(String uri,
                         String localName,
                         String qName,
                         Attributes attributes)
                  throws SAXException{
	   
	   	  String id = null;
	   try{
		   switch(typeBalise.get(qName).intName){
    	  
		   		case PROJECT:
		   			 id = attributes.getValue("id");
           	
		   			if(id == null )
		   				throw new Exception("id projet non précisé");
           	
		   			if(activityHierrarchy.size() != 1)
		   				throw new Exception("Erreur dans la hierrarchy");
		   			
		   			if(activityHierrarchy.get(0).getId() != null){
		   				if(! (activityHierrarchy.get(0).getId().equals(id)))
		   					throw new Exception("le fichier ne crorrespond pas au projet");
		   			}
		   			else{
		   				activityHierrarchy.get(0).setId(id);
		   			}
		   			break;
		   			
		   		case ACTIVITY:
    	  
		   			Activity activity = null;

		   			id = attributes.getValue("id");
		   			if(id == null )
		   				throw new Exception("id activité non précisé");
		   			
		   			for(Activity act : activityHierrarchy.get(0).getSubActivities()){
		   				if(act != null && act.getId().equals(id)){
		   					activity = act; 
		   					break;
		   				}
		   			}
		   			if(activity == null){
		   				activity = new Activity();
		   				activity.setId(id);
		   				activityHierrarchy.get(0).getSubActivities().add(activity);
		   			}
            
		   			
		   			activityHierrarchy.add(0,activity);
		   			
		   			break;
		   			
		   		case WORKBREAKDOWN:
		   			inWBE = true;
		   			id = attributes.getValue("id");
		   			if(id == null )
		   				throw new Exception("id wbe non précisé");
		   			for(WorkBreakDownElement w : activityHierrarchy.get(0).getWbes()){
		   				if(w != null && w.getId().equals(id)){
		   					wbe = w; 
		   					break;
		   				}
		   			}
		   			if(wbe == null){
		   				wbe = new WorkBreakDownElement();
			   			wbe.setId(id);
			   			activityHierrarchy.get(0).getWbes().add(wbe);
		   			}
            
		   			
		   			
		   			
		   			break;
		   			
		   		case WORKING:
		   			
		   			inWorking = true;
		   			for(Working w : wbe.getWorkings()){
		   				if(w != null && w.getId().equals(id)){
		   					working = w; 
		   					break;
		   				}
		   			}
		   			if(working == null){
		   				working = new Working(id);
			   			wbe.getWorkings().add(working);
		   			}

		   		
		   			break;
		   			
		   		case RESOURCE:
	            	id = attributes.getValue("id");
	            	if(id == null )
	             		throw new Exception("id working non précisé");
	            	if(inWorking){
	            		working.setResource(project.findResourceById(id));
	            	}
	            	else{
	            		
	            		try {
							resource = project.findResourceById(id);
						} catch (Exception e) {
							resource = new Resource(id);
				   			project.getResources().add(resource);
						}

	            			
	            	}
	            	
	            	break;
	            	
		   		case WSET:
		   			id = attributes.getValue("id");
	            	if(id == null )
	             		throw new Exception("id wbeset non précisé");
	            	if(inWBE){
	            		wbeset = project.findWbeSetById(id);
	            		if(wbe != null) {
	            			wbeset.getWorkBreakDowElements().add(wbe);
	            		}
	            		
	            	}
	            	else{
	            		
	            		try {
	            			wbeset = project.findWbeSetById(id);
						} catch (Exception e) {
							wbeset = new WBESet(id);
				   			project.getWbeSets().add(wbeset);
						}

	            			
	            	}
	            	
	            	break;
		   		default:
		   			
		   			break;
		   }
		   
		   switch(typeBalise.get(qName).type){
		   		case TYPE_NODE:
		   			baliseNiveauCourant = typeBalise.get(qName).intName;
		   			break;
		   		default:
		   			break;
		   }
   	  }
	  catch(Exception e){
		 e.printStackTrace();
		  throw new SAXException("erreur dans ouverture de balise");
	   }


   }
   //détection fin de balise
   public void endElement(String uri,
                       String localName,
                       String qName)
                throws SAXException{
	   try{
		   switch(typeBalise.get(qName).intName){
		   		case PROJECT:
		   		case ACTIVITY:
		   			activityHierrarchy.remove(0);	   			
		   			break;
		   		case WORKBREAKDOWN:
		   			inWBE = false;
		   			wbe = null;
		   			break;
		   		case WORKING:
		   			inWorking = false;
		   			working = null;
		   			break;
		   		case NAME:
		   			switch(baliseNiveauCourant){
		   				case PROJECT:
		   				case ACTIVITY:
		   					activityHierrarchy.get(0).setName(temp);
		   					break;
		   				case WORKBREAKDOWN:
		   					wbe.setName(temp);
		   					break;
		   				case RESOURCE:
		   					resource.setName(temp);
		   					break;
		   				
		   				case WSET:
		   					wbeset.setName(temp);
		   					break;
		   				default:
		   					break;		   				
		   			}
		   			break;
		   		case AMOUNT:
		   			working.setWorkAmount(new Double(temp));	
		   			break;
		   			
		   		case START_DATE_REAL:
		   			try {
					wbe.setRealStartDate(Utils.stringToDate(temp));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   			break;
		   			
		   		case END_DATE_REAL:
		   			try {
					wbe.setRealEndDate(Utils.stringToDate(temp));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   			break;
		   			
		   		case RESOURCE:
		   			resource = null;
		   			break;
		   			
		   		case WSET:
		   			wbeset = null;
		   			break;
		   			
		   		default:
		   			break;
		   }
		   temp = "";
	   }catch(Exception e){
		   throw new SAXException();
	   }
    
   }
   
   //détection de caractères
   public void characters(char[] ch,
                       int start,
                       int length)
                throws SAXException{
	   		 if(temp.length() != 0) temp += " ";
	   		 temp += new String(ch,start,length).trim();
	   	
    	
   }
   //début du parsing
   public void startDocument() throws SAXException {
   }
   //fin du parsing
   
   public void endDocument() throws SAXException {
   }
   
   public void parse() throws ParserConfigurationException, SAXException, IOException{
	   // création d'une fabrique de parseurs SAX
       SAXParserFactory fabrique = SAXParserFactory.newInstance();
			
       // création d'un parseur SAX
       SAXParser parseur = null;
       parseur = fabrique.newSAXParser();
      if(this.getFile() == null)
    	  this.setFileWithFileSystem();
       parseur.parse(this.getFile(), this);

   }
   
   // test
   public static void main(String[] args){
      try{
         
         ControlParser cp = new ControlParser(examples.TestEntity.createPSITestProject());
         cp.parse();
         ControlConsolidation conso = new ControlConsolidation(cp.project);
         new ViewConsolidation(conso);
		
      }catch(ParserConfigurationException pce){
         System.out.println("Erreur de configuration du parseur");
         System.out.println("Lors de l'appel à SAXParser.newSAXParser()");
      }catch(SAXException se){
         System.out.println("Erreur de parsing");
         System.out.println("Lors de l'appel à parse()");
         se.printStackTrace();
      }catch(IOException ioe){
         System.out.println("Erreur d'entrée/sortie");
         System.out.println("Lors de l'appel à parse()");
      }
   }

public File getFile() {
	return file;
}

public static class Filters extends FileFilter{
	Vector<String> filters = new Vector<String>();
	{
		filters.add("xml");
	}
	
	public boolean accept(File f) {

	     if(f != null){
			   if(f.isDirectory()){
			      return true;
			   }

			   String extension = getExtension(f);
			   if(extension != null && filters.contains(getExtension(f)) ){
		          return true;
			   };
		 }
		 return false;
	}

	public String getDescription() {
		  String fullDescription = "";

		
		  // Construit la description a partir des extentions.

		  if(filters.size() != 0){
			  fullDescription += "(";
			     int i = 0;
			     for(String e:filters){
			    	  if(i != 0){
			    		  fullDescription += ", " ;
			    	  }
		              fullDescription += "." + e;
		              i++;
			     }
               fullDescription += ")";
		  }

		  return fullDescription;
	}
	public String getExtension(File f)
	{
	   if(f != null)
	  {
	          String filename = f.getName();
	          int i = filename.lastIndexOf('.');
	          if(i>0 && i<filename.length()-1)
	          {
	                return filename.substring(i+1).toLowerCase();
	          };
	         }
	         return null;
	     }
	   
   }
}
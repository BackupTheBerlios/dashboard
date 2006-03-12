
package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import utils.Functions;

import entity.Activity;
import entity.Project;
import entity.Resource;
import entity.WBESet;
import entity.WorkBreakDownElement;
import entity.Working;

public class ControlParser extends DefaultHandler{
	
	public static class ParsePSIException extends SAXException{

		public ParsePSIException(String msg) {
			super(msg);
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
	private ArrayList<Activity> activityHierrarchy = new ArrayList<Activity>();
	private ArrayList<BaliseType> BaliseNodeHierrarchy = new ArrayList<BaliseType>();
	
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
		tempTypeBalise.intName = ControlParser.WORKING_AMOUNT;
		tempTypeBalise.type = ControlParser.TYPE_TEXT;
		typeBalise.put("amount",tempTypeBalise);
		
		
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
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.START_DATE_REAL;
		tempTypeBalise.type = ControlParser.TYPE_DATE;
		typeBalise.put("realstartdate",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.END_DATE_REAL;
		tempTypeBalise.type = ControlParser.TYPE_DATE;
		typeBalise.put("realenddate",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.START_DATE_PREVISION;
		tempTypeBalise.type = ControlParser.TYPE_DATE;
		typeBalise.put("prevstartdate",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.END_DATE_PREVISION;
		tempTypeBalise.type = ControlParser.TYPE_DATE;
		typeBalise.put("prevenddate",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.WBE_AMOUNT_REAL;
		tempTypeBalise.type = ControlParser.TYPE_TEXT;
		typeBalise.put("realamount",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.WBE_AMOUNT_PREVISION;
		tempTypeBalise.type = ControlParser.TYPE_TEXT;
		typeBalise.put("prevamount",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.PROJECT_BUDGET_PREVISION;
		tempTypeBalise.type = ControlParser.TYPE_TEXT;
		typeBalise.put("prevbudget",tempTypeBalise);
		
		tempTypeBalise = new BaliseType();
		tempTypeBalise.intName = ControlParser.PROJECT_BUDGET_REAL;
		tempTypeBalise.type = ControlParser.TYPE_TEXT;
		typeBalise.put("realbudget",tempTypeBalise);
	}
	
	private WorkBreakDownElement wbe = null;
	public Project project = null;
	private Resource resource = null;
	private Working working = null;
	private WBESet wbeset = null;
	private Date date = null; 
	
	private boolean inWorking = false;
	private boolean inWBE = false; 
	
	private String temp = new String("");
	
	
	public File file;
	static final int PROJECT = 0;
	static final int ACTIVITY = 1;
	static final int WORKBREAKDOWN = 2;
	static final int WORKING = 3;
	static final int NAME = 4;
	static final int WORKING_AMOUNT = 5;
	static final int RESOURCE = 6;
	static final int DDB = 7;
	static final int WSET = 8;
	static final int START_DATE_REAL = 9;
	static final int START_DATE_PREVISION = 10;
	static final int END_DATE_REAL = 11;
	static final int END_DATE_PREVISION = 12;
	static final int WBE_AMOUNT_REAL = 13;
	static final int WBE_AMOUNT_PREVISION = 14;
	static final int PROJECT_BUDGET_PREVISION = 15;
	static final int PROJECT_BUDGET_REAL = 16;
	
	static final int TYPE_TEXT = 0;
	static final int TYPE_NODE = 1;
	static final int TYPE_DATE = 3;
	
	public class BaliseType{
		public int intName;
		public int type;
		public Object lastValue;
		
		
	}
	
	
	
	
	
	
	// simple constructeur
	public ControlParser(Project p) throws SAXException, Exception{
		super();	
		/// temporaire normalement projet à importer
		project  = p;
		if(project == null)
			project = new Project();
		activityHierrarchy.add(0, project);

			this.parse();

		
		
		
	}
	
	public void setFileWithFileSystem(){
		file = ControlParser.loadSystemFile();
	}
	
	public static File loadSystemFile(){
		
		JFileChooser selecteur = new JFileChooser(); 
		Filters filtre = new Filters();
		selecteur.addChoosableFileFilter(filtre);
		selecteur.setAcceptAllFileFilterUsed(false);
		
		if(selecteur.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) { 
			return selecteur.getSelectedFile(); 
		}
		return null;
		
	}
	

<<<<<<< ControlParser.java
	
   
   // simple constructeur
   public ControlParser(Project p) throws ParserConfigurationException, SAXException, IOException{
      super();	
      /// temporaire normalement projet à importer
      project  = p;
      if(project == null)
    	  project = new Project();
      activityHierrarchy.add(0, project);
      this.parse();

  
      
   }
   
   public void setFileWithFileSystem(){
	   file = ControlParser.loadSystemFile();
   }
    
   public static File loadSystemFile(){
	   
		   JFileChooser selecteur = new JFileChooser(); 
		   Filters filtre = new Filters();
		   selecteur.addChoosableFileFilter(filtre);
		   selecteur.setAcceptAllFileFilterUsed(false);
		   
		   if(selecteur.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) { 
			   return selecteur.getSelectedFile(); 
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
	   
		   switch(typeBalise.get(qName).intName){
    	  
		   		case PROJECT:
		   			 id = attributes.getValue("id");
           	
		   			if(id == null )
		   				throw new SAXException("id projet non précisé");
           	
		   			if(activityHierrarchy.size() != 1)
		   				throw new SAXException("Erreur dans la hierrarchy");
		   			
		   			if(activityHierrarchy.get(0).getId() != null && !activityHierrarchy.get(0).getId().equals("")){
		   				if(! (activityHierrarchy.get(0).getId().equals(id)))
		   					throw new SAXException("le fichier ne crorrespond pas au projet");
		   			}
		   			else{
		   				activityHierrarchy.get(0).setId(id);
		   			}
		   			break;
		   			
		   		case ACTIVITY:
    	  
		   			Activity activity = null;

		   			id = attributes.getValue("id");
		   			if(id == null )
		   				throw new SAXException("id activité non précisé");
		   			
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
		   				throw new SAXException("id wbe non précisé");
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
		   				if(w != null && w.getId() != null && w.getId().equals(id)){
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
	             		throw new SAXException("id working non précisé");
	            	if(inWorking){
	            		try {
							working.setResource(project.findResourceById(id));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
	             		throw new SAXException("id wbeset non précisé");
	            	if(inWBE){
	            		try {
							wbeset = project.findWbeSetById(id);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
   //détection fin de balise
   public void endElement(String uri,
                       String localName,
                       String qName)
                throws SAXException{

		   switch(typeBalise.get(qName).type){
		   
		   	case TYPE_DATE:
		   		date = null;
		   		try {
					date = Functions.stringToDate(temp);
				} catch (ParseException e) {
=======
	//methode SAX de
	//détection de l'événement "ouverture de balise"
	public void startElement(String uri,
			String localName,
			String qName,
			Attributes attributes)
	throws SAXException{
		
		try{
			String id = null;
			
			switch(typeBalise.get(qName).intName){
			
			case PROJECT:
				id = attributes.getValue("id");
				
				if(id == null )
					throw new SAXException("id projet non précisé");
				
				if(activityHierrarchy.size() != 1)
					throw new SAXException("Erreur dans la hierrarchy");
				
				if(activityHierrarchy.get(0).getId() != null && !activityHierrarchy.get(0).getId().equals("")){
					if(! (activityHierrarchy.get(0).getId().equals(id)))
						throw new SAXException("le fichier ne crorrespond pas au projet");
				}
				else{
					activityHierrarchy.get(0).setId(id);
				}
				break;
				
			case ACTIVITY:
				
				Activity activity = null;
				
				id = attributes.getValue("id");
				if(id == null )
					throw new SAXException("id activité non précisé");
				
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
					throw new SAXException("id wbe non précisé");
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
					if(w != null && w.getId() != null && w.getId().equals(id)){
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
					throw new SAXException("id working non précisé");
				if(inWorking){
					try {
						working.setResource(project.findResourceById(id));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					throw new SAXException("id wbeset non précisé");
				if(inWBE){
					try {
						wbeset = project.findWbeSetById(id);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				this.BaliseNodeHierrarchy.add(0,typeBalise.get(qName));
				break;
			default:
				break;
			}
		}
		catch(Exception e){
			String msg = "erreur à l'ouverture d'une balise : " + qName +"\n"+e.getMessage();
			throw new ParsePSIException(msg);
			
			
		}
		
		
	}
	//détection fin de balise
	public void endElement(String uri,
			String localName,
			String qName)
	throws SAXException{
		try{
			
			switch(typeBalise.get(qName).type){
			
			case TYPE_DATE:
				date = null;
				try {

					date = Utils.stringToDate(temp);
				} catch (Exception e) {
>>>>>>> 1.10
					date = null;
					//e.printStackTrace();
				}
				break;
			case TYPE_NODE:
				BaliseNodeHierrarchy.remove(0);
			default:
				break;
			
			
			}
			
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
				switch(this.BaliseNodeHierrarchy.get(0).intName){
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
			case WORKING_AMOUNT:
				working.setWorkAmount(new Double(temp));	
				break;
				
			case START_DATE_REAL:
				if(date != null)wbe.setRealStartDate(date);
				break;
				
			case END_DATE_REAL:
				if(date != null)wbe.setRealEndDate(date);
				break;
				
			case START_DATE_PREVISION:
				if(date != null)wbe.setPrevStartDate(date);
				break;
				
			case END_DATE_PREVISION:
				if(date != null)wbe.setPrevEndDate(date);
				break;
				
			case WBE_AMOUNT_REAL:
				wbe.setRealWorkAmount(new Double(temp));
				break;
				
			case WBE_AMOUNT_PREVISION:
				wbe.setPrevWorkAmount(new Double(temp));
				
				break;
				
			case PROJECT_BUDGET_PREVISION:
				project.setPrevBudget(new Double(temp));
				
				break;
				
			case PROJECT_BUDGET_REAL:
				project.setRealBudget(new Double(temp));
				
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
			
		}
		catch(Exception e){
			String msg = "erreur à la fermeture d'une balise : " + qName +"\n"+e.getMessage();
			throw new ParsePSIException(msg);
			
			
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
	
	
	public void parse() throws Exception{
		
		try{
			// création d'une fabrique de parseurs SAX
			SAXParserFactory fabrique = SAXParserFactory.newInstance();
			
			// création d'un parseur SAX
			SAXParser parseur = null;
			parseur = fabrique.newSAXParser();
			if(this.getFile() == null)
				this.setFileWithFileSystem();
			if(this.getFile() != null){

				
				
				
					parseur.parse(this.getFile(), this);
					if(this.project != null){
						this.project.setProgress(this.project.getProgress() + 1) ;
					}
				
				
				
			
				
			}
		}

		catch(ParsePSIException e){

			JOptionPane.showMessageDialog(new JFrame(),e.getMessage() ,"erreur de parsage",JOptionPane.ERROR_MESSAGE);
			throw e;
					
		}
		
		catch(Exception e){

			JOptionPane.showMessageDialog(new JFrame(),"erreur de parsage:\n" ,"erreur de parsage",JOptionPane.ERROR_MESSAGE);
			throw e;
					
		}
		
		
	}
	
	// test
	public static void main(String[] args){
		try{
			
			ControlParser cp = new ControlParser(new Project());
			
			System.out.println("\nreel " + cp.project.getRealBudget() );
			System.out.println("\nestimé " + cp.project.getPrevBudget() );   
			for(Activity a : cp.project.getSubActivities()){
				System.out.println("\n\tactivity  : " + a.getName() +  " : "  + a.getId());
				for(WorkBreakDownElement w : a.getWbes()){
					System.out.println("\n\t\twbe : " + w.getName() +  " : "  + w.getId());
					
					System.out.println("\n\t\t\tprev start date : " + w.getPrevStartDate());
					System.out.println("\n\t\t\tprev end  date  : " + w.getPrevEndDate());        		 
					System.out.println("\n\t\t\treal start date : " + w.getRealStartDate());
					System.out.println("\n\t\t\treal end date   : " + w.getRealEndDate());
					System.out.println("\n\t\t\tprev amount     : " + w.getPrevWorkAmount());
					System.out.println("\n\t\t\treal amount     : " + w.getRealWorkAmount());
				}
				
				
			}
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
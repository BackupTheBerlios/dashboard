package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;


public class ViewHelp extends JFrame implements HyperlinkListener
{
	
	  // Composant Swing permettant de visualiser un document
	  JEditorPane viewer       = new JEditorPane ();
	  private ArrayList<String> docsHTML;
	  private int pageActuel;
	  private int nbPageEnMemoire;
	  private javax.swing.JButton bPrecedent;
	  private javax.swing.JButton bSuivant;
	  private javax.swing.JButton bHome;
	  //	 Zone scrollée au centre avec le document    
	  private JScrollPane scrollPane = new JScrollPane (viewer);
	  private Container container;
	  private JToolBar BarredeNavigation;
	  
	public ViewHelp(String docHTML){
		super("Aide 2DB");


		container = this.getContentPane() ;
		container.setLayout(new BorderLayout());
		
		docsHTML=new ArrayList<String>();
		pageActuel=0;
		docsHTML.add(pageActuel,docHTML);
		nbPageEnMemoire=1;
		
		loadPage(docHTML);
		init();
		
		container.add (BarredeNavigation, BorderLayout.NORTH);
	    container.add (scrollPane, BorderLayout.CENTER);
	    // Mode non editable pour recevoir les clics sur les 
	    // liens hypertexte
	    viewer.setEditable (false);
	    // Ajout du listener de clic sur lien
	    viewer.addHyperlinkListener (this);
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(500,500) ;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);
	} 
	 
	private void init()
	{		
			BarredeNavigation = new JToolBar();
	    	bPrecedent = new javax.swing.JButton("Précédent");
		    bSuivant = new javax.swing.JButton("Suivant");
		    bHome = new javax.swing.JButton("Home");
		    
		    bPrecedent.setEnabled(false);
		    bSuivant.setEnabled(false);
		    BarredeNavigation.add(bPrecedent);
		    BarredeNavigation.add(bSuivant);
		    BarredeNavigation.addSeparator();
		    BarredeNavigation.add(bHome);
		    
		    bPrecedent.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                bPrecedentMouseClicked();
	            }
	        });
		    bSuivant.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                bSuivantMouseClicked();
	            }
	        });
		    bHome.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                bHomeMouseClicked();
	            }
	        });
	}
	
	private void bPrecedentMouseClicked(){
		if (pageActuel>0){
			pageActuel-=1;
			loadPage(docsHTML.get(pageActuel));
			bSuivant.setEnabled(true);
			if (pageActuel==0)
			{
				bPrecedent.setEnabled(false);
			}
			}		
		
	}
	
	private void bSuivantMouseClicked(){
		if (pageActuel<nbPageEnMemoire-1){
			pageActuel+=1;
			loadPage(docsHTML.get(pageActuel));
			bPrecedent.setEnabled(true);
			if (pageActuel==nbPageEnMemoire-1)
				{
				bSuivant.setEnabled(false);
				}
			}
		
	}
	
	private void bHomeMouseClicked(){
		if (docsHTML.get(0)!=docsHTML.get(pageActuel)){
		pageActuel+=1;
		docsHTML.add(pageActuel,docsHTML.get(0));
		nbPageEnMemoire+=1;		}
		loadPage(docsHTML.get(pageActuel));
	}
	
	  // Méthode appelée après un clic sur un lien hyper texte
	  public void hyperlinkUpdate (HyperlinkEvent event) 
	  {
	    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
	    {
	      // Modification de l'url courant
	    	pageActuel+=1;
			docsHTML.add(pageActuel,event.getURL ().toString ());
			nbPageEnMemoire+=1;
			bPrecedent.setEnabled(true);
	      if (event instanceof HTMLFrameHyperlinkEvent) 
	      {
	        // Evenement spécial en cas d'utilisation de Frame HTML
	        HTMLDocument doc = (HTMLDocument)viewer.getDocument ();
	        doc.processHTMLFrameHyperlinkEvent (
	                       (HTMLFrameHyperlinkEvent)event);
	      }
	      else
	        // Chargement de la page
	        loadPage (docsHTML.get(pageActuel));
	    }
	  }
	  
	  public void loadPage (String urlText)
	  {
	    try 
	    {
	      // Modification du document visualise
	      viewer.setPage (new URL (urlText));
	    } 
	    catch (IOException ex) 
	    {
	      System.err.println ("Acces impossible a " + urlText);
	    }
	  }
	
	  

	  public static void main (String [] args)
	  {
	    JFrame viewerFrame = new ViewHelp ("http://www.loc.gov/rr/international/portals.html");
	    //viewerFrame.setSize (400, 300);
	    viewerFrame.setVisible(true);
	  }
				
}

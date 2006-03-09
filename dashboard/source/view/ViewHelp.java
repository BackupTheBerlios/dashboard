package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;


public class ViewHelp extends JFrame implements HyperlinkListener
{
	private HTMLDocument docHtml;
	public ViewHelp(String docHTML){
		super("Aide 2DB");
		loadPage(docHTML);
		 // Construction de l'Interface Graphique

	    // Zone scrollée au centre avec le document    
	    JScrollPane scrollPane = new JScrollPane (viewer);
	    // Ajout des composants à la fenêtre
	    getContentPane ().add (scrollPane, BorderLayout.CENTER);
	    
	    // Mode non editable pour recevoir les clics sur les 
	    // liens hypertexte
	    viewer.setEditable (false);
	    // Ajout du listener de clic sur lien
	    viewer.addHyperlinkListener (this);
	}
		
//	 Classe de fenêtre Swing permettant de visualiser un
//	 document (HTML ou texte)
	  // Composant Swing permettant de visualiser un document
	  JEditorPane viewer       = new JEditorPane ();
	  // Champ de saisie de l'URL à visualiser
	  JTextField  urlTextField = new JTextField ();
	 
	 
	 
	  // Méthode appelée après un clic sur un lien hyper texte
	  public void hyperlinkUpdate (HyperlinkEvent event) 
	  {
	    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
	    {
	      // Modification du champ de saisie
	      urlTextField.setText (event.getURL ().toString ());
	      if (event instanceof HTMLFrameHyperlinkEvent) 
	      {
	        // Evenement spécial en cas d'utilisation de Frame HTML
	        HTMLDocument doc = (HTMLDocument)viewer.getDocument ();
	        doc.processHTMLFrameHyperlinkEvent (
	                       (HTMLFrameHyperlinkEvent)event);
	      }
	      else
	        // Chargement de la page
	        loadPage (urlTextField.getText ());
	    }
	  }
	 /*
	  // Méthode appelée après une modification de la saisie
	  public void actionPerformed (ActionEvent event)
	  {
	    loadPage (urlTextField.getText ());
	  }
	   */     
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
	    JFrame viewerFrame = new ViewHelp ("http://www.eteks.com/tips/tip5.html");
	    viewerFrame.setSize (400, 300);
	    viewerFrame.setVisible(true);
	  }
				
}

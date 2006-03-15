package examples;

// import 
import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * Classe ouvrant une JFrame contenant le JPanel passé en paramètre du 
 * constructeur et placé aux coordonnées précisées.
 * @author Johann Heymes
 */
public class EnteteJTable extends JFrame
{    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * onstructeur de cette classe de démonstration
	 * @param titre le titre de la JFrame a creer
	 */
    public EnteteJTable (String titre, JComponent panel, int x, int y)
    {	
		super (titre);

		this.getContentPane ().add (panel);
    	this.setLocation (x, y);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.pack ();
		this.setVisible (true);
    }
    
    
	/**
	 * Methode main :
	 *		Cree une instance avec une JTable sans les entêtes puis
	 * 	
	 */
    public static void main (String argv [])
    {
		// Label des colonnes pour les JTables
		String [] columns = {"Sandwich", "Disponible", "Prix"};

		// Données utilisées pour les JTables
		Object [][] data = { 
			{ "Jambon",  "sqfsdgdshdh  ghdqrdh dhshfhfghgfhfg hdshgfhgfhsf shgfhsgfhs \nshhsfhfgh gfjsfjfgjfgj gjnjdjgfjgfdjn ", new Float (4.99) },
			{ "Grillade", new Boolean (true), new Float (5.99) },
			{ "Dinde", new Boolean (false), new Float (4.99) },
			{ "Cresson", new Boolean (true), new Float (4.99) },
		};

		// une solution possible pour afficher les entetes de la JTable sans etre 
		// dans un JScrollPane
		JTable jt = new JTable (data, columns);
		TableColumnModel tcm = jt.getColumnModel();
		TableColumn tc = tcm.getColumn(1);
		ColorRenderer cr = new ColorRenderer();
		tc.setCellRenderer(cr);
		JPanel tableau = new JPanel (new BorderLayout ());
		// ajoute les entetes au nord du conteneur
		tableau.add (jt.getTableHeader (), BorderLayout.NORTH);
		tableau.add (jt, BorderLayout.CENTER);
		JScrollPane split2 = new JScrollPane (tableau);
		new EnteteJTable ("avec ent\u00EAte", split2, 400, 150);
	
    }
}
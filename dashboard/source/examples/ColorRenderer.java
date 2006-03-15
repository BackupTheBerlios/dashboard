package examples;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class ColorRenderer implements TableCellRenderer {
	private JTextArea composant= new JTextArea();
	public ColorRenderer()
	{
		composant.setEditable(false);
	}
	/**
	* La méthode de construction d’un composant
	* i.e. le travail d'un renderer (factory).
	* Elle retourne un Component qui est l’affichage de la cellule
	* Ici c’est un JLabel avec la couleur appropriee.
	*/
	public Component getTableCellRendererComponent(JTable t,
	Object value, boolean selected, boolean focussed, int r, int c) {
		composant.setText("3");
		return composant;
	}
}
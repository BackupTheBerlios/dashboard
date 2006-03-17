package examples;


import	java.awt.*;
import	java.awt.event.*;

import	javax.swing.*;
import	javax.swing.text.*;
import	javax.swing.event.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import utils.Pair;

import control.ControlProject;

import entity.Activity;
import entity.Plannable;
import entity.Project;

import java.text.NumberFormat;
import	java.util.*;
//import	java.lang.*;



//-----------------------------------------
//	Déclaration de la classe
//-----------------------------------------
public	class	testJTable	extends JFrame
{
	public class CustomTableCellRenderer extends DefaultTableCellRenderer 
	{
	    public Component getTableCellRendererComponent
	       (JTable table, Object value, boolean isSelected,
	       boolean hasFocus, int row, int column) 
	    {
	        Component cell = super.getTableCellRendererComponent
	           (table, value, isSelected, hasFocus, row, column);
	 
	        if( value instanceof Double )
	        {
	        	 Double  amount = ( Double ) value;
	            if( amount < 0 )
	            {
	                cell.setBackground( Color.red );
	                // You can also customize the Font and Foreground this way
	                // cell.setForeground();
	                // cell.setFont();
	            }
	            else
	            {
	                cell.setBackground( Color.white );
	            }
	        }
	 
	        return cell;
	 
	    }
	}
	
	private JTable		jTable ;
	private JScrollPane	jSPane;
	


	
	public testJTable()
	{
		this.setSize(750,600);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		this.setLayout(new BorderLayout(700,700));
		afficheTable1();
		jSPane = new JScrollPane(jTable);	
		jSPane.setSize(640,640);
		panel.add(jSPane, BorderLayout.CENTER);
		this.add(panel, BorderLayout.CENTER);
			

		
		this.setVisible(true);
	}

	//-----------------------------------------------------------------------
	//	La partie éxécutant du code doit se trouver hors de la définition
	//	de la classe
	//-----------------------------------------------------------------------
	public static void main (String args[])
	{
		testJTable truc = new testJTable();
	}
	
		
	public void afficheTable1()
	{
		Vector<String>	nomDesColonnes	= new Vector<String>();
		nomDesColonnes.addElement("nom");
		nomDesColonnes.addElement("prev");
		nomDesColonnes.addElement("real");
		nomDesColonnes.addElement("%");
		Vector<Vector>	valeurDesChamps	= new Vector<Vector>();
		Vector<Object>	elements	= null;

		

		
		
		Project proj = TestEntity.create2DBTestProject();
		ArrayList<Pair<String,Plannable>> activities = proj.getHierrarchyRecursive();

		for(Pair<String,Plannable> activity: activities){
		//	if(activity.getSecond().getPrevWorkAmount() > 0 && (activity.getSecond().getRealWorkAmount() - activity.getSecond().getPrevWorkAmount())/activity.getSecond().getPrevWorkAmount() > 0){
			elements = new Vector<Object>();
			elements.addElement(activity.getFirst());
			elements.addElement(activity.getSecond().getPrevWorkAmount());
			elements.addElement(activity.getSecond().getRealWorkAmount());

			//elements.addElement(NumberFormat.getPercentInstance().format((activity.getSecond().getRealWorkAmount() - activity.getSecond().getPrevWorkAmount())/activity.getSecond().getRealWorkAmount()));
			elements.addElement((activity.getSecond().getRealWorkAmount() - activity.getSecond().getPrevWorkAmount())/activity.getSecond().getPrevWorkAmount());
			
			valeurDesChamps.addElement(elements);
		//	}
			
		}
		this.jTable		= new JTable(valeurDesChamps,nomDesColonnes);

		DefaultTableCellRenderer custom = new CustomTableCellRenderer();
		custom.setHorizontalAlignment(JLabel.CENTER); 
		custom.setBackground(Color.BLUE);
		this.jTable.getColumnModel().getColumn(1).setCellRenderer(custom);
		this.jTable.getColumnModel().getColumn(1).setMaxWidth(70);

		this.jTable.getColumnModel().getColumn(2).setCellRenderer(custom);
		this.jTable.getColumnModel().getColumn(2).setMaxWidth(70);
		
		this.jTable.getColumnModel().getColumn(3).setCellRenderer(custom);
		this.jTable.getColumnModel().getColumn(3).setMaxWidth(70);
		
		this.jTable.getColumnModel().getColumn(0).setMaxWidth(600);
		this.jTable.setEnabled(false);
		

	}
	
	

	
}
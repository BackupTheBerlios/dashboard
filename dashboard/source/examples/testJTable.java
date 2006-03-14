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

import	java.util.*;
//import	java.lang.*;



//-----------------------------------------
//	Déclaration de la classe
//-----------------------------------------
public	class	testJTable	extends JFrame
{
	
	private JTable		jTable ;
	private JScrollPane	jSPane;
	private JPanel panel;


	
	public testJTable()
	{
		this.setSize(750,600);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		afficheTable1();
		this.jSPane	= new JScrollPane(this.jTable);
		this.add(this.jSPane, BorderLayout.CENTER);


		
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
		nomDesColonnes.addElement("valeur");
		Vector<Vector>	valeurDesChamps	= new Vector<Vector>();
		Vector<Object>	elements	= null;

		

		
		
		Project proj = TestEntity.create2DBTestProject();
		ArrayList<Pair<String,Plannable>> activities = proj.getHierrarchyRecursive();
		
		for(Pair<String,Plannable> activity: activities){
			elements = new Vector<Object>();
			elements.addElement(activity.getFirst());
			elements.addElement(activity.getSecond().getRealWorkAmount());
			valeurDesChamps.addElement(elements);
			
		}
		this.jTable		= new JTable(valeurDesChamps,nomDesColonnes);
		
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
		custom.setHorizontalAlignment(JLabel.CENTER); 
		custom.setBackground(Color.BLUE);
		this.jTable.getColumnModel().getColumn(1).setCellRenderer(custom);
		this.jTable.getColumnModel().getColumn(1).setMaxWidth(70);
		this.jTable.getColumnModel().getColumn(0).setMaxWidth(800);
		this.jTable.setEnabled(false);
		

	}
	
	

	
}
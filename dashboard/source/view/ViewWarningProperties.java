package view;

import control.ControlPlannable;
import control.Utils;
import entity.WorkBreakDownElement;
import entity.WarningLimit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


import javax.swing.*;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ViewWarningProperties extends JDialog{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField field1;
	private JTextField field2;
	private JButton ok;
	private JButton annuler;
	
	public ViewWarningProperties()
	{
		WarningLimit.setMinLimit(2);
		this.field1 =new JTextField(WarningLimit.getMinLimit());
		this.field2 =new JTextField(WarningLimit.getMaxLimit());
		this.jLabel1=new JLabel("Seuil minimal (en %)");
		this.jLabel1.setPreferredSize(new Dimension (150,150));
		this.jLabel2=new JLabel("Seuil maximal (en %)");
		this.ok=new JButton("OK");
		this.annuler=new JButton("annuler");
		JPanel centre =new JPanel();
		JPanel bas = new JPanel();
		
		this.setTitle("Réglages des seuils d'alerte");
		this.setSize(300,125);
		
		this.setLayout(new BorderLayout());
		
		centre.setLayout(new GridLayout (2,2));
		centre.add(this.jLabel1);
		
		// jen suis là
		
		this.field2.setSize(3,1);
		centre.add(this.field1);
		centre.add(this.jLabel2);
		centre.add(this.field2);
		
		bas.add(this.ok);
		bas.add(this.annuler);
		this.annuler.addActionListener(new ActionListener ()
				{public void actionPerformed (ActionEvent ev)
					{ViewWarningProperties.this.dispose();}
				});
		 this.ok.addActionListener(new ActionListener ()
	                {
		    			public void actionPerformed (ActionEvent ev)
		    			{	boolean numeric=true;
		    			
		    				for(int i=0;i<ViewWarningProperties.this.field1.getText().length()&&numeric;i++)
		    				{
		    					
		    					numeric=Character.isDigit(ViewWarningProperties.this.field1.getText().charAt(i));
		    				}
		    				for(int i=0;i<ViewWarningProperties.this.field2.getText().length()&&numeric;i++)
		    				{
		    					
		    					numeric=Character.isDigit(ViewWarningProperties.this.field2.getText().charAt(i));
		    				}
		    				if (!numeric ||ViewWarningProperties.this.field2.getText().equals("")||ViewWarningProperties.this.field1.getText().equals(""))
		    				{
		    					JOptionPane.showMessageDialog(ViewWarningProperties.this, "Les seuils saisis sont incorrects",
		    						      "Erreur",
		    						      JOptionPane.WARNING_MESSAGE);
		    				}else{
		    					WarningLimit.setMinLimit(Integer.parseInt(ViewWarningProperties.this.field1.getText()));
		    					WarningLimit.setMaxLimit(Integer.parseInt(ViewWarningProperties.this.field2.getText()));
		    					ViewWarningProperties.this.dispose();
		    				}
		    			}
	                });
		
		
		
		this.add(centre,BorderLayout.CENTER);
		this.add(bas,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public static void main(String args[]) {
		
		ViewWarningProperties v = new ViewWarningProperties();
		
		
	}
	
	}


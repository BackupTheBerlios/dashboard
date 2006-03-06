package view;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import control.ControlProject;
import entity.Project;



public class SubViewActivity extends JFrame{

	private ControlProject cp;
	
	public SubViewActivity(ControlProject cp)
	{
		super("Activités");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1,0,0));
		JLabel labelCombo=new JLabel("Choississez une activité : ");
		Project p=cp.getProject();
		this.cp=cp;
		ArrayList activites=p.getSubActivities();
		Vector v= new Vector();
		for(int i =0 ;i<activites.size();i++)
		{
			v.add(activites.get(i));
		}
		JComboBox Combo= new JComboBox(v);
		JPanel PanelHaut = new JPanel();
		PanelHaut.add(labelCombo);
		PanelHaut.add(Combo);
		this.add(PanelHaut);		
		this.pack();
	}
	
}

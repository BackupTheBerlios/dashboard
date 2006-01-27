package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;

import control.ProjectControl;

/* Cette classe permet d'obtenir une vision globale sur l'avancement du projet
 *  en ayant actuellement 3 principaux indicateurs:	
 *  	avancement par rapport aux estimations
 *  	rapport entre le budget consommé et le temps effectif
 *  	etat du budget en fonction des estimations
 */

public class ProjectView extends javax.swing.JInternalFrame{


	/*
	 * Référence vers le controlleur du projet, afin de récupérer
	 * les indicateurs
	 */
	ProjectControl pc;

	public ProjectView(ProjectControl pc) {
		super();
		// TODO Auto-generated constructor stub
		this.pc = pc;
	}
	
	public class MouseEventclic implements MouseListener {
		
		public void mouseClicked (MouseEvent ev){
	    	
			int j []=ProjectWindow.jTree1.getSelectionRows();
	    	int i=j[0];
	    	if(i==0)
	    	{
	    		String affich = "Avancement du projet :";
	    		affich.concat(pc.getNameP());
	    		
		    	JLabel label = new JLabel(affich);
		    	JPanel jPanel2=new JPanel();
		    	jPanel2.setLayout(new BorderLayout());
		    	label.setMaximumSize(label.getPreferredSize());
		    	jPanel2.add(label,BorderLayout.NORTH);
				JProgressBar Jbar=new JProgressBar(1,99);
				Jbar.setBackground(Color.red);
				Jbar.setValue(((int)Double.doubleToLongBits(pc.getTps())));
				Jbar.setMaximumSize(Jbar.getPreferredSize());
				JPanel jPanel3=new JPanel();
				jPanel3.setLayout(new BorderLayout());
				JPanel jPanel4=new JPanel();
				JLabel label2 = new JLabel("Avancement :");
				jPanel4.add(label2);
				jPanel4.add(Jbar);
				jPanel3.add(jPanel4,BorderLayout.NORTH);
				JProgressBar Jbar2=new JProgressBar();
				Jbar2.setMaximumSize(Jbar2.getPreferredSize());
				Jbar2.setBackground(Color.GREEN);
				Jbar2.setValue(((int)Double.doubleToLongBits(pc.getBudget())));
				JPanel jPanel5=new JPanel();
				JLabel label3 = new JLabel("Budget :");
				jPanel5.add(label3);
				jPanel5.add(Jbar2);
				jPanel3.add(jPanel5,BorderLayout.WEST);
				jPanel2.add(jPanel3,BorderLayout.WEST);
				ProjectWindow.jSplitPane1.add(jPanel2,JSplitPane.RIGHT);
			}
	    	else
	    	{
	    		JPanel jPanel2=new JPanel();
	    		ProjectWindow.jSplitPane1.add(jPanel2,JSplitPane.RIGHT);
	    	}
	    	
	    }

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	

	}

}

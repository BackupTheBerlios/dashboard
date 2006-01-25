package view;

import entity.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.*;
import javax.swing.WindowConstants;
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
public class ProjectWindow extends javax.swing.JInternalFrame 
{
	private Project mProject;
	public static JSplitPane jSplitPane1;
	public static JTree jTree1;
	private JPanel jPanel1;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ProjectWindow inst = new ProjectWindow();
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(inst);
		jdp.setPreferredSize(inst.getPreferredSize());
		frame.setContentPane(jdp);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ProjectWindow() {
		super();
		initGUI();
		updateProjectTree(null);
	}
	
	public ProjectWindow(Project p) {
		super();
		initGUI();
		updateProjectTree(p);
	}
	
	
	private void updateProjectTree(Project p)
	{
		if(p == null)
		{			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Empty") ;
			DefaultTreeModel lModel= new DefaultTreeModel(root);
			jTree1.setModel(lModel);
		}
		else
		{
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project " + p.getName()) ;
			int i;
			java.util.Collection<Activity> lAcs = p.getActivities();
			for(i=0; i<lAcs.size(); i++)
			{
				Activity lAc = (Activity)lAcs.toArray()[i];
				DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode("Activity " + lAc.getName()) ;
				updateActivityNode(lAcNode, lAc);
				root.add(lAcNode);
			}
			DefaultTreeModel lModel= new DefaultTreeModel(root);
			jTree1.setModel(lModel);
		}
		
	}
	
	
private void updateActivityNode(DefaultMutableTreeNode pNode, Activity pAc)
{	
	int i;
	java.util.Collection<Activity> lAcs = pAc.getActivities();
	for(i=0; i<lAcs.size(); i++)
	{
		Activity lAc = (Activity)lAcs.toArray()[i];
		DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode("Activity " + lAc.getName()) ;
		updateActivityNode(lAcNode, lAc);
		pNode.add(lAcNode);
	}
	
	java.util.Collection<WorkBreakDownElement> lWBEs = pAc.getWorkBreakDownElements();
	for(i=0; i<lWBEs.size(); i++)
	{
		WorkBreakDownElement lWBE = (WorkBreakDownElement)lWBEs.toArray()[i];
		DefaultMutableTreeNode lWBENode = new DefaultMutableTreeNode("WBE " + lWBE.getName()) ;
		pNode.add(lWBENode);
	}
	
}



	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 300));
			setBounds(new Rectangle(0, 0, 500, 300));			
			this.setClosable(true);
			this.setMaximizable(true);
			this.setIconifiable(true);
			setVisible(true);
			{
				jSplitPane1 = new JSplitPane();
				getContentPane().add(jSplitPane1, BorderLayout.CENTER);
				{
					jTree1 = new JTree();
					jTree1.addMouseListener (new MouseEventclic ());
					jSplitPane1.add(jTree1, JSplitPane.LEFT);
					jPanel1 = new JPanel();
					jSplitPane1.add(jPanel1, JSplitPane.RIGHT);
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public class MouseEventclic implements MouseListener {
		
	   	public void mousePressed(MouseEvent e) {
	 
	    }

	    public void mouseReleased(MouseEvent e) {
	    
	    }

	    public void mouseEntered(MouseEvent e) {
	    
	    }

	    public void mouseExited(MouseEvent e) {
	      
	    }

	    public void mouseClicked (MouseEvent ev)
	    {
	    	int j []=ProjectWindow.jTree1.getSelectionRows();
	    	int i=j[0];
	    	if(i==0)
	    	{
		    	JLabel label = new JLabel("Voici l'indicateur qui permet de voir le rapport : 25");
		    	JPanel jPanel2=new JPanel();
		    	jPanel2.setLayout(new BorderLayout());
		    	label.setMaximumSize(label.getPreferredSize());
		    	jPanel2.add(label,BorderLayout.NORTH);
				JProgressBar Jbar=new JProgressBar(1,99);
				Jbar.setBackground(Color.red);
				Jbar.setValue(50);
				Jbar.setMaximumSize(Jbar.getPreferredSize());
				JPanel jPanel3=new JPanel();
				jPanel3.setLayout(new BorderLayout());
				JPanel jPanel4=new JPanel();
				JLabel label2 = new JLabel("Voila la barre indiquant l'avancement :");
				jPanel4.add(label2);
				jPanel4.add(Jbar);
				jPanel3.add(jPanel4,BorderLayout.NORTH);
				JProgressBar Jbar2=new JProgressBar();
				Jbar2.setMaximumSize(Jbar2.getPreferredSize());
				Jbar2.setBackground(Color.GREEN);
				Jbar2.setValue(25);
				JPanel jPanel5=new JPanel();
				JLabel label3 = new JLabel("Voila la barre indiquant le budget :");
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
	}
}


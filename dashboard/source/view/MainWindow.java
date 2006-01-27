/*
 * MainWIndow.java
 *
 * Created on 26 janvier 2006, 12:16
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import control.ConsolidationHandler;
import control.EnvironmentControl;
import control.PlannableControl;
import control.ProjectControl;
import entity.Plannable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import entity.Activity;
import entity.Project;
import entity.WorkBreakDownElement;

import test.TestEntity;
/**
 *
 * @author  Oli
 */
public class MainWindow extends javax.swing.JFrame {
    
	private EnvironmentControl envC;
	
    
    
    /** Creates new form MainWindow */
    public MainWindow(EnvironmentControl pEnvC) {
    	envC = pEnvC;
        initComponents();
        updateProjectList();
        updateProjectTree(null);
        
        this.setSize(800,600); 
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 	 
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
        contentPane = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JSplitPane();
        projectListPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jList1 = new javax.swing.JList();
        treePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTree1 = new javax.swing.JTree();
        infoPanel = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveAsMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        importPSIMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        quitMenu = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        indicsMenu = new javax.swing.JMenuItem();
        consoMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpContMenu = new javax.swing.JMenuItem();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        leftPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        projectListPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Projects");
        projectListPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        jList1.setPreferredSize(new java.awt.Dimension(0, 100));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });

        projectListPanel.add(jList1, java.awt.BorderLayout.CENTER);

        leftPanel.setTopComponent(projectListPanel);

        treePanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Project structure");
        treePanel.add(jLabel2, java.awt.BorderLayout.NORTH);

        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });

        treePanel.add(jTree1, java.awt.BorderLayout.CENTER);

        leftPanel.setBottomComponent(treePanel);

        contentPane.setLeftComponent(leftPanel);

        infoPanel.setLayout(new java.awt.BorderLayout());

        contentPane.setRightComponent(infoPanel);

        getContentPane().add(contentPane, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        newMenu.setText("New...");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });

        fileMenu.add(newMenu);

        openMenu.setText("Open...");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });

        fileMenu.add(openMenu);

        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });

        fileMenu.add(saveMenu);

        saveAsMenu.setText("Save As...");
        saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuActionPerformed(evt);
            }
        });

        fileMenu.add(saveAsMenu);

        fileMenu.add(jSeparator1);

        importPSIMenu.setText("import PSI...");
        importPSIMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPSIMenuActionPerformed(evt);
            }
        });

        fileMenu.add(importPSIMenu);

        fileMenu.add(jSeparator2);

        quitMenu.setText("Quit");
        quitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuActionPerformed(evt);
            }
        });

        fileMenu.add(quitMenu);

        jMenuBar2.add(fileMenu);

        projectMenu.setText("Project");
        projectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectMenuActionPerformed(evt);
            }
        });

        indicsMenu.setText("Indicators...");
        indicsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indicsMenuActionPerformed(evt);
            }
        });

        projectMenu.add(indicsMenu);

        consoMenu.setText("Consolidation...");
        consoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consoMenuActionPerformed(evt);
            }
        });
        projectMenu.add(consoMenu);

        jMenuBar2.add(projectMenu);

        helpMenu.setText("Help");
        helpContMenu.setText("Contents");
        helpContMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpContMenuActionPerformed(evt);
            }
        });

        helpMenu.add(helpContMenu);

        jMenuBar2.add(helpMenu);

        setJMenuBar(jMenuBar2);
        
        
        pack();
    }
    
    
    
    
    private void consoMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	ConsolidationHandler controler = new ConsolidationHandler(envC.getWbeSets() , "azerty");
        new ConsolidationView(controler);        
    }
    
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        showSelectedProject(evt);
    }

    private void helpContMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void indicsMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int index = jList1.getSelectedIndex();
		if(index >= 0)
		{
			ViewProjectVariation test = new ViewProjectVariation("group",envC.getProjects().get(index)) ;
		}
    	//
    }

    private void quitMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {
        showSelectedPlannable(evt);
    }

    private void projectMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void importPSIMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }
    
    
    // Variables declaration - do not modify
    private javax.swing.JMenuItem consoMenu;
    private javax.swing.JSplitPane contentPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem helpContMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importPSIMenu;
    private javax.swing.JMenuItem indicsMenu;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTree jTree1;
    private javax.swing.JSplitPane leftPanel;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JPanel projectListPanel;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem quitMenu;
    private javax.swing.JMenuItem saveAsMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JPanel treePanel;
    // End of variables declaration
    
    
    
    
    private void updateProjectList()
    {       	
    	jList1.setListData(envC.getProjectNameList().toArray());
    }
    
    
    
    private void updateProjectTree(Project p)
	{
    	if(p == null)
		{			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("[Select a project]") ;
			DefaultTreeModel lModel= new DefaultTreeModel(root);
			jTree1.setModel(lModel);
		}
		else
		{			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project " + p.getName());
			root.setUserObject(p);
			int i;
			java.util.Collection<Activity> lAcs = p.getSubActivities();
			for(i=0; i<lAcs.size(); i++)
			{
				Activity lAc = (Activity)lAcs.toArray()[i];
				DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode("Activity " + lAc.getName()) ;
				lAcNode.setUserObject(lAc);
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
		java.util.Collection<Activity> lAcs = pAc.getSubActivities();
		for (i = 0; i < lAcs.size(); i++) {
			Activity lAc = (Activity) lAcs.toArray()[i];
			DefaultMutableTreeNode lAcNode = new DefaultMutableTreeNode(
					"Activity " + lAc.getName());
			lAcNode.setUserObject(lAc);
			updateActivityNode(lAcNode, lAc);
			pNode.add(lAcNode);
		}

		java.util.Collection<WorkBreakDownElement> lWBEs = pAc.getWbes();
		for (i = 0; i < lWBEs.size(); i++) {
			WorkBreakDownElement lWBE = (WorkBreakDownElement) lWBEs.toArray()[i];
			DefaultMutableTreeNode lWBENode = new DefaultMutableTreeNode("WBE "
					+ lWBE.getName());
			lWBENode.setUserObject(lWBE);
			pNode.add(lWBENode);
		}

	}
	
		
	
	
	private void showSelectedProject(javax.swing.event.ListSelectionEvent evt)
	{
		int index = jList1.getSelectedIndex();
		if(index >= 0)
		{
			updateProjectTree(envC.getProjects().get(index));
		}
	}
    
	
		
	
	private void showSelectedPlannable(javax.swing.event.TreeSelectionEvent evt)
	{		
		DefaultMutableTreeNode node 
		= (DefaultMutableTreeNode)jTree1.getSelectionPath().getLastPathComponent();
		Object obj = node.getUserObject();
		
		if(obj instanceof Project)
		{
			Project p = (Project)obj;
			infoPanel.removeAll();
			infoPanel.add(
					getProjectView(new ProjectControl(p)),
					java.awt.BorderLayout.CENTER
			);
			infoPanel.updateUI();
		}
		else
		if(obj instanceof Activity )
		{
			Activity a = (Activity)obj;
			infoPanel.removeAll();
			infoPanel.add(
					new PlannableView(new PlannableControl(a)),
					java.awt.BorderLayout.CENTER
			);
			infoPanel.updateUI();
		}
		else
		if(obj instanceof WorkBreakDownElement )
		{
			WorkBreakDownElement w = (WorkBreakDownElement)obj;
			infoPanel.removeAll();
			infoPanel.add(
					new PlannableView(new PlannableControl(w)),
					java.awt.BorderLayout.CENTER
			);
			infoPanel.updateUI();
		}		
		
		
	}
    
	
	
	private JPanel getProjectView(ProjectControl pc)
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
		return jPanel2;		
	}
	
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
        new MainWindow(new EnvironmentControl(TestEntity.createEnvironment())).setVisible(true);
    }
    
   
    
}

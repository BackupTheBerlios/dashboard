/*
 * MainWIndow.java
 *
 * Created on 26 janvier 2006, 12:16
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import control.ControlConsolidation;
import control.ControlEnvironment;
import control.ControlPlannable;
import control.ControlProject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import entity.Activity;
import entity.Project;
import entity.WorkBreakDownElement;
import examples.TestEntity;

/**
 *
 * @author  Oli
 */
public class ViewMain extends javax.swing.JFrame {
    
	private ControlEnvironment envC;
	
    
    
    /** Creates new form ViewMain */
    public ViewMain(ControlEnvironment pEnvC) {
    	envC = pEnvC;
        initComponents();
        updateProjectList();
        updateProjectTree(null);
        
        this.setSize(900,700); 
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

        jLabel1.setText("Projets");
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

        jLabel2.setText("Structure de projet");
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

        fileMenu.setText("Fichier");
        newMenu.setText("Nouveau...");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });

        fileMenu.add(newMenu);

        openMenu.setText("Ouvrir...");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });

        fileMenu.add(openMenu);

        saveMenu.setText("Enregistrer");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });

        fileMenu.add(saveMenu);

        saveAsMenu.setText("Enregistrer sous...");
        saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuActionPerformed(evt);
            }
        });

        fileMenu.add(saveAsMenu);

        fileMenu.add(jSeparator1);

        importPSIMenu.setText("importer PSI...");
        importPSIMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPSIMenuActionPerformed(evt);
            }
        });

        fileMenu.add(importPSIMenu);

        fileMenu.add(jSeparator2);

        quitMenu.setText("Quitter");
        quitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuActionPerformed(evt);
            }
        });

        fileMenu.add(quitMenu);

        jMenuBar2.add(fileMenu);

        projectMenu.setText("Projet");
        projectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectMenuActionPerformed(evt);
            }
        });

        indicsMenu.setText("Indicateurs...");
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

        helpMenu.setText("Aide");
        helpContMenu.setText("Contenu");
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
    	int index = jList1.getSelectedIndex();
		if(index >= 0)
		{	
			ControlConsolidation controler = new ControlConsolidation(envC.getControlProjects().get(index));
	        new ViewConsolidation(controler);

		}
    	        
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
			new ViewProjectVariation("group",envC.getControlProjects().get(index)) ;
		}
    	//
    }

    private void quitMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	ViewPersistance v= new ViewPersistance(envC);
    	v.callSave();
    }

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
        if(envC.getLastFileName() == null)
        {
        	ViewPersistance v= new ViewPersistance(envC);
        	v.callSave();       	
        }
        else
        {
        	try
        	{
        		envC.saveFile(envC.getLastFileName());
        	}
        	catch(IOException e)
        	{
        		JOptionPane.showMessageDialog(this,"Erreur lors de l'�criture sur le disque!");
        	}
        }
    }

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	ViewPersistance v= new ViewPersistance(envC);
    	if(v.callLoad())
    	{
	    	updateProjectList();
	        updateProjectTree(null);
    	}
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
    
    
    
    private void updateProjectTree(ControlProject cp)
	{
    	if(cp == null)
		{			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("[Select a project]") ;
			DefaultTreeModel lModel= new DefaultTreeModel(root);
			jTree1.setModel(lModel);
		}
		else
		{			
			jTree1.setModel(cp.getTreeModel());
		}		
	}
    
	
    
    	
	
	private void showSelectedProject(javax.swing.event.ListSelectionEvent evt)
	{
		int index = jList1.getSelectedIndex();
		if(index >= 0)
		{
			updateProjectTree(envC.getControlProjects().get(index));
		}
	}
    
	
		
	
	private void showSelectedPlannable(javax.swing.event.TreeSelectionEvent evt)
	{		
		TreePath tp = jTree1.getSelectionPath();
		if(tp!=null)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)tp.getLastPathComponent();
			Object obj = node.getUserObject();
			
			if(obj instanceof Project)
			{
				Project p = (Project)obj;
				infoPanel.removeAll();
				infoPanel.add(
						new ViewProject(new ControlProject(p)),
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
						new ViewPlannable(new ControlPlannable(a)),
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
						new ViewPlannable(new ControlPlannable(w)),
						java.awt.BorderLayout.CENTER
				);
				infoPanel.updateUI();
			}	
			
		}
	}
    
	
	
	
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	
        new ViewMain(new ControlEnvironment(TestEntity.createEnvironment())).setVisible(true);
    }
    
   
    
}

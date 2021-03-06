/*
 * MainWIndow.java
 *
 * Created on 26 janvier 2006, 12:16
 */

package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import control.ControlConsolidation;
import control.ControlEnvironment;
import control.ControlParser;
import control.ControlPlannable;
import control.ControlProject;
import entity.Activity;
import entity.Environment;
import entity.Project;
import entity.WorkBreakDownElement;

/**
 *
 * @author  Oli
 */
public class ViewMain extends javax.swing.JFrame {
    
	private ControlEnvironment envC;
	
    // Variables declaration - do not modify
	private javax.swing.JMenuItem consoMenu;
	private javax.swing.JMenuItem compareMenu;
    private javax.swing.JSplitPane contentPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem warningSettingMenu;
    private javax.swing.JMenu settingMenu;
    private javax.swing.JMenuItem helpContMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem importPSIMenu;
    private javax.swing.JMenu indicsMenu;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTree jTree1;
    private javax.swing.JSplitPane leftPanel;
    private javax.swing.JMenuItem newProjectMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JPanel projectListPanel;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem quitMenu;
    private javax.swing.JMenuItem saveAsMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JPanel treePanel;
    private javax.swing.JMenuItem variationMenu;
    private javax.swing.JMenuItem ressourceMenu;
    private javax.swing.JMenuItem alertMenu;
    // End of variables declaration
    
    
    
    /** Creates new form ViewMain */
    public ViewMain(ControlEnvironment pEnvC) {
    	super("2DB");
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
        newProjectMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveAsMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        importPSIMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        quitMenu = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        indicsMenu = new javax.swing.JMenu();
        variationMenu = new javax.swing.JMenuItem();
        ressourceMenu = new javax.swing.JMenuItem();
        alertMenu = new javax.swing.JMenuItem();
        consoMenu = new javax.swing.JMenuItem();
        compareMenu = new javax.swing.JMenuItem();
        settingMenu = new javax.swing.JMenu();
        warningSettingMenu = new javax.swing.JMenuItem();
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
        
        openMenu.setText("Ouvrir environnement...");
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
        
        newProjectMenu.setText("Ajout projet");
        newProjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuActionPerformed(evt);
            }
        });

        projectMenu.add(newProjectMenu);
        
        
        importPSIMenu.setText("Import une �tape...");
        importPSIMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPSIMenuActionPerformed(evt);
            }
        });

        projectMenu.add(importPSIMenu);


        
        projectMenu.add(jSeparator2);

        
        
        indicsMenu.setText("Indicateurs");
        
        variationMenu.setText("Variation sur le projet");
        variationMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	variationMenuActionPerformed(evt);
            }
        });
        
        alertMenu.setText("alertes");
        alertMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	alertMenuActionPerformed(evt);
            }
        });
        projectMenu.add(alertMenu);
        ressourceMenu.setText("Ressources");
        ressourceMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ressourceMenuActionPerformed(evt);
            }
        });
        
        
        projectMenu.add(indicsMenu);
        
        indicsMenu.add(variationMenu);
        indicsMenu.add(ressourceMenu);
        
        consoMenu.setText("Consolidation...");
        consoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consoMenuActionPerformed(evt);
            }
        });
        projectMenu.add(consoMenu);

        
        projectMenu.add(jSeparator3);

        
        
        compareMenu.setText("Comparer les projets...");
        compareMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	compareMenuActionPerformed(evt);
            }
        });
        projectMenu.add(compareMenu);
        
        
         jMenuBar2.add(projectMenu);
        
        warningSettingMenu.setText("R�glages des seuils d'alertes");
        settingMenu.setText("R�glages");
        
        warningSettingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	warningPropertiesMenuActionPerformed(evt);
            }
        });
        
        
        settingMenu.add(warningSettingMenu);
        jMenuBar2.add(settingMenu);
        
        
        helpMenu.setText("Aide");
        helpContMenu.setText("Sommaire");
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
    
    
    
    private void compareMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	new ViewCompareProjects(envC,this).setVisible(true);    	
    }
    
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        showSelectedProject(evt);
    }

    private void helpContMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new ViewHelp("http://www.loc.gov/rr/international/portals.html", this);
    }
    private void warningPropertiesMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new ViewWarningProperties ();;
    }
    private void ressourceMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	 
    	int index = jList1.getSelectedIndex();
		if(index >= 0)
		{
			new ViewAllRessource(envC.getControlProjects().get(index)) ;
		}
    }
    
    private void variationMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	 
    	int index = jList1.getSelectedIndex();
		if(index >= 0)
		{
			new ViewProjectVariation("group",envC.getControlProjects().get(index)) ;
		}
    	 
    }

    private void quitMenuActionPerformed(java.awt.event.ActionEvent evt) {
        exitForm(null);
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
	        updateInfoPanel();
    	}
    }

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) 
    {
        envC.reset();
        updateProjectList();
        updateProjectTree(null);
        updateInfoPanel();
    }

    private void newProjectMenuActionPerformed(java.awt.event.ActionEvent evt) {
        envC.createNewProject();
        updateProjectList();
        updateProjectTree(null);
        updateInfoPanel();
    }
    
    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {
        updateInfoPanel();
    }

    private void projectMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void importPSIMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int index = jList1.getSelectedIndex();
		if(index >= 0){
			try {
				new ControlParser(envC.getControlProjects().get(index).getProject());
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updateProjectList();
	        updateProjectTree(envC.getControlProjects().get(index));
	        updateInfoPanel();
		}
		
    }
    
    private void alertMenuActionPerformed(java.awt.event.ActionEvent evt){
    	int index = jList1.getSelectedIndex();
    	if(index>=0)
    		new ViewAlertProject(envC.getControlProjects().get(index), ((double)Environment.getMinLimit())/100.0, ((double)Environment.getMaxLimit())/100.0);
    	
    }
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }
    
    
    
    
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
    
	
		
	
	private void updateInfoPanel()
	{		
		TreePath tp = jTree1.getSelectionPath();
		if(tp==null)
		{
			infoPanel.removeAll();
			infoPanel.updateUI();
		}
		else
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)tp.getLastPathComponent();
			Object obj = node.getUserObject();
			
			if(obj instanceof Project)
			{
				/*
				Project p = (Project)obj;
				infoPanel.removeAll();
				infoPanel.add(
						new ViewProject(new ControlProject(p)),
						java.awt.BorderLayout.CENTER
				);
				infoPanel.updateUI();
				*/
				Activity a = (Activity)obj;
				infoPanel.removeAll();
				infoPanel.add(
						new ViewPlannable(new ControlPlannable(a), this),
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
						new ViewPlannable(new ControlPlannable(a), this),
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
						new ViewPlannable(new ControlPlannable(w), this),
						java.awt.BorderLayout.CENTER
				);
				infoPanel.updateUI();
			}
			else
			{
				infoPanel.removeAll();
				infoPanel.updateUI();
			}
			
		}
	}
    
	
	
	
   
    
}

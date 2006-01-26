package view ;

import test.*;
import javax.swing.* ;

import java.awt.* ;
import java.awt.event.* ;
import java.beans.PropertyVetoException ;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free
 * for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or
 * business for any purpose whatever) then you should purchase a license for each developer using
 * Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS
 * CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainWindow extends javax.swing.JFrame
{
    {
        // Set Look & Feel
        try
        {
            javax.swing.UIManager
                .setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel") ;
        }
        catch (Exception e)
        {
            e.printStackTrace () ;
        }
    }
    private JMenuItem    helpMenuItem ;
    private JMenu        jMenu5 ;
    private JMenuItem    ImportPSIMenuItem ;
    private JSeparator   jSeparator3 ;
    private JMenuItem    indicsMenuItem ;
    private JMenu        jMenu4 ;
    private JMenuItem    exitMenuItem ;
    private JSeparator   jSeparator2 ;
    private JMenuItem    closeFileMenuItem ;
    private JMenuItem    saveAsMenuItem ;
    private JMenuItem    saveMenuItem ;
    private JMenuItem    openFileMenuItem ;
    private JDesktopPane jDesktopPane1 ;
    private JMenuItem    newFileMenuItem ;
    private JMenu        jMenu3 ;
    private JMenuBar     jMenuBar1 ;


    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main (String[] args)
    {
        MainWindow inst = new MainWindow () ;
        inst.setVisible (true) ;
    }


    public MainWindow ()
    {
        super ("2DB") ;
        initGUI () ;
    }


    public void doNewFile ()
    {
        ProjectWindow pw = new ProjectWindow (TestEntity.createTestProject()) ;
        jDesktopPane1.add (pw) ;
        try
        {
            pw.setMaximum (true) ;
            pw.requestFocus () ;
        }
        catch (PropertyVetoException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace () ;
        }
    }


    public void doExit ()
    {
        dispose () ;
    }

    public void doIndicator()
    {
    	 
    	ViewProjectVariation test = new ViewProjectVariation("group") ;
     
    }
    private void initGUI ()
    {
        try
        {
            setSize (550, 400) ;
            setExtendedState (JFrame.MAXIMIZED_BOTH) ;
            {
                jMenuBar1 = new JMenuBar () ;
                setJMenuBar (jMenuBar1) ;
                {
                    jMenu3 = new JMenu () ;
                    jMenuBar1.add (jMenu3) ;
                    jMenu3.setText ("File") ;
                    {
                        newFileMenuItem = new JMenuItem () ;
                        jMenu3.add (newFileMenuItem) ;
                        newFileMenuItem.setText ("New...") ;
                        newFileMenuItem.addActionListener (new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent ev)
                            {
                                doNewFile () ;
                            }
                        }) ;
                    }
                    {
                        openFileMenuItem = new JMenuItem () ;
                        jMenu3.add (openFileMenuItem) ;
                        openFileMenuItem.setText ("Open...") ;
                    }
                    {
                        saveMenuItem = new JMenuItem () ;
                        jMenu3.add (saveMenuItem) ;
                        saveMenuItem.setText ("Save") ;
                    }
                    {
                        saveAsMenuItem = new JMenuItem () ;
                        jMenu3.add (saveAsMenuItem) ;
                        saveAsMenuItem.setText ("Save As ...") ;
                    }
                    {
                        closeFileMenuItem = new JMenuItem () ;
                        jMenu3.add (closeFileMenuItem) ;
                        closeFileMenuItem.setText ("Close") ;
                    }
                    {
                        jSeparator2 = new JSeparator () ;
                        jMenu3.add (jSeparator2) ;
                    }
                    {
                        ImportPSIMenuItem = new JMenuItem () ;
                        jMenu3.add (ImportPSIMenuItem) ;
                        ImportPSIMenuItem.setText ("Import PSI file...") ;
                    }
                    {
                        jSeparator3 = new JSeparator () ;
                        jMenu3.add (jSeparator3) ;
                    }
                    {
                        exitMenuItem = new JMenuItem () ;
                        jMenu3.add (exitMenuItem) ;
                        exitMenuItem.setText ("Exit") ;
                        exitMenuItem.addActionListener (new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent ev)
                            {
                                doExit () ;
                            }
                        }) ;
                    }
                }
                {
                    jMenu4 = new JMenu () ;
                    jMenuBar1.add (jMenu4) ;
                    jMenu4.setText ("Project") ;
                    {
                        indicsMenuItem = new JMenuItem () ;
                        jMenu4.add (indicsMenuItem) ;
                        indicsMenuItem.setText ("Indicators...") ;
                        indicsMenuItem.addActionListener(new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent ev)
                            {
                                doIndicator() ;
                            }
                        });
                    }
                }
                {
                    jMenu5 = new JMenu () ;
                    jMenuBar1.add (jMenu5) ;
                    jMenu5.setText ("Help") ;
                    {
                        helpMenuItem = new JMenuItem () ;
                        {
                            jDesktopPane1 = new JDesktopPane () ;
                            jDesktopPane1.setBackground (Color.DARK_GRAY) ;
                            getContentPane ().add (jDesktopPane1, BorderLayout.CENTER) ;
                        }
                        jMenu5.add (helpMenuItem) ;
                        helpMenuItem.setText ("Help") ;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace () ;
        }
    }
}

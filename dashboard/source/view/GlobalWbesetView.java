package view;
import control.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import control.IndicatorState;

import java.util.ArrayList;

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
public class GlobalWbesetView extends javax.swing.JInternalFrame  {
	private JPanel jPanel1;
	private JCheckBox jCheckBox1;
	private JLabel jLabel1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	

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
		ArrayList listeWBE = new ArrayList();
		IndicatorState indic= new IndicatorState();
		indic.setName("lalal");
		listeWBE.add(indic);
		IndicatorState indic2= new IndicatorState();
		indic2.setName("lalal");
		listeWBE.add(indic);
		
		JFrame frame = new JFrame();
		GlobalWbesetView inst = new GlobalWbesetView();
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(inst);
		jdp.setPreferredSize(inst.getPreferredSize());
		frame.setContentPane(jdp);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void initGUI() {
		try {
			{
				this.setPreferredSize(new java.awt.Dimension(784, 539));
				this.setBounds(0, 0, 784, 539);
				{
					jPanel1 = new JPanel();
					GridLayout jPanel1Layout = new GridLayout(2, 1);
					jPanel1Layout.setHgap(5);
					jPanel1Layout.setVgap(5);
					jPanel1Layout.setColumns(1);
					jPanel1Layout.setRows(2);
					getContentPane().add(jPanel1, BorderLayout.EAST);
					jPanel1.setLayout(jPanel1Layout);
					jPanel1.setPreferredSize(new java.awt.Dimension(208, 395));
					{
						jPanel2 = new JPanel();
						jPanel1.add(jPanel2);
						BoxLayout jPanel2Layout = new BoxLayout(
							jPanel2,
							javax.swing.BoxLayout.Y_AXIS);
						jPanel2.setLayout(jPanel2Layout);
						jPanel2.setPreferredSize(new java.awt.Dimension(250, 249));
						jPanel2.setEnabled(false);
						jPanel2.setFocusTraversalPolicyProvider(true);
						jPanel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						jPanel2.setLocation(new java.awt.Point(0, 10));
						{
							jCheckBox1 = new JCheckBox();
							jPanel2.add(jCheckBox1);
							jCheckBox1.setText("jCheckBox1");
							jCheckBox1.setPreferredSize(new java.awt.Dimension(121, 23));
						}
						
					}
				}
				{
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3, BorderLayout.CENTER);
					{
						jLabel1 = new JLabel();
						jPanel3.add(jLabel1);
						jLabel1.setText("jLabel1");
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("view/image001.gif")));
						jLabel1.setPreferredSize(new java.awt.Dimension(528, 381));
						jLabel1.setVerticalAlignment(SwingConstants.TOP);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

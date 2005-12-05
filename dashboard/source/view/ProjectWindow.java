package view;
import java.awt.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;


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
public class ProjectWindow extends javax.swing.JInternalFrame {
	private JSplitPane jSplitPane1;
	private JTree jTree1;
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
					jSplitPane1.add(jTree1, JSplitPane.LEFT);
					jPanel1 = new JPanel();
					jSplitPane1.add(jPanel1, JSplitPane.RIGHT);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
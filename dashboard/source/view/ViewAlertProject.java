package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import utils.Pair;
import control.ControlAlert;
import control.ControlProject;
import control.IndicatorState;

public class ViewAlertProject {
	
	double min;
	double max;
	
	public static JScrollPane createJTable(Pair<Vector<String>,Vector<Vector>> nomValeur){

		JTable jTable		= new JTable(nomValeur.getSecond(),nomValeur.getFirst());
		
		jTable.getColumnModel().getColumn(1).setMaxWidth(70);

		jTable.getColumnModel().getColumn(2).setMaxWidth(70);
		
		jTable.getColumnModel().getColumn(3).setCellRenderer(new  PercentTableCellRenderer());
		jTable.getColumnModel().getColumn(3).setWidth(200);
		jTable.getColumnModel().getColumn(3).setMaxWidth(200);

		jTable.setEnabled(false);
		return JTable.createScrollPaneForTable(jTable);
	}
	

	
	public ViewAlertProject(ControlProject project, Double min, Double max)
	{

		ControlAlert controller = new ControlAlert(min,max);
		JPanel titlePanel = new JPanel();
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new java.awt.BorderLayout(2, 5));
		JLabel txtTitle = new JLabel("alerte sur le projet \""+ project.getNameP() + "\"" );
        titlePanel.add(txtTitle,BorderLayout.WEST);

        panelCentral.add(titlePanel, java.awt.BorderLayout.NORTH);

		JPanel panelAmount = new JPanel(new BorderLayout());
		
		JPanel titlePanelAmount = new JPanel();
		JLabel txtTitleAmount = new JLabel("Par rapport à la charge");
        titlePanelAmount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        titlePanelAmount.add(txtTitleAmount);
        panelAmount.add(titlePanelAmount, java.awt.BorderLayout.NORTH);
        
		panelAmount.add(createJTable(control.ControlAlert.vectorAlertAmount(project)),BorderLayout.CENTER);
		
		JPanel panelDuration = new JPanel(new BorderLayout());
		
		JPanel titlePanelDuration = new JPanel();
		JLabel txtTitleDuration = new JLabel("Par rapport à la durée");
        titlePanelDuration.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        titlePanelDuration.add(txtTitleDuration);
        panelDuration.add(titlePanelDuration, java.awt.BorderLayout.NORTH);
		
		panelDuration.add(createJTable(control.ControlAlert.vectorAlertDuration(project)),BorderLayout.CENTER);
		

		

		   JComponent c1 = panelAmount;
		
		   JComponent c2 =  panelDuration;
		
		   JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, c1, c2);
		   pane.setBackground(Color.WHITE);
		   pane.setDividerSize(10);//taille du jsp
		   pane.setResizeWeight(0.4);//% de redimensionnement 
		   pane.setAutoscrolls(true);
		    


		JFrame fenetre = new JFrame(txtTitle.getText());
		
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.getContentPane().setLayout(new BorderLayout());
		panelCentral.add(pane);
		fenetre.add(panelCentral, BorderLayout.CENTER);
		fenetre.setBackground(Color.WHITE);

		
		 fenetre.setSize(700,600); 
	     Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	     fenetre.setLocation((screen.width -fenetre.getSize().width)/2,(screen.height - fenetre.getSize().height)/2); 	 
		
		fenetre.setVisible(true);
		
	}
	
	
	public static  class PercentTableCellRenderer extends JLabel implements TableCellRenderer
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public PercentTableCellRenderer(){
			super();
		}

		public Component getTableCellRendererComponent
	       (JTable table, Object value, boolean isSelected,
	       boolean hasFocus, int row, int column) 
	    {

	        	 IndicatorState  indic = ( IndicatorState ) value;
	            if( indic.getLed() ==  IndicatorState.BAD )
	            {
	                setBackground( Color.red );
	                setText("  +" + NumberFormat.getPercentInstance().format(indic.getValue()));
			        
	                // You can also customize the Font and Foreground this way
	                // cell.setForeground();
	                //setFont(new Font("SanSerif",Font.PLAIN,16));
	            }
	            else if( indic.getLed() ==  IndicatorState.MEDIUM )
	            {
	                setBackground( Color.orange );
	                setText("  -" + NumberFormat.getPercentInstance().format(-indic.getValue()));
			        
	                //setFont(new Font("SanSerif",Font.PLAIN,14));
	                
	            }
	            else if( indic.getLed() ==  IndicatorState.GOOD ){
	            	setBackground( Color.WHITE );
	                setText(((indic.getValue() >= 0)? "+" :"  -") + NumberFormat.getPercentInstance().format(((indic.getValue() >= 0)? indic.getValue(): -indic.getValue())));
	            }
	            setHorizontalAlignment(JLabel.CENTER); 
		        setOpaque(true); 

	        
	        return this;
	 
	    }
	}
	
}

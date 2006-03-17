package view;

import entity.Environment;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;


public class ViewWarningProperties extends JDialog{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField field1;
	private JTextField field2;
	private JButton ok;
	private JButton annuler;
	private JPanel centre;
	private JPanel bas;
	
	public ViewWarningProperties()
	{
		
		this.field1 =new JTextField();
		this.field2 =new JTextField();
		this.jLabel1=new JLabel("Seuil minimal (en %)");
		this.jLabel1.setPreferredSize(new Dimension (150,150));
		this.jLabel2=new JLabel("Seuil maximal (en %)");
		this.ok=new JButton("OK");
		this.ok.setDefaultCapable(true);
		this.annuler=new JButton("annuler");
		centre =new JPanel();
		bas = new JPanel();
		
		this.setTitle("Réglages des seuils d'alerte");
		this.setSize(300,125);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 	
		this.setLayout(new BorderLayout());
		
		
		this.field1.setText(""+Environment.getMinLimit());
		this.field2.setText(""+Environment.getMaxLimit());
		centre.setLayout(new GridLayout (2,2));
		centre.add(this.jLabel1);
		centre.add(this.field1);
		centre.add(this.jLabel2);
		centre.add(this.field2);
		bas.add(this.ok);
		bas.add(this.annuler);
		
		this.annuler.addActionListener(new ActionListener ()
				{public void actionPerformed (ActionEvent ev)
					{ViewWarningProperties.this.dispose();}
				});
		 this.ok.addActionListener(new ActionListener ()
	                {
		    			public void actionPerformed (ActionEvent ev)
		    			{	boolean numeric=true;
		    				String message="";
		    				/* test if the JTextField contents are numeric*/
		    				for(int i=0;i<ViewWarningProperties.this.field1.getText().length()&&numeric;i++)
		    				{
		    					numeric=Character.isDigit(ViewWarningProperties.this.field1.getText().charAt(i));
		    					if(i == 0  ){
		    						if(ViewWarningProperties.this.field1.getText().charAt(i) == '-')
		    							numeric = true;
		    						else 
		    							numeric = false;
		    					}
		    				}
		    				for(int i=0;i<ViewWarningProperties.this.field2.getText().length()&&numeric;i++)
		    				{
		 
		    					numeric=Character.isDigit(ViewWarningProperties.this.field2.getText().charAt(i));
		    					
		    				}
		    				
		    				/* test if the JTextField contents are empty*/
		    				if(ViewWarningProperties.this.field2.getText().equals("")||ViewWarningProperties.this.field1.getText().equals(""))
		    				{
		    					numeric=false;
		    				}
		    				/*test (-100<content<100) */
		    				if (numeric&&(Integer.parseInt(ViewWarningProperties.this.field1.getText())<-100 ||
		    								Integer.parseInt(ViewWarningProperties.this.field1.getText())>100 ||
		    								Integer.parseInt(ViewWarningProperties.this.field2.getText())<-100||
		    								Integer.parseInt(ViewWarningProperties.this.field2.getText())>100))
		    				{
		    					message+="- Les seuils doivent être compris entre [-100,0] et [0,100]%\n";
		    				}
		    				
		    				/*test (min<max)*/
    						if (numeric&&(Integer.parseInt(ViewWarningProperties.this.field1.getText())>Integer.parseInt(ViewWarningProperties.this.field2.getText())))
    						{
    							message+="- Le seuil minimum doit être inférieur au seuil maximum \n";
    						}
		    
		    				if (!numeric ||!message.equals(""))
		    				{
		    					
		    						JOptionPane.showMessageDialog(ViewWarningProperties.this, "Les seuils saisis sont incorrects\n"+message,
		    								"Erreur",
		    						      JOptionPane.WARNING_MESSAGE);
		    					
		    				}else{
		    					Environment.setMinLimit(Integer.parseInt(ViewWarningProperties.this.field1.getText()));
		    					Environment.setMaxLimit(Integer.parseInt(ViewWarningProperties.this.field2.getText()));
		    					ViewWarningProperties.this.dispose();
		    				}
		    			}
	                });
		
		
		
		this.add(centre,BorderLayout.CENTER);
		this.add(bas,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	}


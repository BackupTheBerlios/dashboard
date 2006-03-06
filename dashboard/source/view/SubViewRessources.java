package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class SubViewRessources  extends JFrame {

	public SubViewRessources(){
		super("Ressources");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(400,400) ;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2); 
		this.setVisible(true);
	}

}

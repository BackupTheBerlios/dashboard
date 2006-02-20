package view;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import control.*;
import examples.TestEntity;

public class ViewPersistance extends JFileChooser 
{

//	nested calss
	class DDBFilter extends FileFilter
	{
		public boolean accept(File f) {
		    if (f.isDirectory()) 
		    {
		    	return true;
		    }

		    String extension = getExtension(f);
		    if (extension != null) 
		    {
				if (extension.equalsIgnoreCase(new String("ddb")))
				{
				     return true;
				} 
				else 
				{
				    return false;
				}
		    }
		    return false;
		}	
		
		
	    public String getDescription() 
	    {
	        return "2DB files";
	    }
	};
	
	
	
	
	
	private ControlEnvironment cEnv;
	private static final long serialVersionUID = 1L;

	
	public ViewPersistance(ControlEnvironment ce) 
	{
		super();
		cEnv = ce;
		this.setCurrentDirectory(new File("/"));
		this.setFileFilter(new 	DDBFilter());
	    
	}

	
	
	private static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
	
	
	
	
	
	public void callSave()
	{
		int returnVal = this.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				cEnv.saveFile(this.getSelectedFile().getPath());
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(this,"Erreur d'écriture sur le disque!");
			}
		}
	}
	
	
	
	
	
	
	
	public void callLoad()
	{
		int returnVal = this.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				cEnv.loadFile(this.getSelectedFile().getPath());
			} 
			catch (ClassNotFoundException e) 
			{
				JOptionPane.showMessageDialog(this,"Fichier non trouvé!");
			}
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(this,"Erreur de lecture sur le disque!");
			} 			
		}
	}

	
	
	
	public static void main(String[] args) 
	{
		ControlEnvironment envC = new ControlEnvironment(TestEntity.createEnvironment());
		ViewPersistance v = new ViewPersistance(envC);	
		v.callSave();
		v.callLoad();
	}

}

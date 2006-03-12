package view;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import utils.Functions;

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

		    String extension = Functions.getFileNameExtension(f.getName());
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

	
	
	
	
	
	public boolean callSave()
	{
		int returnVal = this.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				cEnv.saveFile(this.getSelectedFile().getPath());
				return true;
			} 
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(this,"Erreur lors de l'écriture sur le disque!");
				return false;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	public boolean callLoad()
	{
		int returnVal = this.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				cEnv.loadFile(this.getSelectedFile().getPath());
				return true;
			} 
			catch (ClassNotFoundException e) 
			{
				JOptionPane.showMessageDialog(this,"Fichier non trouvé!");
				return false;
			}
			catch (IOException e) 
			{
				JOptionPane.showMessageDialog(this,"Erreur lors de la lecture sur le disque!");
				return false;
			} 			
		}
		return false;
	}

	
	
	
	public static void main(String[] args) 
	{
		ControlEnvironment envC = new ControlEnvironment(TestEntity.createEnvironment());
		ViewPersistance v = new ViewPersistance(envC);	
		v.callSave();
		v.callLoad();
	}

}

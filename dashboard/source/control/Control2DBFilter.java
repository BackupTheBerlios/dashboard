package control;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Control2DBFilter extends FileFilter {

//	Description et extension accept�e par le filtre
	   private String description;
	   private String extension;
	   
	public Control2DBFilter(String description, String extension) {
		
		  if(description == null || extension ==null){
	         throw new NullPointerException("La description (ou extension) ne peut �tre null.");
	      }
	      this.description = description;
	      this.extension = extension;
	}

	 //Impl�mentation de FileFilter
	   public boolean accept(File file){
	      if(file.isDirectory()) { 
	         return true; 
	      } 
	      String nomFichier = file.getName().toLowerCase(); 
	      return nomFichier.endsWith(extension);
	   }
	   
	   public String getDescription(){
	      return description;
	   }
	/**
	 * @param args
	 */
	

}

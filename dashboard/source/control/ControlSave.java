package control;

import java.io.*;

 

import entity.*;

public class ControlSave {

	private String fileName;
	private Project selectedPj;
	
	public ControlSave(Project p,String str) {
	
		fileName=str;
		selectedPj=p;
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(fileName + ".2db");
			ObjectOutputStream s = new ObjectOutputStream(out);
			s.writeObject(selectedPj);
			s.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

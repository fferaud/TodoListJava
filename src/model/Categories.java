package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class Categories {
	private final String nameFile = "categories";
	
	private CategoriesSerializable categList;
	
	
	//Constructeur
	public Categories(){
		categList = new CategoriesSerializable();
		getSave();
	}
	

	
	
	
	/* Methodes */
	public Hashtable<Integer, String> getList(){
		return categList.getList();
	}
	
	//Ajoute une categorie
	public void add(String s){
		categList.put(s);
		setSave();
	}
	
	//Recupere la categories avec l'id i
	public String get(int i){
		String res = categList.get(i);
		if(res == null){
			return "Sans catégorie";
		}
		return res;
	}
	
	//Supprime de la hashtable et de la sauvegarde le categorie avec l'id i
	public void remove(int i){
		categList.removeParID(i);
		setSave();
	}
	
	/* Permet d'enregistrer l'object categList */
	private void setSave(){
		try {
			FileOutputStream fileOut = new FileOutputStream(nameFile);
			ObjectOutputStream out;
			out = new ObjectOutputStream(fileOut);
			out.writeObject(categList);
	        out.close();
	        fileOut.close();
		} catch(IOException i) {
	         i.printStackTrace();
	    }
	}
	
	/* Permet d'obtenir, si elle existe, la sauvegarde de l'object categList */
	private void getSave(){
		 try {
			 File file = new File(nameFile); 
			 if(file.exists())
			 {
				 FileInputStream fileInTEST = new FileInputStream(nameFile);
				 if(fileInTEST.read() != -1){
					 FileInputStream fileIn = new FileInputStream(nameFile);
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         categList = (CategoriesSerializable) in.readObject();
			         in.close();
			         fileIn.close();			 
				 }
			 }
			 else
			 {
				 file.createNewFile();
			 }
		 }catch(Exception e){
	    	 e.printStackTrace();
	     }
	}
	
	public String toString(){
		return categList.toString();
	}
	public int getCursor() {
		return categList.getCursor();
	}
}

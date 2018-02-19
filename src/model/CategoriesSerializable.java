package model;

import java.io.Serializable;
import java.util.Hashtable;

public class CategoriesSerializable implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Hashtable<Integer, String> categList;
	
	private int cursor;
	/**
	 * Le cursor permet d'avoir tout le temps un id différent lorsque
	 * l'on ajoute une categorie, tout comme un auto-increment dans une base de donnee 
	 */
	
	
	//Constructeur
	public CategoriesSerializable(){
		categList = new Hashtable<Integer, String>();
		cursor = 0;
	}
	

	
	
	
	public Hashtable<Integer, String> getList(){
		
		return categList;
	}
	
	public void put(String s){
		categList.put(cursor, s);
		cursor++;
	}
	public void removeParID(int i){
		categList.remove(i);
	}
	
	public String get(int i){
		return categList.get(i);
	}
	
	public int getCursor() {
		return cursor;
	}
	public String toString(){
		return categList.toString();
	}

}

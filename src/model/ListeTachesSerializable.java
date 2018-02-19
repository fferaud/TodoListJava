package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ListeTachesSerializable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Tache> listeTacheRealise;
	private ArrayList<Tache> listeTacheNonRealise; 
	private ArrayList<Integer> listeDesID;
	
	private int cursor;
	/**
	 * Le cursor permet d'avoir tout le temps un id différent lorsque
	 * l'on ajoute une categorie, tout comme un auto-increment dans une base de donnee 
	 */
	
	
	public ListeTachesSerializable(){
		listeTacheRealise = new ArrayList<Tache>();
		listeTacheNonRealise = new ArrayList<Tache>();
		listeDesID = new ArrayList<Integer>();
		
		cursor = 0;
	}

	public String toString(){
		return "Non realise:"+listeTacheNonRealise.toString() + "\n\n Realise:"+ listeTacheRealise.toString();
	}

	
	
	
	
	public void ajoutTache(String titre, int idCategorie, Date echeance, ImportanceTache i){ //Tache pontuelle
		listeTacheNonRealise.add(new TacheP(cursor, titre, idCategorie, echeance, i));
		listeDesID.add(cursor);
		cursor++;
	}
	public void ajoutTache(String titre, int idCategorie, Date dateDebut,Date echeance, ImportanceTache i){ //Tache long cours
		listeTacheNonRealise.add(new TacheLC(cursor, titre, idCategorie, dateDebut, echeance, i));
		listeDesID.add(cursor);
		cursor++;
	}
	
	public void removeParID(int i){
		
		if(listeDesID.contains(i)){
			Boolean trouve = false;
			
			for (Tache t : listeTacheRealise) {
				if(t.getID() == i){
					listeTacheRealise.remove(t);
					listeDesID.remove(i);
					trouve = true;
					break;
				}
			}
			if(!trouve){
				for (Tache t : listeTacheNonRealise) {
					if(t.getID() == i){
						listeTacheNonRealise.remove(t);
						listeDesID.remove(i);
						break;
					}
				}
			}
			
		}
	}
	
	public Tache get(int i){
		if(listeDesID.contains(i)){
			
			for (Tache t : listeTacheNonRealise) {
				if(t.getID() == i){
					return t;
				}
			}
			
			for (Tache t : listeTacheRealise) {
				if(t.getID() == i){
					return t;
				}
			}

		}
		return null;
	}
	
	public void effectueTache(int i){
		if(listeDesID.contains(i)){
			for (Tache t : listeTacheNonRealise) {
				if(t.getID() == i){
					t.setDateRealisation(new Date());
					listeTacheRealise.add(t);
					listeTacheNonRealise.remove(t);
					break;
				}
			}
		}
	}
	
	
	

	public ArrayList<Tache> getListeTacheRealise() {
		return listeTacheRealise;
	}

	public void setListeTacheRealise(ArrayList<Tache> listeTacheRealise) {
		this.listeTacheRealise = listeTacheRealise;
	}

	public ArrayList<Tache> getListeTacheNonRealise() {
		return listeTacheNonRealise;
	}

	public void setListeTacheNonRealise(ArrayList<Tache> listeTacheNonRealise) {
		this.listeTacheNonRealise = listeTacheNonRealise;
	}
	public int getCursor() {
		return cursor;
	}
}

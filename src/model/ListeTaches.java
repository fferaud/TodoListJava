package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ListeTaches {
	private final String nameFile = "listesTaches";
	
	private ListeTachesSerializable listesTaches;
	
	
	//Constructeur
	public ListeTaches() {
		listesTaches = new ListeTachesSerializable(); 
		
		getSave();
	}
	
	
	//Force une sauvegarde de l'objet listesTaches
	public void save(){
		setSave();
	}
	// Ajoute une tache ponctuelle
	public void ajoutTache(String titre, int idCategorie, Date echeance, ImportanceTache i){
		listesTaches.ajoutTache(titre, idCategorie, echeance, i);
		setSave();
	}
	// Ajoute une tache long cours
	public void ajoutTache(String titre, int idCategorie, Date dateDebut,Date echeance, ImportanceTache i){
		listesTaches.ajoutTache(titre, idCategorie, dateDebut, echeance, i);
		setSave();
	}
	//Supprime la tache portant l'id i
	public void removeParID(int i){
		listesTaches.removeParID(i);
		setSave();
	}
	//Renvois la tache portant l'id i
	public Tache get(int i){
		return listesTaches.get(i);
	}
	//Termine la tache portant l'id i
	public void effectueTache(int i){
		listesTaches.effectueTache(i);
		setSave();
	}
	//Renvois la liste des taches comprise entre d1 et d2
	public ArrayList<Tache> getTachesEntreDeuxDates(Date d1, Date d2){
		ArrayList<Tache> tab = new ArrayList<Tache>();
		
		for (Tache t : listesTaches.getListeTacheNonRealise()) {
			if(t.getEcheance().after(d1) && t.getEcheance().before(d2)){
				tab.add(t);
			}
		}
		for (Tache t : listesTaches.getListeTacheRealise()) {
			if(t.getEcheance().after(d1) && t.getEcheance().before(d2)){
				tab.add(t);
			}
		}
		
		
		return tab;
	
	}
	//Effectue un tri simple decroissant par date d'échéance
	  public void triSimple(){
		  Tache.typeTri = "triSimple";
		  Collections.sort(listesTaches.getListeTacheNonRealise());
	  }
	  //Effectue un tri Interm decroissant par date intermetiaire
	  public void triInterm(){
		  Tache.typeTri = "triInterm";
		  Collections.sort(listesTaches.getListeTacheNonRealise());
	  }
	  //Renvois un liste de tache a effectuer composé de 1 tache importante, 3 moyennes et 5 petites
	  public ArrayList<Tache> getListeTacheResume(){
		  int nbImportante = 1;
		  int nbMoyenne = 3;
		  int nbPetite = 5;
		  
		  ArrayList<Tache> tab = new ArrayList<Tache>();
		  
		  for (Tache t : listesTaches.getListeTacheNonRealise()){
			  switch(t.getImportance()){
			  case IMPORTANTE:
				  if(nbImportante > 0){
					  tab.add(t);
					  nbImportante--;
				  }
				  break;
			  case MOYENNE:
				  if(nbMoyenne > 0){
					  tab.add(t);
					  nbMoyenne--;
				  }
				  break;
			  default:
				  if(nbPetite > 0){
					  tab.add(t);
					  nbPetite--;
				  }
			  }
		  }
		  
		  return tab;
	  }
	  //Permet d'enregistrer l'object listesTaches
		private void setSave(){
			try {
				FileOutputStream fileOut = new FileOutputStream(nameFile);
				ObjectOutputStream out;
				out = new ObjectOutputStream(fileOut);
				out.writeObject(listesTaches);
		        out.close();
		        fileOut.close();
			} catch(IOException i) {
		         i.printStackTrace();
		    }
		}
		//Permet d'obtenir, si elle existe, la sauvegarde de l'object listesTaches
		private void getSave(){
			 try {
				 File file = new File(nameFile); 
				 if(file.exists())
				 {
					 FileInputStream fileInTEST = new FileInputStream(nameFile);
					 if(fileInTEST.read() != -1){
					 	FileInputStream fileIn = new FileInputStream(nameFile);
						ObjectInputStream in = new ObjectInputStream(fileIn);
				        listesTaches = (ListeTachesSerializable) in.readObject();
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
	

	public ArrayList<Tache> getListeTacheRealise() {
		return listesTaches.getListeTacheRealise();
	}

	public void setListeTacheRealise(ArrayList<Tache> listeTacheRealise) {
		listesTaches.setListeTacheRealise(listeTacheRealise);
	}

	public ArrayList<Tache> getListeTacheNonRealise() {
		return listesTaches.getListeTacheNonRealise();
	}

	public void setListeTacheNonRealise(ArrayList<Tache> listeTacheNonRealise) {
		listesTaches.setListeTacheNonRealise(listeTacheNonRealise);
	}
	public String toString(){
		return listesTaches.toString();
	}
	
}

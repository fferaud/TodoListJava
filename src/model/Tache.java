package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Tache implements Comparable<Tache>, Serializable{
	
	/**
	 * 
	 */
	private int ID;
	private static final long serialVersionUID = 1L;
	private String titre;
	private int idCategorie;
	private ImportanceTache importance;
	
	protected Date dateCreation;
	protected Date echeance;
	protected Date dateRealisation;
	
	
	
	protected static String typeTri = "triSimple";
	
	//Constructeur
	@SuppressWarnings("deprecation")
	public Tache(int ID, String titre, int idCategorie, Date echeance, ImportanceTache i) {
		super();
		this.setID(ID);
		this.titre = titre;
		this.idCategorie = idCategorie;
		this.importance = i;
		this.dateRealisation = null;
		this.dateCreation = new Date();
		this.echeance = echeance;
		this.echeance.setHours(23);
		this.echeance.setMinutes(59);
		this.echeance.setSeconds(59);
	}
	
	
	/* Methodes */
	public abstract Boolean enRetard();//true si le tache est en retard, false sinon
	public abstract Boolean estRealisé();//true si une tache est realisé, false sinon (par rapport a la date de realisation)
	public abstract Date dateIntermediaire();//Calcul de la date intermediaire

	//Duree restante pour une tache, peut être négatif si en retard
	public long dureeRestante() {
		Date today = new Date();
		long diff2 = this.echeance.getTime() - today.getTime();
		long dureeEcoule;
		if(diff2 > 0){
			dureeEcoule = (long) Math.floor(diff2/(1000 * 60 * 60 * 24));
		}
		else{
			dureeEcoule = (long) Math.floor(diff2/(1000 * 60 * 60 * 24));
			dureeEcoule = dureeEcoule-1;
		}
		
		
		return dureeEcoule;
	}
	
	public String toString(){
		return "ID:"+ID+" "+dateIntermediaire()+" "+titre;//+" idCatégorie:"+idCategorie+" dateCréa:"+dateCreation+" echeance:"+echeance;
	}

	
	
	
	
	/* getters & setters */
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date DateCreation) {
		this.dateCreation = DateCreation;
	}
	public Date getEcheance() {
		return echeance;
	}
	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}

	public static String getType() {
		return typeTri;
	}

	public static void setType(String type) {
		Tache.typeTri = type;
	}

	public ImportanceTache getImportance() {
		return importance;
	}

	public void setImportance(ImportanceTache importance) {
		this.importance = importance;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
}

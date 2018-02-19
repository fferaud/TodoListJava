package model;

import java.util.Date;

public class TacheLC extends Tache{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateDebut;
	private int avancement;
	
	//constructeur
	@SuppressWarnings("deprecation")
	public TacheLC(int ID, String titre, int idCategorie, Date dateDebut,Date echeance, ImportanceTache i) {
		super(ID, titre, idCategorie, echeance, i);
		
		this.dateDebut = dateDebut;
		this.dateDebut.setHours(0);
		this.dateDebut.setMinutes(0);
		this.dateDebut.setSeconds(0);
		this.avancement = 0;
	}

	/* Methodes */
	
	public Boolean enRetard() {
		long diff = echeance.getTime() - dateDebut.getTime();
		long dureeTotale = (long) Math.floor(diff/(1000 * 60 * 60 * 24));
		
		Date today = new Date();
		long diff2 = today.getTime() - dateDebut.getTime();
		long dureeEcoule = (long) Math.floor(diff2/(1000 * 60 * 60 * 24));
		
		//System.out.println("Duree total: "+dureeTotale+"  Duree ecoulé: "+dureeEcoule);
		
		if(dureeEcoule > 0 && dureeEcoule < (dureeTotale/4)){
			return false;
		}
		else if(dureeEcoule > (dureeTotale/4) && dureeEcoule < (dureeTotale/2)){
			return !(this.avancement > 25);
		}
		else if(dureeEcoule > (dureeTotale/2) && dureeEcoule < (3*dureeTotale/4)){
			return !(this.avancement > 50);
		}
		else if(dureeEcoule > (3*dureeTotale/4) && dureeEcoule < (dureeTotale)){
			return !(this.avancement > 75);
		}
		else{ //if(dureeEcoule >= (dureeTotale))
			return !(this.avancement >= 100);
		}
			
	}
	public Boolean estRealisé(){
		return this.avancement >= 100;
	}
	public Date dateIntermediaire() {
		long diff = echeance.getTime() - dateDebut.getTime();
		long dureeTotale = (long) Math.floor(diff/(1000 * 60 * 60 * 24));
		long quartDiff = diff/4;
		
		Date today = new Date();
		long diff2 = today.getTime() - dateDebut.getTime();
		long dureeEcoule = (long) Math.floor(diff2/(1000 * 60 * 60 * 24));
		
		
		if(dureeEcoule > 0 && dureeEcoule < (dureeTotale/4)){
			return new Date(this.dateDebut.getTime() + quartDiff);
		}
		else if(dureeEcoule > (dureeTotale/4) && dureeEcoule < (dureeTotale/3)){
			return new Date(this.dateDebut.getTime() + quartDiff*2);
		}
		else if(dureeEcoule > (dureeTotale/3) && dureeEcoule < (dureeTotale/2)){
			return new Date(this.dateDebut.getTime() + quartDiff*3);
		}
		else{ //(dureeEcoule > (dureeTotale/2))
			return new Date(this.dateDebut.getTime() + quartDiff*4);
		}
	}
	
	//Implementation de la methode compareTo pour pouvoir trier une liste
	public int compareTo(Tache o) {
		int resultat;
		
		switch(TacheLC.typeTri){
		case "triInterm":
			Date d = dateIntermediaire();
			
			if(d.after(o.getEcheance())){
				resultat = 1;
			}
			else if (d.before(o.getEcheance())){
				resultat = -1;
			}
			else{
				resultat = 0;
			}
			
			
			break;
		default : //triSimple
			if(this.echeance.after(o.getEcheance())){
				resultat = 1;
			}
			else if (this.echeance.before(o.getEcheance())){
				resultat = -1;
			}
			else{
				resultat = 0;
			}
		}
		
		return resultat;
	}
	public String toString(){
		return super.toString()+" AVANCMENT:"+avancement;//+" dateDebut:"+this.dateDebut+" retard:"+enRetard();
	}
	

	
	
	
	
	
	/* get & set */
	public Date getDateCreation() {
		return getDateDebut();
	}
	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public int getAvancement() {
		return avancement;
	}


	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}
}

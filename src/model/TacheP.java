package model;

import java.util.Date;

public class TacheP extends Tache{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean realise;
	
	//Constructeur
	public TacheP(int ID, String titre, int idCategorie, Date echeance, ImportanceTache i){
		super(ID, titre, idCategorie, echeance, i);
		this.setRealise(false);
	}

	
	
	
	/* Methodes */
	@Override
	public Date dateIntermediaire() {
		return this.echeance;
	}
	public Boolean enRetard() {
		Date aujourdhui = new Date();
		
		return aujourdhui.after(this.echeance);
	}
	public Boolean estRealisé() {
		return getRealise();
	}
	
	public String toString(){
		return super.toString();//+" retard:"+enRetard();
	}
	
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

	

	
	
	
	/* GET & Set */
	public Boolean getRealise() {
		return realise;
	}

	public void setRealise(Boolean realise) {
		this.realise = realise;
	}

}

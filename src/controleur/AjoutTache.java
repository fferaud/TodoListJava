package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListeTaches;
import vue.FenetreFormTache;

class AjoutTache implements ActionListener{
	
	private ListeTaches list;
	private Application app;
	
	public AjoutTache(ListeTaches list, Application app){
		this.list = list;
		this.app = app;
	}
	
	
	/*Créé la fenetre Ajout Tache*/
    public void actionPerformed(ActionEvent e) {
    	FenetreFormTache fFormAjout = new FenetreFormTache(list, app);
		fFormAjout.setVisible(true);
    }
 }
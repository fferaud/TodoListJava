package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.FenetreBilan;
import vue.FenetreModifTache;

public class ModifTache implements ActionListener {

	private int idTache;
	private ListeTaches list;
	private Application app;
	
	
	public ModifTache(int idTache, ListeTaches list, Application app){
		this.idTache = idTache;
		this.list = list;
		this.app = app;
	}
	
	/*Créé la fenetre pour la modification de tache*/
	public void actionPerformed(ActionEvent e) {
		FenetreModifTache fen = new FenetreModifTache(idTache, list, app);
		fen.setVisible(true);
	}

}

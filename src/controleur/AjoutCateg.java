package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class AjoutCateg implements ActionListener {

	private Categories cat;
	
	public AjoutCateg(Categories cat){
		this.cat = cat;
	}
	
	/*Créé la fenetre ajout catégorie*/
	public void actionPerformed(ActionEvent e) {
		FenetreAjoutCategorie fFormAjout = new FenetreAjoutCategorie(cat);
		fFormAjout.setVisible(true);
	}

}

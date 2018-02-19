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
	
	/*Cr�� la fenetre ajout cat�gorie*/
	public void actionPerformed(ActionEvent e) {
		FenetreAjoutCategorie fFormAjout = new FenetreAjoutCategorie(cat);
		fFormAjout.setVisible(true);
	}

}

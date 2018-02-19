package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class SupprCateg implements ActionListener {
	
	private Categories cat;
	
	public SupprCateg(Categories cat){
		this.cat = cat;
	}
	
	/*Créé la fenetre pour la suprression de catégorie*/
	public void actionPerformed(ActionEvent e) {
		FenetreSuppCategorie fSuppCate = new FenetreSuppCategorie(cat);
		fSuppCate.setVisible(true);
	}
}

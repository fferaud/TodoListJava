package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class ValiderFormAjoutCateg implements ActionListener {

	private Categories cat;
	private FenetreAjoutCategorie fen;
	
	public ValiderFormAjoutCateg(Categories cat, FenetreAjoutCategorie fen){
		this.cat = cat;
		this.fen = fen;
	}
	
	/*ajoute la nouvelle catégorie */
	public void actionPerformed(ActionEvent e) {
		cat.add(fen.gettNouvelleCate().getText().toString());
		System.out.println(cat);
		fen.dispose();
	}

}

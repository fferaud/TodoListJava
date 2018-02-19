package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class ValiderFormSupprCateg implements ActionListener {

	private Categories cat;
	private FenetreSuppCategorie fen;
	
	public ValiderFormSupprCateg(Categories cat, FenetreSuppCategorie fen){
		this.cat = cat;
		this.fen = fen;
	}
	
	/*supprime la catégorie choisi par l'utilisateur*/
	public void actionPerformed(ActionEvent e) {
		if(fen.getComboCategorie().getSelectedItem() != null){
			String categ = fen.getComboCategorie().getSelectedItem().toString().split(":")[0];
			int idCat = Integer.parseInt(categ);
			cat.remove(idCat);
		}
		
		fen.dispose();
	}

}

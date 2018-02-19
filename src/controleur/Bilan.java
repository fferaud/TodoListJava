package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import model.Categories;
import model.ListeTaches;
import vue.FenetreAjoutCategorie;
import vue.FenetreBilan;
import vue.FenetrePrincipale;

public class Bilan implements ActionListener {
	
	
	
	private ListeTaches list;
	
	public Bilan(ListeTaches list) {
		super();
		this.list = list;
	}

	/*créé la fenetre du bilan*/
	public void actionPerformed(ActionEvent e) {
		FenetreBilan fBilan = new FenetreBilan(list);
		fBilan.setVisible(true);
	}

}

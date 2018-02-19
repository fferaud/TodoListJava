package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import model.*;
import vue.*;

public class ValiderFormAjoutTache implements ActionListener{
		private FenetreFormTache fen;
		private ListeTaches list;
		private Application app;
		private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		public ValiderFormAjoutTache(ListeTaches list, Application app, FenetreFormTache fen)
		{
			this.fen = fen;
			this.list = list;
			this.app = app;
		}
		
		/*
		 * Recupère le formulaire rempli apr l'utilisateur
		 * Vérifie les données à vérifier 
		 * Créé une tache et l'ajoute à la liste de tache
		 * refresh le tableau pour afficher la nouvelle liste
		 */
		public void actionPerformed(ActionEvent e) {
			
			String cat = fen.getComboCategorie().getSelectedItem().toString().split(":")[0];
			int idCat = Integer.parseInt(cat);
			ImportanceTache i;

			switch(fen.getComboImportance().getSelectedItem().toString()){
			case "Importante":
				i = ImportanceTache.IMPORTANTE; 
				break;
			case "Moyenne":
				i = ImportanceTache.MOYENNE; 
				break;
			default:
				i = ImportanceTache.PETITE; 
			}
			
			Date dateDeb=null;;
			Date dateFin=null;
			
			if(fen.getJtfDateFin().getText().length() <= 0){
				fen.attention.setForeground(Color.RED);
				fen.attention.repaint();
			}
			else{
				
				try {
					
					if(fen.getJtfDateDeb().getText().length() <= 0){
						dateDeb = new Date();
					}
					else{
						dateDeb = formatDate.parse(fen.getJtfDateDeb().getText().toString());
					}
					dateFin = formatDate.parse(fen.getJtfDateFin().getText().toString());
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				
				if(dateDeb.compareTo(dateFin) != 1)
				{
					try {
						if(fen.getChoixTacheP().isSelected()){
							list.ajoutTache(fen.gettNomTache().getText(), idCat, formatDate.parse(fen.getJtfDateFin().getText()), i);
						}
						else{
							list.ajoutTache(fen.gettNomTache().getText(), idCat, formatDate.parse(fen.getJtfDateDeb().getText()), formatDate.parse(fen.getJtfDateFin().getText()), i);
						}
						app.refreshTable();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					fen.dispose();
				}
				else
				{
					fen.attention.setText(fen.getAttention().getText().toString()+"\nErreur dans l'ordre des dates");
					fen.attention.setForeground(Color.RED);
					fen.attention.repaint();
				}
				
			}
			
		
		}   
}
		
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.*;
import vue.*;

public class ValiderFormModifTache implements ActionListener {


	private FenetreModifTache fen;
	private int idTache;
	private ListeTaches list;
	private Application app;
	
	public ValiderFormModifTache(int idTache, ListeTaches list, Application app, FenetreModifTache fen)
	{
		this.fen = fen;
		this.idTache = idTache;
		this.list = list;
		this.app = app;
	}
	
	/*
	 * Recupère le formulaire de l'utilisateur
	 * Modifie la tache
	 * Sauvegarde la tache
	 * Refresh le tableau pour afficher la liste avec la tache modifié 
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		String categ = fen.getComboCategorie().getSelectedItem().toString().split(":")[0];
		int idCat = Integer.parseInt(categ);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date = formatDate.parse(fen.getJtfDateFin().getText());
			date.setHours(23);
			date.setMinutes(59);
			date.setSeconds(59);
			if(date.after(list.get(idTache).getDateCreation())){
				list.get(idTache).setTitre(fen.getTNomTache().getText().toString());
				list.get(idTache).setIdCategorie(idCat);
				list.get(idTache).setEcheance(date);
				
				list.save();

				app.refreshTable();
				fen.dispose();
			}
			else{
				JOptionPane j = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Merci de renseigner une date supérieure à la date de création", "Attention !", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	    }
}

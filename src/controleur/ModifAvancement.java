package controleur;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.*;

public class ModifAvancement implements ChangeListener {

	private int idTache;
	private ListeTaches list;
	private Application app;
	
	
	
	public ModifAvancement(int idTache, ListeTaches list, Application app){
		this.idTache = idTache;
		this.list = list;
		this.app = app;
	}

	/*
	 * Actualise le slider si la nouvelle valeur est supérieur de l'ancienne
	 * Sauvegarde le nouvelle avancement pour la tache en question
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
	    Tache t = list.get(idTache);

	    int ancienneVal = ((TacheLC) t).getAvancement();
		int nouvelleVal = (int)source.getValue();
		
		if(ancienneVal > nouvelleVal){
			source.setValue(ancienneVal);
		}
		else{
			((TacheLC) list.get(idTache)).setAvancement(nouvelleVal);
			list.save();
			if(nouvelleVal == 100){
				list.effectueTache(idTache);

				app.refreshTable();
			}
		}
	}

}

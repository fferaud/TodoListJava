package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListeTaches;


public class TermineTache implements ActionListener{

	private int idTache;
	private ListeTaches list;
	private Application app;
	
	public TermineTache(int id, ListeTaches list, Application app)
	{
		this.idTache = id;
		this.list = list;
		this.app = app;
	}
	
	/* enleve la tache du tableau et passe son statut à terminé */
	public void actionPerformed(ActionEvent e) {
		System.out.println("effectue");
		list.effectueTache(idTache);
		app.refreshTable();
	}
	
}
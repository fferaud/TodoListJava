package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;
import vue.*;

public class TriListeTacheResume implements ActionListener{
	
	private ListeTaches list;
	private Application app;
	
	public TriListeTacheResume(ListeTaches list, Application app){
		this.list = list;
		this.app = app;
	}
	
	/* tri la liste de la manière résumé et refresh le tableau*/
	public void actionPerformed(ActionEvent e) {
		ArrayList<Tache> a = list.getListeTacheResume();
		app.refreshTable(a);
	}
}
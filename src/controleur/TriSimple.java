package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class TriSimple implements ActionListener{
	
	private ListeTaches list;
	private Application app;
	
	public TriSimple(ListeTaches list, Application app){
		this.list = list;
		this.app = app;
	}
	
	/* tri la liste de la manière simple et refresh le tableau*/
	public void actionPerformed(ActionEvent e) {
		list.triSimple();
		app.refreshTable();
	}
}

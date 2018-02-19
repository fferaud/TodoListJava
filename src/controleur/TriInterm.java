package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import vue.*;

public class TriInterm implements ActionListener{
	
	private ListeTaches list;
	private Application app;
	
	public TriInterm(ListeTaches list, Application app){
		this.list = list;
		this.app = app;
	}
	
	/* tri la liste de la manière intermédiaire et refresh le tableau*/
	public void actionPerformed(ActionEvent e) {
		list.triInterm();
		app.refreshTable();
	}
}


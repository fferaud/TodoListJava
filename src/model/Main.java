package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
	/*	Categories c = new Categories();
		c.add("perso");
		c.add("travail");
		System.out.println(c);
		c.remove(3);
		System.out.println(c.get(20));
*/
		
		Date today = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
	

		ListeTaches list = new ListeTaches();
		list.ajoutTache("Pas d'idée", 1, formatDate.parse("15/12/2016"), ImportanceTache.IMPORTANTE);
		//list.removeParID(11);
		//list.get(3).setTitre("BONJOUR");
		//list.effectueTache(3);
		System.out.println(list.getListeTacheNonRealise());
		
		
		/*
		
		try {
			Tache t1 = new TacheLC("Test",1 ,formatDate.parse("25/11/2016") ,formatDate.parse("22/12/2016"));
			Tache t2 = new TacheLC("Test",1 ,formatDate.parse("15/12/2016") ,formatDate.parse("6/12/2016"));
			Tache t3 = new TacheLC("Test",1 ,formatDate.parse("1/12/2016") ,formatDate.parse("30/12/2016"));
			Tache t4 = new TacheLC("Test",1 ,formatDate.parse("12/11/2016") ,formatDate.parse("10/12/2016"));
			Tache t5 = new TacheLC("Test",1 ,formatDate.parse("18/11/2016") ,formatDate.parse("5/12/2016"));
			
			
			ListeTaches lt = new ListeTaches();
			lt.ajoutTache(t1);
			
			
			
			System.out.println(lt);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

}

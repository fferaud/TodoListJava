package controleur;

import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Categories;
import model.ImportanceTache;
import model.ListeTaches;
import model.Tache;
import vue.FenetrePrincipale;
import vue.LigneTache;


public class Application {
	
	private SimpleDateFormat formatDate;
	private Categories listeCategories;
	private ListeTaches list;
	
	private FenetrePrincipale f;
	
	
	


	public Application()
	{
		f = new FenetrePrincipale();
		formatDate = new SimpleDateFormat("dd/MM/yyyy");
		listeCategories = new Categories();
		list = new ListeTaches();
		
		/*Initialisation des listener pour les boutons*/
		f.getBouTriSimple().addActionListener(new TriSimple(list, this));
		f.getBouTriInterm().addActionListener(new TriInterm(list, this));
		f.getBouTriResume().addActionListener(new TriListeTacheResume(list, this));
		
		f.getBouAjout().addActionListener(new AjoutTache(list, this));
		f.getBouAjoutCate().addActionListener(new AjoutCateg(listeCategories));
		f.getBouSuppCate().addActionListener(new SupprCateg(listeCategories));
		f.getBouBilan().addActionListener(new Bilan(list));
		

		
		refreshTable(list.getListeTacheNonRealise());
		
		f.setVisible(true);
	}
	
	/*Vide le panel tableau de la fenetre principale
	 * et affiche les taches de l'ArrayList pass� en param�tre
	 */
	public void refreshTable(ArrayList<Tache> lt){
		f.getpTableau().removeAll();
		for(Tache t : lt){			
			f.getpTableau().add(new LigneTache(t, list, this));
		}
		this.refreshTableFen();
	}
	
	/*Vide le panel tableau de la fenetre principale
	 * et affiche les taches non r�alis� contenu dans la list de ListTache
	 */
	public void refreshTable(){
		f.getpTableau().removeAll();
		for(Tache t : list.getListeTacheNonRealise()){			
			f.getpTableau().add(new LigneTache(t, list, this));
		}
		this.refreshTableFen();
	}
	
	/*
	 * Red�fini la taille du panel tableau en fonction du nombre de tache 
	 * � afficher et actualise le tableau pour que �a s'affiche directement
	 */
	public void refreshTableFen() {
		int count = f.getpTableau().getComponentCount();
		System.out.println(count);
		f.getpTableau().setPreferredSize(new Dimension(1150, 95*count));
		f.getpTableau().revalidate();
		f.getpTableau().repaint();
	}
	

	

	public static void main(String[] args) 
	{
		
		new Application();
	}
	
	
	
	
	
	public FenetrePrincipale getF() {
		return f;
	}

	public void setF(FenetrePrincipale f) {
		this.f = f;
	}
}



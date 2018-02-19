package controleur;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.ListeTaches;
import model.Tache;
import vue.FenetreBilan;
import vue.LigneTacheBilan;

public class VoirBilan implements ActionListener{

	private ListeTaches list;
	private FenetreBilan fen;
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	private Date maDateFinalDeb;
	private Date maDateFinalFin;
	private ArrayList<Tache> lt;
	
	double cptTotal=0;
	double cptRetard=0;
	double cptEnCours=0;
	double cptFini=0;
	
	
	
	public VoirBilan(ListeTaches list, FenetreBilan fen) {
		super();
		this.list = list;
		this.fen = fen;
	}


	/*
	 * Recupère la période donné par l'utilisateur
	 * Affiche le tableau des taches en cours sur cette période dans la fenetre bilan en instanciant des LigneTacheBilan
	 * au lieu des LigneTache
	 * calcul les pourcentages et les affiches sur la fenetre
	 */
	public void actionPerformed(ActionEvent e) 
	{
		
		String maDateDebut = fen.getDateDebBilan().getText().toString();
		String maDateFin = fen.getDateFinBilan().getText().toString();
		try {
			maDateFinalDeb = formatDate.parse(maDateDebut);
			maDateFinalFin = formatDate.parse(maDateFin);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(maDateFinalDeb.compareTo(maDateFinalFin) == -1 || maDateFinalDeb.compareTo(maDateFinalFin) == 0)
		{
			lt = list.getTachesEntreDeuxDates(maDateFinalDeb,maDateFinalFin);
			refreshTable(lt);
			list.triSimple();
			refreshTable();
			if(cptTotal != 0)
			{
				int nbFini=(int) (((cptFini/cptTotal)*100));
				int nbRetard=(int) (((cptRetard/cptTotal)*100));
				int nbEncours=(int) (((cptEnCours/cptTotal)*100));
				
				if(nbFini != 0 && nbFini != 100)
				{
					nbFini++;
					
				}
				else if (nbEncours != 0 && nbEncours != 100)
				{
					nbEncours++;
				}
				else if(nbRetard != 0 && nbRetard != 100)
				{
					nbRetard++;
				}
				
				fen.getlPourcentRealise().setText("Taches réalisés : "+nbFini+"%");
				fen.getlPourcentRetard().setText("Taches réalisés en retard : "+nbRetard+"%");
				fen.getlPourcentEnCours().setText("Taches en cours : "+nbEncours+"%");
			}
			
		}
		else
		{
			fen.getlErreur().setText("Erreur ordre des dates");
		}
	}
	
	
	public void removeTable() {
		fen.getpTableau().removeAll();

		int count = fen.getpTableau().getComponentCount();
		System.out.println(count);
		fen.getpTableau().setPreferredSize(new Dimension(1150, 95*count));
		fen.getpTableau().revalidate();
		fen.getpTableau().repaint();
	}
	
	public void refreshTableFen() {
		int count = fen.getpTableau().getComponentCount();
		System.out.println(count);
		fen.getpTableau().setPreferredSize(new Dimension(1150, 95*count));
		fen.getpTableau().revalidate();
		fen.getpTableau().repaint();
	}
	
	public void refreshTable(ArrayList<Tache> lt){
		removeTable();
		cptTotal = lt.size();
		
		for(Tache t : lt){
			
			System.out.print(t);
			if(t.getDateRealisation() == null)
			{
				fen.getpTableau().add(new LigneTacheBilan(t, list, this));
				cptEnCours++;
			}
			else
			{
				if(t.enRetard())
				{
					cptRetard++;
				}
				else
				{
					cptFini++;
				}
			}
			
				
		}
		
	refreshTableFen();
	}
	public void refreshTable(){
		removeTable();
		for(Tache t : list.getListeTacheNonRealise()){			
			fen.getpTableau().add(new LigneTacheBilan(t, list, this));
		}
		refreshTableFen();
	}

}

package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import model.*;
import controleur.*;

public class LigneTache extends JPanel
{
	Categories listeCategories = new Categories();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");;
	
	private JPanel pNom = new JPanel();
	private JPanel pCategorie = new JPanel();
	private JPanel pDate = new JPanel();
	private JPanel pNbJRestant = new JPanel();
	private JPanel pSpeTache = new JPanel();
	private JPanel pModif = new JPanel();
	
	private JTextArea tNom = new JTextArea();
	private JTextArea tCategorie = new JTextArea();
	private JTextArea tDateDeb = new JTextArea();
	private JTextArea tDateFin = new JTextArea();
	private JTextArea tNbJourRestant = new JTextArea();
	
	private JSlider slide = new JSlider();
	private JButton bouEnd = new JButton("Tache effectuée");
	private JButton bouModif = new JButton("Modifier");
	
	public LigneTache(Tache tache, ListeTaches list, Application app)
	{
		super();
		
		this.setBackground(Color.white);
	    this.setPreferredSize(new Dimension(1150,90));
	    
	    Font fontTab = new Font("Arial",Font.PLAIN,15);
	    
	    /* "Colonne" Nom Tache */
	    pNom.setBackground(Color.white);
	    pNom.setPreferredSize(new Dimension(300,80));
	    
	    tNom.setEditable(false);
	    tNom.setLineWrap(true);
	    tNom.setWrapStyleWord(true);
	    
	    /* Affichage dynamique de l'importance */
	    switch(tache.getImportance()){
		    case IMPORTANTE:
		    	tNom.setText("-IMPORTANT-\n"+tache.getTitre());
		    	tNom.setForeground(Color.RED);
		    	break;
		    case MOYENNE:
		    	tNom.setText("-MOYENNE-\n"+tache.getTitre());
		    	tNom.setForeground(Color.ORANGE);
		    	break;
		    default:
		    	tNom.setText("-PETITE-\n"+tache.getTitre());
		    	tNom.setForeground(Color.BLUE);
	    }
	    
	    
		tNom.setPreferredSize(new Dimension(290,70));
		tNom.setFont(fontTab);
		
		pNom.add(tNom);
	    
		/* "Colonne" Catégorie */
	    pCategorie.setBackground(Color.white);
	    pCategorie.setPreferredSize(new Dimension(150,80));
	    
	    tCategorie.setEditable(false);
	    tCategorie.setLineWrap(true);
	    tCategorie.setWrapStyleWord(true);
	    tCategorie.setPreferredSize(new Dimension(140,70));
		tCategorie.setFont(fontTab);
	    
	    /*Affichage dynamique de la catégorie*/
		tCategorie.setText(listeCategories.get(tache.getIdCategorie()));
		
		pCategorie.add(tCategorie);
	    
		
		/* "Colonne" Dates*/
	    pDate.setBackground(Color.white);
	    pDate.setPreferredSize(new Dimension(175,75));
	    
	    tDateDeb.setEditable(false);
	    tDateDeb.setLineWrap(true);
	    tDateDeb.setWrapStyleWord(true);
	    tDateDeb.setPreferredSize(new Dimension(165,30));
	    tDateDeb.setFont(fontTab);
	    
	    /* Affichage dynamique de la date Debut*/
	    if(tache.getClass() == TacheP.class){
	    	tDateDeb.setText("Début : "+formatDate.format(tache.getDateCreation()));
	    }
	    else{
	    	tDateDeb.setText("Début : "+formatDate.format(((TacheLC)tache).getDateDebut()));
	    }
	    
	    
	    tDateFin.setEditable(false);
	    tDateFin.setLineWrap(true);
	    tDateFin.setWrapStyleWord(true);
	    tDateFin.setPreferredSize(new Dimension(165,30));
	    tDateFin.setFont(fontTab);
	    
	    /*Affichage dynamique de date fin */
	    tDateFin.setText("Fin : "+formatDate.format(tache.getEcheance()));
	    
	    pDate.add(tDateDeb);
	    pDate.add(tDateFin);
	    
	    /*"Colonne" nombre jour restant */
	    
	    pNbJRestant.setBackground(Color.white);
	    pNbJRestant.setPreferredSize(new Dimension(135,80));
	    
	    tNbJourRestant.setEditable(false);
	    tNbJourRestant.setLineWrap(true);
	    tNbJourRestant.setWrapStyleWord(true);
	    tNbJourRestant.setPreferredSize(new Dimension(125,70));
	    tNbJourRestant.setFont(fontTab);
	    
	    /*Affichage dynamique du nombre de jour restant */
	    if(tache.enRetard()){
	    	tNbJourRestant.setForeground(Color.RED);
	    }
	    else{
	    	tNbJourRestant.setForeground(Color.GREEN);
	    }
	    tNbJourRestant.setText(tache.dureeRestante()+" jours restants");
	    
	    pNbJRestant.add(tNbJourRestant);
	   
	    
	    /*"Colonne" specifique à la tâche */
	    pSpeTache.setBackground(Color.white);
	    pSpeTache.setPreferredSize(new Dimension(225,60));
	    
	    pModif.setBackground(Color.white);
	    pModif.setPreferredSize(new Dimension(100,40));
	    
	    
	    pModif.add(bouModif);
	    
	    slide.setMaximum(100);
	    slide.setMinimum(0);
	    slide.setPaintTicks(true);
	    slide.setPaintLabels(true);
	    slide.setMinorTickSpacing(5);
	    slide.setMajorTickSpacing(10);
	    slide.setBackground(Color.white);
	    
	    /*Affichage dynamique du slider ou boutton selon la classe*/
	    if(tache.getClass() == TacheLC.class)
	    {
		    slide.setValue( ((TacheLC)tache).getAvancement());
	    	pSpeTache.add(slide);	
	    }
	    else
	    {
	    	pSpeTache.setPreferredSize(new Dimension(225,35));
	    	pSpeTache.add(bouEnd);
	    }
	    
	    
	    /* Ajout au Panel this */
	    this.add(pNom);
	    this.add(pCategorie);
	    this.add(pDate);
	    this.add(pNbJRestant);
	   
	    this.add(pSpeTache);
	    
	    this.add(pModif);
	    
	    
	    /*Listener pour les boutons du Tableau*/
	    bouEnd.addActionListener(new TermineTache(tache.getID(), list, app));
	    slide.addChangeListener(new ModifAvancement(tache.getID(), list, app));
	    
	    bouModif.addActionListener( new ModifTache(tache.getID(), list, app));
	}
}






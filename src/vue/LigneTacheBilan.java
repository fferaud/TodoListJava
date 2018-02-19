package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controleur.Application;
import controleur.Bilan;
import controleur.VoirBilan;
import model.Categories;
import model.ListeTaches;
import model.Tache;
import model.TacheLC;
import model.TacheP;

public class LigneTacheBilan extends JPanel
{
	Categories listeCategories = new Categories();
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");;
	
	private JPanel pNom = new JPanel();
	private JPanel pCategorie = new JPanel();
	private JPanel pDate = new JPanel();
	private JPanel pNbJRestant = new JPanel();
	private JPanel pSpeTache = new JPanel();
	
	private JTextArea tNom = new JTextArea();
	private JTextArea tCategorie = new JTextArea();
	private JTextArea tDateDeb = new JTextArea();
	private JTextArea tDateFin = new JTextArea();
	private JTextArea tNbJourRestant = new JTextArea();
	
	private JSlider slide = new JSlider();
	
	public LigneTacheBilan(Tache tache, ListeTaches list, VoirBilan appBilan)//à mettre tâche de type Tache en param
	{
		super();
		
		this.setBackground(Color.white);
	    this.setPreferredSize(new Dimension(1150,90));
	    
	    Font fontTab = new Font("Arial",Font.PLAIN,15);
	    
	    /* "Colonne" nom */
	    pNom.setBackground(Color.white);
	    pNom.setPreferredSize(new Dimension(300,80));
	    
	    tNom.setEditable(false);
	    tNom.setLineWrap(true);
	    tNom.setWrapStyleWord(true);
	    tNom.setPreferredSize(new Dimension(290,70));
		tNom.setFont(fontTab);
	    
	    /*Dynamique affichage*/
		tNom.setText(tache.getTitre());

		pNom.add(tNom);
		
		
	    /*"Colonne" catégorie*/
	    pCategorie.setBackground(Color.white);
	    pCategorie.setPreferredSize(new Dimension(150,80));
	    
	    tCategorie.setEditable(false);
	    tCategorie.setLineWrap(true);
	    tCategorie.setWrapStyleWord(true);
	    tCategorie.setPreferredSize(new Dimension(140,70));
		tCategorie.setFont(fontTab);
		
		/*Affichage dynamique*/
		tCategorie.setText(listeCategories.get(tache.getIdCategorie()));

		pCategorie.add(tCategorie);
		
		
		/*"Colonne" dates*/	    
	    pDate.setBackground(Color.white);
	    pDate.setPreferredSize(new Dimension(175,75));
	    
	    tDateDeb.setEditable(false);
	    tDateDeb.setLineWrap(true);
	    tDateDeb.setWrapStyleWord(true);
	    tDateDeb.setPreferredSize(new Dimension(165,30));
	    tDateDeb.setFont(fontTab);
	    
	    /*affichage dynamique*/
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
	    
	    /*affichage dynamique*/
	    tDateFin.setText("Fin : "+formatDate.format(tache.getEcheance()));
	    
	    
	    pDate.add(tDateDeb);
	    pDate.add(tDateFin);
	    
	    /*"Colonne" nbJourRestant*/	    
	    pNbJRestant.setBackground(Color.white);
	    pNbJRestant.setPreferredSize(new Dimension(135,80));
	    
	    tNbJourRestant.setEditable(false);
	    tNbJourRestant.setLineWrap(true);
	    tNbJourRestant.setWrapStyleWord(true);
	    tNbJourRestant.setPreferredSize(new Dimension(125,70));
	    tNbJourRestant.setFont(fontTab);
	    
	    /*Affichage dynamique*/
	    if(tache.enRetard()){
	    	tNbJourRestant.setForeground(Color.RED);
	    }
	    else{
	    	tNbJourRestant.setForeground(Color.GREEN);
	    }
	    
	    tNbJourRestant.setText(tache.dureeRestante()+" jours restants");
	    
	    
	    pNbJRestant.add(tNbJourRestant);
	   
	    /*"Colonne" specifique*/
	    pSpeTache.setBackground(Color.white);
	    pSpeTache.setPreferredSize(new Dimension(225,60));
	    
	    slide.setMaximum(100);
	    slide.setMinimum(0);
	    slide.setPaintTicks(true);
	    slide.setPaintLabels(true);
	    slide.setMinorTickSpacing(5);
	    slide.setMajorTickSpacing(10);
	    slide.setBackground(Color.white);
	    
	    /* Affiche le slider si tache long cours sinon fait un margin-left
	     * pour que la colonne est une largeur quand même
	     */
	    if(tache.getClass() == TacheLC.class)
	    {
		    slide.setValue( ((TacheLC)tache).getAvancement());
		    slide.setEnabled(false);
	    	pSpeTache.add(slide);	
	    }
	    else
	    {
	    	pNbJRestant.setPreferredSize(new Dimension(350,70));
	    	pNbJRestant.setBorder(new EmptyBorder(0,0,0,225));
	    }
	    
	    
	    
	    this.add(pNom);
	    this.add(pCategorie);
	    this.add(pDate);
	    this.add(pNbJRestant);
	   
	    /* Si tache long cours on ajoute le slider sinon non */
	    if(tache.getClass() == TacheLC.class)
	    {
	    	this.add(pSpeTache);
	    }
	    
	}
}


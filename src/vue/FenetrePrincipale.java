package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.*;

public class FenetrePrincipale extends JFrame
{		
	private JPanel pTableau  = new JPanel(); // le Panel qu'on recupère pour afficher les lignes contenant les taches
	
	/* boutons pour le head de la fenetre */
	private JButton bouQuitter  = new JButton("Quitter");
	private JButton bouBilan = new JButton("Bilan des tâches");
	
	/* boutons pour le body de la fenêtre */
	private JButton bouTriSimple = new JButton("Tri Simple");
	private JButton bouTriInterm = new JButton("Tri Intermédiaire");
	private JButton bouTriResume = new JButton("Tri resumé");
	private JButton bouAjout = new JButton("+");

	private JButton bouAjoutCate = new JButton("Ajouter une catégorie");
	private JButton bouSuppCate = new JButton("Supprimer une catégorie");
	
	
	JScrollPane scroll = new JScrollPane(); //Panel avec une scroll bar contenant le pTableau
	

		
	public FenetrePrincipale() {
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(1200, 800);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		/*----------------------DEBUT HEAD ---------------------------------------*/
		
		/* initialisation des JPanel et ajout d'option pour le head de la fenetre */
		JPanel pHead = new JPanel();
		pHead.setBorder(new EmptyBorder(30, 30, 10, 30));
		pHead.setBackground(Color.WHITE);
		
		/* Panel du titre */
		JPanel pTitre = new JPanel();
		pTitre.setBorder(new EmptyBorder(10, 10, 10, 10));
		pTitre.setLayout(new BorderLayout());
		pTitre.setBackground(Color.WHITE);
		pTitre.setPreferredSize(new Dimension(550, 100));
		
		/* Panel du sous titre */
		JPanel pSousTitre = new JPanel();
		pSousTitre.setBorder(new EmptyBorder(10, 20, 10, 10));
		pSousTitre.setLayout(new BorderLayout());
		pSousTitre.setBackground(Color.WHITE);
		
		/* titre affiché dans la fenêtre */
		JTextArea titre = new JTextArea("Bienvenue sur l'application ToDo List");
		titre.setEditable(false);
		titre.setLineWrap(true);
		titre.setWrapStyleWord(true);
		Font fontTitre = new Font("Arial", Font.BOLD, 20);
		titre.setFont(fontTitre);
		
		/* sous titre affiché sous le titre de la fenêtre */		
		JTextArea developpeurs = new JTextArea("Developpé par :\nFabien FERAUD et Florian NOVELLON");
		developpeurs.setEditable(false);
		developpeurs.setLineWrap(true);
		developpeurs.setWrapStyleWord(true);
		Font fontDev = new Font("Arial", Font.PLAIN, 15);
		developpeurs.setFont(fontDev);
		
		/* ajout des element titre et developpeurs au panel pTitre */
		pSousTitre.add(developpeurs);
		
		pTitre.add(titre, "North");
		pTitre.add(pSousTitre);
		
		/* Panel contenant les boutons dans le head de la fenêtre */
		JPanel pBouHead = new JPanel();
		pBouHead.setBackground(Color.white);
		pBouHead.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		/* Panel contenant le bouton Bilan dans le head de la fenêtre */
		JPanel pBilan = new JPanel();
		pBilan.setBackground(Color.white);
		
		/* Panel contenant le bouton Quitter dans le head de la fenêtre */
		JPanel pQuitter = new JPanel();
		pQuitter.setBackground(Color.white);
		pQuitter.setBorder(new EmptyBorder(0, 60, 0, 10));
		
		/* Ajout des boutons à leur panel respectif */
		pBilan.add(bouBilan);
		bouQuitter.addActionListener(new QuitterListener()); // Listener pour quitter la fenetre this
		pQuitter.add(bouQuitter);
		
		/* Ajout des Panel au panel contenant les boutons du head */
		pBouHead.add(pBilan);
		pBouHead.add(pQuitter);
		
		/*Ajout des deux grands panels du head de la fenêtre */
		pHead.add(pTitre);
		pHead.add(pBouHead, "East");
		
		/*Ajout au container de la fenêtre */
		add(pHead, "North");
		/*---------------------------------------FIN HEAD -------------------------------------------*/
		
		
		
		/*---------------------------------------DEBUT BODY -------------------------------------------*/
		
		/*Panel pour le centre de la fenêtre */
		JPanel pBody = new JPanel();
		pBody.setBackground(Color.white);
		pBody.setBorder(new EmptyBorder(20, 0, 20, 0));
		
		/*-----------------------------------Caption Gauche----------------------------*/
		/*Panel contenant le panel des boutons "+" ,"ajouterCategorie", "supprimerCategorie" */
		JPanel pCaptionG = new JPanel();
		pCaptionG.setBackground(Color.white);
		pCaptionG.setLayout(new BorderLayout());
		pCaptionG.setPreferredSize(new Dimension(680, 40));
		
		/* Panel contenant les boutons "+" ,"ajouterCategorie", "supprimerCategorie"  */
		JPanel pAjout = new JPanel();
		pAjout.setBackground(Color.white);
		
		/*Ajout des boutons au Panel*/
		pAjout.add(bouAjout);
		pAjout.add(bouAjoutCate);
		pAjout.add(bouSuppCate);
		
		/*Ajout du Panel de bouton au Panel de gauche au dessus du tableau */
		pCaptionG.add(pAjout);
		
		
		/*---------------------------------Caption Droit----------------------------------------*/
		/*Panel contenant le panel des boutons "tri simple" ,"tri second ", "tri trois" */
		JPanel pCaptionD = new JPanel();
		pCaptionD.setBackground(Color.white);
		pCaptionD.setBorder(new EmptyBorder(0, 150, 0, 0)); 
		pCaptionD.setPreferredSize(new Dimension(775, 40));
		
		/*Initialisation des panels contenant les boutons */
		JPanel pTriSimple = new JPanel();
		pTriSimple.setBackground(Color.white);
		
		JPanel pTriSecond = new JPanel();
		pTriSecond.setBackground(Color.white);
		
		JPanel pTriTrois = new JPanel();
		pTriTrois.setBackground(Color.white);
		
		/* Ajout des boutons à leurs panels */
		pTriSimple.add(bouTriSimple);
		pTriSecond.add(bouTriInterm);
		pTriTrois.add(bouTriResume);
		
		/*Ajout des Panles au Panel droit*/
		pCaptionD.add(pTriSimple, "West");
		pCaptionD.add(pTriSecond);
		pCaptionD.add(pTriTrois, "East");
		
		/*---------------------------------Caption -------------------------------------------*/
		
		/* Panel contenant tous les boutons au dessus du tableau */
		JPanel pCaption = new JPanel();
		pCaption.setBackground(Color.white);
		
		/* Ajout du Panel droit et gauche */
		pCaption.add(pCaptionG);
		pCaption.add(pCaptionD);
		
		/* Ajout du Panel général au Panel Body (centre de la fenêtre) */
		pBody.add(pCaption, "North");
		
		
		/*---------------------------------Table------------------------------------------------*/
		
		/*initialisation du pseudo tableau */
		pTableau.setBackground(Color.black);
		
		/* Ajout du Panel dans le Panel avec scroll bar */
		scroll.setViewportView(pTableau);
		scroll.setPreferredSize(new Dimension(1180, 530));
		
		/*Ajout au body de la scroll */
		pBody.add(scroll, "Center");
		
		/*Ajout du body dans la fenetre */
		add(pBody);
	}

	/*-----------------------------GETTERS ET SETTERS --------------------------------------------*/
	public JPanel getpTableau() {
		return pTableau;
	}


	public void setpTableau(JPanel pTableau) {
		this.pTableau = pTableau;
	}


	public JButton getBouTriSimple() {
		return bouTriSimple;
	}


	public void setBouTriSimple(JButton bouTriSimple) {
		this.bouTriSimple = bouTriSimple;
	}


	public JButton getBouTriInterm() {
		return bouTriInterm;
	}


	public void setBouTriInterm(JButton bouTriSecond) {
		this.bouTriInterm = bouTriSecond;
	}


	public JButton getBouTriResume() {
		return bouTriResume;
	}


	public void setBouTriResume(JButton bouTriTrois) {
		this.bouTriResume = bouTriTrois;
	}


	public JButton getBouAjout() {
		return bouAjout;
	}


	public void setBouAjout(JButton bouAjout) {
		this.bouAjout = bouAjout;
	}


	public JButton getBouQuitter() {
		return bouQuitter;
	}


	public void setBouQuitter(JButton bouQuitter) {
		this.bouQuitter = bouQuitter;
	}


	public JButton getBouBilan() {
		return bouBilan;
	}


	public void setBouBilan(JButton bouBilan) {
		this.bouBilan = bouBilan;
	}


	public JButton getBouAjoutCate() {
		return bouAjoutCate;
	}


	public void setBouAjoutCate(JButton bouAjoutCate) {
		this.bouAjoutCate = bouAjoutCate;
	}


	public JButton getBouSuppCate() {
		return bouSuppCate;
	}


	public void setBouSuppCate(JButton bouSuppCate) {
		this.bouSuppCate = bouSuppCate;
	}
	
}


class QuitterListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Fin Prog");
		System.exit(0);
	}
}


package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controleur.VoirBilan;
import model.Categories;
import model.ListeTaches;

public class FenetreBilan extends JFrame
{	
	private JPanel pTableau  = new JPanel();
	
	private JLabel lPourcentRealise = new JLabel("Taches réalisés : ");
	private JLabel lPourcentRetard = new JLabel("Taches réaliés en retard : ");
	private JLabel lPourcentEnCours = new JLabel("Tache en cours : ");
	
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	private JFormattedTextField dateDebBilan = new JFormattedTextField(format);
	private JFormattedTextField dateFinBilan = new JFormattedTextField(format);
	
	private JButton bouQuitter = new JButton("Retour");
	private JButton bouValider = new JButton("Voir");
	
	JScrollPane scroll = new JScrollPane();
	
	private JLabel lErreur = new JLabel("");

		
	public FenetreBilan(ListeTaches list) {
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(1200,800) ;
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		/* Panel contenant le bouton Quitter dans le head de la fenêtre */
		JPanel pQuitter = new JPanel();
		pQuitter.setBackground(Color.white);
		pQuitter.setBorder(new EmptyBorder(0, 60, 0, 10));
		
		/* Ajout des boutons à leur panel respectif */
		bouQuitter.addActionListener(new QuitBilanListener(this));
		pQuitter.add(bouQuitter);
		
		/* Ajout des Panel au panel contenant les boutons du head */
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
		
		
		/*---------------------------------Table------------------------------------------------*/
		/* Panel au dessus du tableau */
		JPanel pCaption = new JPanel();
		pCaption.setBackground(Color.white);
		pCaption.setPreferredSize(new Dimension(1180,90));
		
		/* Panel contenant le formulaire */
		JPanel pForm = new JPanel();
		pForm.setBackground(Color.white);
		pForm.setPreferredSize(new Dimension(1180,40));
		
		/*Formulaire */
		JLabel lPeriodeBilan = new JLabel("Date de début et date de fin de la période de bilan");
		Font fontLPeriodeBilan = new Font("Arial",Font.PLAIN,15);
		lPeriodeBilan.setFont(fontLPeriodeBilan);
		
		dateDebBilan.setPreferredSize(new Dimension(150,35));
		dateFinBilan.setPreferredSize(new Dimension(150,35));
		
		bouValider.addActionListener(new VoirBilan(list, this));
		
		/*Message d'erreur s'affichant si date incorrect*/
		lErreur.setForeground(Color.red);
		
		pForm.add(lPeriodeBilan);
		pForm.add(dateDebBilan);
		pForm.add(dateFinBilan);
		pForm.add(bouValider);
		pForm.add(lErreur);
		
		/*Initialisation des Panels pour les pourcentages*/
		JPanel pPourcent = new JPanel();
		pPourcent.setBackground(Color.white);
		pPourcent.setPreferredSize(new Dimension(1180,40));
		
		JPanel pPourcentRealise = new JPanel();
		pPourcentRealise.setBackground(Color.white);
		pPourcentRealise.setPreferredSize(new Dimension(300,40));
		
		JPanel pPourcentRetard = new JPanel();
		pPourcentRetard.setBackground(Color.white);
		pPourcentRetard.setPreferredSize(new Dimension(300,40));
		
		JPanel pPourcentEnCours = new JPanel();
		pPourcentEnCours.setBackground(Color.white);
		pPourcentEnCours.setPreferredSize(new Dimension(300,40));
		
		lPourcentRealise.setForeground(Color.green);
		lPourcentRetard.setForeground(Color.red);
		
		/*Ajout des JLabel dans leur Panel respectif*/
		pPourcentRealise.add(lPourcentRealise);
		pPourcentRetard.add(lPourcentRetard);
		pPourcentEnCours.add(lPourcentEnCours);
		
		/* Ajout des Panel dans le Panel pourcentage */
		pPourcent.add(pPourcentRealise);
		pPourcent.add(pPourcentRetard);
		pPourcent.add(pPourcentEnCours);
		
		pCaption.add(pForm);
		pCaption.add(pPourcent);
		
		/* Initialisation du tableau */
		pTableau.setBackground(Color.white);
		pTableau.setBackground(Color.black);
		
		/*scroll bar contenant le tableau */
		scroll.setViewportView(pTableau);
		scroll.setPreferredSize(new Dimension(1180,490));
		
		pBody.add(pCaption,"North");
		pBody.add(scroll, "Center");
		add(pBody);
		
	}


	public JLabel getlErreur() {
		return lErreur;
	}


	public void setlErreur(JLabel lErreur) {
		this.lErreur = lErreur;
	}


	public JPanel getpTableau() {
		return pTableau;
	}


	public void setpTableau(JPanel pTableau) {
		this.pTableau = pTableau;
	}


	public JLabel getlPourcentRealise() {
		return lPourcentRealise;
	}


	public void setlPourcentRealise(JLabel lPourcentRealise) {
		this.lPourcentRealise = lPourcentRealise;
	}


	public JLabel getlPourcentRetard() {
		return lPourcentRetard;
	}


	public void setlPourcentRetard(JLabel lPourcentRetard) {
		this.lPourcentRetard = lPourcentRetard;
	}


	public JLabel getlPourcentEnCours() {
		return lPourcentEnCours;
	}


	public void setlPourcentEnCours(JLabel lPourcentEnCours) {
		this.lPourcentEnCours = lPourcentEnCours;
	}


	public JFormattedTextField getDateDebBilan() {
		return dateDebBilan;
	}


	public void setDateDebBilan(JFormattedTextField dateDebBilan) {
		this.dateDebBilan = dateDebBilan;
	}


	public JFormattedTextField getDateFinBilan() {
		return dateFinBilan;
	}


	public void setDateFinBilan(JFormattedTextField dateFinBilan) {
		this.dateFinBilan = dateFinBilan;
	}


	public JButton getBouQuitter() {
		return bouQuitter;
	}


	public void setBouQuitter(JButton bouQuitter) {
		this.bouQuitter = bouQuitter;
	}


	public JButton getBouValider() {
		return bouValider;
	}


	public void setBouValider(JButton bouValider) {
		this.bouValider = bouValider;
	}
		
	
}

class QuitBilanListener implements ActionListener{
	
	private FenetreBilan fen;
	
	public QuitBilanListener(FenetreBilan f)
	{
		this.fen = f;
	}
	
    public void actionPerformed(ActionEvent e) {
       System.out.println("Fin Bilan");
       fen.dispose();
    }
 }

package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controleur.*;
import model.*;

public class FenetreFormTache extends JFrame
{ 
	private JRadioButton choixTacheP = new JRadioButton("Tâche ponctuelle",true);
	private JRadioButton choixTacheLC = new JRadioButton("Tâche long cours");
	private ButtonGroup bg = new ButtonGroup();
	
	public JTextArea attention = new JTextArea("Si vous avez choisi la tâche ponctuelle, ne modifiez pas le champ date de début");
	
	private JLabel labelNom = new JLabel("Nom ");
	private JTextArea tNomTache = new JTextArea("Votre tâche");
	
	private JComboBox comboCategorie = new JComboBox();
	private JLabel lCat= new JLabel("Catégorie");
	
	
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	private JLabel lDateD= new JLabel("Date de début ");
	private JFormattedTextField jtfDateDeb = new JFormattedTextField(format);
	
	private JLabel lDateF= new JLabel("Date de fin ");
	private JFormattedTextField jtfDateFin = new JFormattedTextField(format);
	
	private JComboBox comboImportance = new JComboBox();
	private JLabel lImprt= new JLabel("Importance ");
	
	private JButton bouValider = new JButton("Valider");
	private JButton bouQuit = new JButton("Retour");
	private JFrame fen = this;
	
	private Categories listeCateg = new Categories();
	
	public FenetreFormTache(ListeTaches list, Application app)
	{
		
		
		
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(650,520) ;
		setLocation(200,200) ;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		
		/*Panel head*/
		JPanel pTitre = new JPanel();
		pTitre.setBorder(new EmptyBorder(20,30,10,30));
		pTitre.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Formulaire de création de tache",JLabel.CENTER);
		Font fontTitre = new Font("Arial",Font.BOLD,20);
		titre.setFont(fontTitre);
		
		pTitre.add(titre);
		
		add(pTitre, "North");
		
		/*Panel Body*/
		JPanel pBody = new JPanel();
		
		JPanel pRadioBouton = new JPanel();
		pRadioBouton.setPreferredSize(new Dimension(640,35));
		
		/*Ajout bouton radio au bouton groupe qui permet de n'en sélectionner
		 * qu'un à la fois
		 */
		bg.add(choixTacheP);
		bg.add(choixTacheLC);
		pRadioBouton.add(choixTacheP);
		pRadioBouton.add(choixTacheLC);
		
		pBody.add(pRadioBouton);
		
		/* Panel contenant label attention qui avertit l'utilisateur*/
		JPanel pAttention = new JPanel();
		pAttention.setPreferredSize(new Dimension(640,60));
		
		attention.setPreferredSize(new Dimension(635,50));
		attention.setEditable(false);
		attention.setLineWrap(true);
		attention.setWrapStyleWord(true);
		Font fontAttention = new Font("Arial",Font.PLAIN,20);
		attention.setFont(fontAttention);
		
		pAttention.add(attention);
		pBody.add(pAttention);
		
		/* Panel nom*/
		JPanel pNom = new JPanel();
		pNom.setPreferredSize(new Dimension(640,60));
		
		tNomTache.setPreferredSize(new Dimension(580,50));
		tNomTache.setLineWrap(true);
		tNomTache.setWrapStyleWord(true);
		
		Font fontLabelNom = new Font("Arial",Font.PLAIN,15);
		labelNom.setFont(fontLabelNom);
		pNom.add(labelNom);
		pNom.add(tNomTache);
		
		pBody.add(pNom);
		
		/*Panel catégorie*/
		JPanel pCategorie = new JPanel();
		pCategorie.setPreferredSize(new Dimension(640,60));
		
		/*recupération dynamique des catégories*/
		comboCategorie.setPreferredSize(new Dimension(250,50));
		Hashtable<Integer, String> hash = listeCateg.getList();
		for (int i = 0; i < listeCateg.getCursor(); i++) {
			if(hash.containsKey(i)){
				comboCategorie.addItem(i+":"+hash.get(i));
			}
		}
		
		Font fontLCat = new Font("Arial",Font.PLAIN,15);
		lCat.setFont(fontLCat);
		pCategorie.add(lCat);
		pCategorie.add(comboCategorie);
		
		pBody.add(pCategorie);
		
		/*Panel date debut*/
		JPanel pDateDebut = new JPanel();
		pDateDebut.setPreferredSize(new Dimension(640,40));
		
		jtfDateDeb.setPreferredSize(new Dimension(150,35));
		
		Font fontLDateD = new Font("Arial",Font.PLAIN,15);
		lDateD.setFont(fontLDateD);
		pDateDebut.add(lDateD);
		pDateDebut.add(jtfDateDeb);
		
		pBody.add(pDateDebut);
		
		/*Panel date fin*/
		JPanel pDateFin = new JPanel();
		pDateFin.setPreferredSize(new Dimension(640,40));
		
		jtfDateFin.setPreferredSize(new Dimension(150,35));
		
		Font fontLDateF = new Font("Arial",Font.PLAIN,15);
		lDateF.setFont(fontLDateF);
		pDateFin.add(lDateF);
		pDateFin.add(jtfDateFin);
		
		pBody.add(pDateFin);
		
		/*Panel importance*/
		JPanel pImportance = new JPanel();
		pImportance.setPreferredSize(new Dimension(640,40));
		
		comboImportance.setPreferredSize(new Dimension(150,35));
		comboImportance.addItem("Petite");
		comboImportance.addItem("Moyenne");
		comboImportance.addItem("Importante");
		
		
		Font fontLImp = new Font("Arial",Font.PLAIN,15);
		lImprt.setFont(fontLImp);		
		pImportance.add(lImprt);
		pImportance.add(comboImportance);
		
		pBody.add(pImportance);
		
		/*Panel boutons*/
		JPanel pBouQuit = new JPanel();
		pBouQuit.setPreferredSize(new Dimension(310,40));
		
		JPanel pBouValider = new JPanel();
		pBouValider.setPreferredSize(new Dimension(310,40));
		
		bouQuit.addActionListener(new QuitFormAjoutListener(this));
		pBouQuit.add(bouQuit);
		pBody.add(pBouQuit);
		
		pBouValider.add(bouValider);
		pBody.add(pBouValider);

		add(pBody);
		
		
		/* Listener bouton*/
		bouValider.addActionListener(new ValiderFormAjoutTache(list, app, this));

	}
	
	

public JTextArea getAttention() {
		return attention;
	}



	public void setAttention(JTextArea attention) {
		this.attention = attention;
	}



public JTextArea gettNomTache() {
		return tNomTache;
	}



	public void settNomTache(JTextArea tNomTache) {
		this.tNomTache = tNomTache;
	}



public JRadioButton getChoixTacheP() {
		return choixTacheP;
	}



	public void setChoixTacheP(JRadioButton choixTacheP) {
		this.choixTacheP = choixTacheP;
	}



	public JRadioButton getChoixTacheLC() {
		return choixTacheLC;
	}



	public void setChoixTacheLC(JRadioButton choixTacheLC) {
		this.choixTacheLC = choixTacheLC;
	}



	public JComboBox getComboCategorie() {
		return comboCategorie;
	}



	public void setComboCategorie(JComboBox comboCategorie) {
		this.comboCategorie = comboCategorie;
	}



	public JFormattedTextField getJtfDateDeb() {
		return jtfDateDeb;
	}



	public void setJtfDateDeb(JFormattedTextField jtfDateDeb) {
		this.jtfDateDeb = jtfDateDeb;
	}



	public JFormattedTextField getJtfDateFin() {
		return jtfDateFin;
	}



	public void setJtfDateFin(JFormattedTextField jtfDateFin) {
		this.jtfDateFin = jtfDateFin;
	}



	public JComboBox getComboImportance() {
		return comboImportance;
	}



	public void setComboImportance(JComboBox comboImportance) {
		this.comboImportance = comboImportance;
	}



	public JButton getBouValider() {
		return bouValider;
	}



	public void setBouValider(JButton bouValider) {
		this.bouValider = bouValider;
	}



	public JButton getBouQuit() {
		return bouQuit;
	}



	public void setBouQuit(JButton bouQuit) {
		this.bouQuit = bouQuit;
	}



	public JFrame getFen() {
		return fen;
	}



	public void setFen(JFrame fen) {
		this.fen = fen;
	}



class QuitFormAjoutListener implements ActionListener{
	
	private JFrame fen;
	
	public QuitFormAjoutListener(JFrame f)
	{
		this.fen = f;
	}
	
    public void actionPerformed(ActionEvent e) {
       System.out.println("Fin Form Ajout");
       fen.dispose();
    }
 }
}

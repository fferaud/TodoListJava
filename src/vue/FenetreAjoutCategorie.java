package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

public class FenetreAjoutCategorie extends JFrame
{ 	
	private JLabel labelNouvelleCate = new JLabel("Votre nouvelle catégorie");
	private JTextArea tNouvelleCate = new JTextArea("Nouvelle catégorie");
	
	private JButton bouValider = new JButton("Ajouter");
	private JButton bouQuit = new JButton("Retour");
	private JFrame fen = this;
	
	
	
	public FenetreAjoutCategorie(Categories cat)
	{
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(650,320) ;
		setLocation(200,200) ;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		
		/* Panel head*/
		JPanel pTitre = new JPanel();
		pTitre.setBackground(Color.white);
		pTitre.setBorder(new EmptyBorder(20,30,10,30));
		pTitre.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Création de tache",JLabel.CENTER);
		Font fontTitre = new Font("Arial",Font.BOLD,20);
		titre.setFont(fontTitre);
		
		pTitre.add(titre);
		
		add(pTitre, "North");
		
		/* Panel body*/
		JPanel pBody = new JPanel();
		pBody.setBackground(Color.white);
		
		
		/*Panel contenant Label donnant information à l'utilisateur*/
		JPanel pAttention = new JPanel();
		pAttention.setBackground(Color.white);
		pAttention.setPreferredSize(new Dimension(640,60));
		
		JTextArea attention = new JTextArea("Entrez le nom de la nouvelle catégorie et appuyez sur \"Ajouter\"");
		attention.setPreferredSize(new Dimension(635,50));
		attention.setEditable(false);
		attention.setLineWrap(true);
		attention.setWrapStyleWord(true);
		Font fontAttention = new Font("Arial",Font.PLAIN,20);
		attention.setFont(fontAttention);
		
		pAttention.add(attention);
		pBody.add(pAttention);
		
		/* Panel avec le formulaire pour la nouvelle catégorie*/
		JPanel pNouvelleCate = new JPanel();
		pNouvelleCate.setBackground(Color.white);
		pNouvelleCate.setPreferredSize(new Dimension(640,60));
		
		tNouvelleCate.setPreferredSize(new Dimension(580,50));
		tNouvelleCate.setLineWrap(true);
		tNouvelleCate.setWrapStyleWord(true);
		tNouvelleCate.setBackground(Color.lightGray);
		
		Font fontLabelNouvelleCate = new Font("Arial",Font.PLAIN,15);
		labelNouvelleCate.setFont(fontLabelNouvelleCate);
		pNouvelleCate.add(labelNouvelleCate);
		pNouvelleCate.add(tNouvelleCate);
		
		pBody.add(pNouvelleCate);
		
		/*Panel boutons*/
		JPanel pBouQuit = new JPanel();
		pBouQuit.setBackground(Color.white);
		pBouQuit.setPreferredSize(new Dimension(310,40));
		
		JPanel pBouValider = new JPanel();
		pBouValider.setBackground(Color.white);
		pBouValider.setPreferredSize(new Dimension(310,40));
		
		bouQuit.addActionListener(new QuitGestionAjoutListener(this));
		pBouQuit.add(bouQuit);
		pBody.add(pBouQuit);
		
		
		pBouValider.add(bouValider);
		pBody.add(pBouValider);

		add(pBody);
		
		/*Listener sur boutons*/
		bouValider.addActionListener(new ValiderFormAjoutCateg(cat, this));
	}
	
	


public JTextArea gettNouvelleCate() {
		return tNouvelleCate;
	}




	public void settNouvelleCate(JTextArea tNouvelleCate) {
		this.tNouvelleCate = tNouvelleCate;
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




class QuitGestionAjoutListener implements ActionListener{
	
	private FenetreAjoutCategorie fen;
	
	public QuitGestionAjoutListener(FenetreAjoutCategorie f)
	{
		this.fen = f;
	}
	
    public void actionPerformed(ActionEvent e) {
       System.out.println("Fin Form Ajout");
       fen.dispose();
    }
 }
}

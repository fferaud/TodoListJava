package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controleur.ValiderFormSupprCateg;
import model.Categories;

public class FenetreSuppCategorie extends JFrame
{ 	
	private JComboBox comboCategorie = new JComboBox();
	private JLabel lCat= new JLabel("Catégorie");
	
	private JButton bouValider = new JButton("Supprimer");
	private JButton bouQuit = new JButton("Retour");
	private JFrame fen = this;
	
	private Categories listeCateg = new Categories();
	
	
	
	public FenetreSuppCategorie(Categories cat)
	{
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(650,520) ;
		setLocation(200,200) ;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		
		/* Panel head*/
		JPanel pTitre = new JPanel();
		pTitre.setBackground(Color.white);
		pTitre.setBorder(new EmptyBorder(20,30,10,30));
		pTitre.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Suppression d'une catégorie",JLabel.CENTER);
		Font fontTitre = new Font("Arial",Font.BOLD,20);
		titre.setFont(fontTitre);
		
		pTitre.add(titre);
		
		add(pTitre, "North");
		
		/* Panel body*/
		JPanel pBody = new JPanel();
		pBody.setBackground(Color.white);
		
		/* Panel contenant Label donnant information*/
		JPanel pAttention = new JPanel();
		pAttention.setBackground(Color.white);
		pAttention.setPreferredSize(new Dimension(640,60));
		
		JTextArea attention = new JTextArea("Choisissez la catégorie que vous voulez supprimer et appuyez sur \"Supprimer\"");
		attention.setPreferredSize(new Dimension(635,50));
		attention.setEditable(false);
		attention.setLineWrap(true);
		attention.setWrapStyleWord(true);
		Font fontAttention = new Font("Arial",Font.PLAIN,20);
		attention.setFont(fontAttention);
		
		pAttention.add(attention);
		pBody.add(pAttention);
		
		/* Panel contenant le comboBox */
		JPanel pCategorie = new JPanel();
		pCategorie.setBackground(Color.white);
		pCategorie.setPreferredSize(new Dimension(640,60));
		
		comboCategorie.setPreferredSize(new Dimension(250,35));
		
		/*récupération dynamique des catégories*/
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
		
		/* Panel bouton */
		JPanel pBouQuit = new JPanel();
		pBouQuit.setBackground(Color.white);
		pBouQuit.setPreferredSize(new Dimension(310,40));
		
		JPanel pBouValider = new JPanel();
		pBouValider.setBackground(Color.white);
		pBouValider.setPreferredSize(new Dimension(310,40));
		
		bouQuit.addActionListener(new QuitGestionSuppListener(this));
		pBouQuit.add(bouQuit);
		pBody.add(pBouQuit);
		
		
		pBouValider.add(bouValider);
		pBody.add(pBouValider);

		add(pBody);
		
		/*Listener sur le bouton valider*/
		bouValider.addActionListener(new ValiderFormSupprCateg(cat, this));
	}
	
	



	public JComboBox getComboCategorie() {
		return comboCategorie;
	}

	public void setComboCategorie(JComboBox comboCategorie) {
		this.comboCategorie = comboCategorie;
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

class QuitGestionSuppListener implements ActionListener{
	
	private FenetreSuppCategorie fen;
	
	public QuitGestionSuppListener(FenetreSuppCategorie f)
	{
		this.fen = f;
	}
	
    public void actionPerformed(ActionEvent e) {
       System.out.println("Fin Form Ajout");
       fen.dispose();
    }
 }
}


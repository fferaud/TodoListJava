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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controleur.Application;
import controleur.ValiderFormModifTache;
import model.Categories;
import model.ListeTaches;

public class FenetreModifTache extends JFrame {
	
	private JLabel labelNom = new JLabel("Nom ");
	private JTextArea tNomTache = new JTextArea();
	
	private JComboBox comboCategorie = new JComboBox();
	private JLabel lCat= new JLabel("Catégorie");
	
	
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	private JLabel lDateD= new JLabel("Date de début ");
	private JFormattedTextField jtfDateDeb = new JFormattedTextField();
	
	private JLabel lDateF= new JLabel("Date de fin ");
	private JFormattedTextField jtfDateFin = new JFormattedTextField(format);
	
	private JButton bouValider = new JButton("Valider");
	private JButton bouQuit = new JButton("Retour");
	private JFrame fen = this;
	
	private Categories listeCateg = new Categories();
	private int idTache;
	private ListeTaches list;
	private Application app;
	
	/* On recupère l'id de la Tache et la list pour pouvoir retrouver la tâche
	 * et l'application pour pouvoir refresh la fenêtre princiaple
	 */
	public FenetreModifTache(int idTache, ListeTaches list, Application app)
	{
		this.idTache = idTache;
		this.list = list;
		this.app = app;
		
		/* Set les valeurs des champs des formulaires avec la valeur de la tache que l'on veut modifier */
		tNomTache.setText(list.get(idTache).getTitre());
		int j = 0;
		Hashtable<Integer, String> hash = listeCateg.getList();
		for (int i = 0; i < listeCateg.getCursor(); i++) {
			if(hash.containsKey(i)){
				comboCategorie.addItem(i+":"+hash.get(i));
				if(list.get(idTache).getIdCategorie() != i){
					j = i;
				}
			}
		}
		comboCategorie.setSelectedItem(j+":"+hash.get(j));
		
		jtfDateFin.setText(format.format(list.get(idTache).getEcheance()));
		
		/* Initialisation de la fenêtre*/
		setTitle("TodoList FERAUD Fabien et NOVELLON Florian");
		setSize(650,350);
		setLocation(200,200) ;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		
		/* Panel head*/
		JPanel pTitre = new JPanel();
		pTitre.setBorder(new EmptyBorder(20,30,10,30));
		pTitre.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Formulaire de modification de tache",JLabel.CENTER);
		Font fontTitre = new Font("Arial",Font.BOLD,20);
		titre.setFont(fontTitre);
		
		pTitre.add(titre);
		
		add(pTitre, "North");
		
		/*Panel Body*/
		JPanel pBody = new JPanel();
		
		/*Panel nom*/
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
		
		comboCategorie.setPreferredSize(new Dimension(250,50));
		
		
		Font fontLCat = new Font("Arial",Font.PLAIN,15);
		lCat.setFont(fontLCat);
		pCategorie.add(lCat);
		pCategorie.add(comboCategorie);
		
		pBody.add(pCategorie);
		
		/*Panel date fin */
		JPanel pDateFin = new JPanel();
		pDateFin.setPreferredSize(new Dimension(640,40));
		
		jtfDateFin.setPreferredSize(new Dimension(150,35));
		
		Font fontLDateF = new Font("Arial",Font.PLAIN,15);
		lDateF.setFont(fontLDateF);
		pDateFin.add(lDateF);
		pDateFin.add(jtfDateFin);
		
		pBody.add(pDateFin);
		
		/*Panel boutons*/
		JPanel pBouQuit = new JPanel();
		pBouQuit.setPreferredSize(new Dimension(310,40));
		
		JPanel pBouValider = new JPanel();
		pBouValider.setPreferredSize(new Dimension(310,40));
		
		bouQuit.addActionListener(new QuitFormModifTabListener(this));
		pBouQuit.add(bouQuit);
		pBody.add(pBouQuit);
		
		
		pBouValider.add(bouValider);
		pBody.add(pBouValider);

		add(pBody);
		
		
		/*Listener sur bouton*/
		bouValider.addActionListener(new ValiderFormModifTache(idTache, list, app, this));
	}
	
	
	
	public JFormattedTextField getJtfDateFin()
	{
		return this.jtfDateFin;
	}
	
	public JTextArea getTNomTache()
	{
		return this.tNomTache;
	}
	
	
	
	public JTextArea gettNomTache() {
		return tNomTache;
	}

	public void settNomTache(JTextArea tNomTache) {
		this.tNomTache = tNomTache;
	}

	public JComboBox getComboCategorie() {
		return comboCategorie;
	}

	public void setComboCategorie(JComboBox comboCategorie) {
		this.comboCategorie = comboCategorie;
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}

	public JFormattedTextField getJtfDateDeb() {
		return jtfDateDeb;
	}

	public void setJtfDateDeb(JFormattedTextField jtfDateDeb) {
		this.jtfDateDeb = jtfDateDeb;
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

	public void setJtfDateFin(JFormattedTextField jtfDateFin) {
		this.jtfDateFin = jtfDateFin;
	}



	class QuitFormModifTabListener implements ActionListener
	{
		
		private FenetreModifTache fen;
		
		public QuitFormModifTabListener(FenetreModifTache f)
		{
			this.fen = f;
		}
		
	    public void actionPerformed(ActionEvent e) {
	       System.out.println("Fin Form Ajout");
	       fen.dispose();
	    }
	 }
	
 }






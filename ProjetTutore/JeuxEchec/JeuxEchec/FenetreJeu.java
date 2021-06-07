package JeuxEchec;

import javax.swing.JFrame;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class FenetreJeu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Echiquier du jeu, contient le tableau de case.
	 */
	private Echiquier Plateau; // echiquier
	private JLabel[][] tab; // tableau de JLabels

	private JPanel panelSettings = new JPanel();
	private JPanel panelPlateau = new JPanel();
	GridLayout gridLayout1 = new GridLayout();
    private JPanel WhitePanel = new JPanel();
	private JPanel BlackPanel = new JPanel();
	private JButton startbutton = new JButton();
	private JTextField Infojeu = new JTextField();
	private JButton boutonReset = new JButton();
	
	
	/**
	 * Constructeur, appelle méthode JBInit
	 */
	public FenetreJeu() 
	{
		try {InitComposant();} catch (Exception plateau) {plateau.printStackTrace();
		}
	}
	/**
	 * initialise tout les éléments (couleurs, positions...)
	 */
	private void InitComposant() {

		tab = new JLabel[8][8]; // création du tableau de JLabel
		Plateau = new Echiquier(); // création de l'échiquier
        /*
         * ici on a principalement les initialisation des case 
         * ainsi que les couleurs des case et le rectangle du panneau de controle
         * et les bouton de controle
         */
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(700, 550));
		this.setTitle("JeuEchecs");
		panelSettings.setLayout(null);
		//specification des dimension de toute les element initialisees
		panelPlateau.setBounds(new Rectangle(5, 65, 550, 465));
		panelPlateau.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelPlateau.setLayout(gridLayout1);
		gridLayout1.setColumns(8);
		panelSettings.setBounds(new Rectangle(5, 10, 550, 45));
		panelSettings.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		boutonReset.setText("RESET");
		boutonReset.setBounds(new Rectangle(370, 10, 140, 30));
		Listeve list = new Listeve();
		//pour savoir ce qui ce passe avec les bouton de controle
		startbutton.addMouseListener(list);
		boutonReset.addMouseListener(list);
		WhitePanel.setBounds(new Rectangle(580, 70, 75, 480));
		WhitePanel.setLayout(new FlowLayout());
		BlackPanel.setBounds(new Rectangle(655, 65, 75, 475));
		BlackPanel.setLayout(new FlowLayout());
		gridLayout1.setRows(8);
		this.getContentPane().add(BlackPanel, null);
		this.getContentPane().add(WhitePanel, null);
		this.getContentPane().add(panelPlateau, null);
		panelSettings.add(boutonReset, null);
		panelSettings.add(Infojeu, null);
		panelSettings.add(startbutton, null);
		this.getContentPane().add(panelSettings, null);
		startbutton.setBounds(new Rectangle(15, 10, 130, 25));
		startbutton.setText("Start");
		Infojeu.setBounds(new Rectangle(160, 10, 215, 25));
		int i = 1;
		//dessin du plateau
		for (int li = 0; li < 8; li++) {
			i = i == 1 ? 0 : 1;
			for (int col = 0; col < 8; col++) {
				tab[col][li] = new JLabel(); 
				tab[col][li].setOpaque(true);
				panelPlateau.add(tab[col][li]); 
				tab[col][li].setOpaque(true);
				tab[col][li].setHorizontalAlignment(SwingConstants.CENTER);
				tab[col][li].addMouseListener(list); 
				if ((col + 1) % 2 == i)
					tab[col][li].setBackground(new Color(255, 255, 255));
				else
					tab[col][li].setBackground(new Color(100, 100, 100));

			}
		}

	}

	
	private class Listeve extends MouseAdapter {

		Piece mempiecetemp = null;
		ImageIcon memicotemp;
		int selectli;
		int selectcol;
		Position depart, arrivee;
		String CoulCtrl = "blanc";
		Position temp = null;



		/** methode s'excutant si l'on clique sur la surface de jeu. La methode determine ensuite ou est-ce que l'on cliquer
		 * et fait les action en consequence
		 *
		 */
		public void mouseClicked(MouseEvent maj) {
			// si on clique sur le bouton dÃ©buter
			if (maj.getSource() == startbutton) {
				/*initialise le champ texte, apelle la méthode start, et initialise toute les variables
				configpiece permet de initialiser les pieces selon une configuration predefinie
				2 pour la tour,3 pour le cavalier,4 pour le fou,5 pour la reine et 6 pour le roi
				*/
				char[] Configpiece = { '2', '3', '4', '5', '6', '4', '3', '2' };
				Infojeu.setText("Au tour des pieces blanches ");
				int aug = 1;
				startbutton.setEnabled(false);
				int ligne = 0;
				Plateau.start();
				String Icopath = "JeuxEchec/";
				char Coul = 'N';
				Piece base = null;
				Plateau.start(); 

				/* placement des images dans les cases de depart
				ici les image vont etre mises selon le chemin dans setIcon
				puis va etre place selon leur couleur et leur emplacement par rapport au ligne
				*/
				while (aug >= -1) {
					for (int i = 0; i <= 7; i++) {
						tab[i][ligne].setIcon(new ImageIcon(Icopath + Configpiece[i] + Coul + ".jpg"));
						switch(Configpiece[i])
						{case '2':base = new Tour(ligne < 5 ? "noir" : "blanc");break;
						case '3':base = new Cavalier(ligne < 5 ? "noir" : "blanc");break;						
						case '4':base= new Fou(ligne < 5 ? "noir" : "blanc");break;
						case '5':base = new Reine(ligne < 5 ? "noir" : "blanc");break;
						case '6':base = new Roi(ligne < 5 ? "noir" : "blanc");break;}
						Plateau.getCase(i, ligne).setPiece(base);
						tab[i][ligne + aug].setIcon(new ImageIcon(Icopath + '1' + Coul + ".jpg"));
						Plateau.getCase(i, ligne + aug).setPiece(new Pion(ligne < 5 ? "noir" : "blanc"));
						}Coul = 'B';aug -= 2;ligne = 7;
				}

			}
			/* si on clique sur le bouton reset
			les piece vont etre enlevees a partir du setPiece 
			rectivation du bouton start ainsi que la reconstruction des paneaux noir et blanc dans le plateau
			*/
			else if (maj.getSource() == boutonReset) {
				for (int li = 0; li < 8; li++) 
					for (int col = 0; col < 8; col++) {
						tab[col][li].setIcon(null);
						Plateau.getCase(col, li).setPiece(null);
						}
			    Infojeu.setText("");
				startbutton.setEnabled(true);
				Plateau.start();
				String CoulCtrl = "noir";
                WhitePanel.removeAll();
				WhitePanel.repaint();
				BlackPanel.removeAll();
				BlackPanel.repaint();
				}
               else if (maj.getSource() instanceof JLabel) 
            	//au moment du click sur une case
			    {
				for (int i = 0; i < 8; i++)
					//il faut savoir sur quel case on a cliquee
					for (int j = 0; j < 8; j++) 
						if (maj.getSource() == tab[j][i]) {
							selectli = i;
							selectcol = j;
						}
					//si on a cliqué sur une case non vide et que la memoire n'est pas vide
					if((Plateau.getCase(selectcol, selectli).getPiece() != null | mempiecetemp != null) )
					{
						//si la memoire est vide
						if(mempiecetemp == null )
						{
							//si c'est au tour de la Couleur de Ctrl à jouer
							if(Plateau.getCase(selectcol, selectli).getPiece().getCoul().equals(CoulCtrl)){
								//J'initialise la piece de la memoire a la piece sur laquelle on a cliqué
								mempiecetemp = Plateau.getCase(selectcol, selectli).getPiece();
								memicotemp = (ImageIcon)tab[selectcol][selectli].getIcon();
								temp = new Position(selectcol,selectli);
								//couleur de selection de case 
								tab[selectcol][selectli].setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0),5));
							}
							
						}
						else
						{
							//crée un déplacement
							Deplacement deplacement = new Deplacement(temp, new Position(selectcol,selectli));
							//vérifie si le chemin et possible et si le pion peut manger une piècee
							if ((mempiecetemp.Verifdep(deplacement) && Plateau.dep(deplacement)) | Plateau.posscatch(deplacement))
							{
								//je créer un jLabel avec l'image de la pièce a prendre
								JLabel prendre = new JLabel(tab[selectcol][selectli].getIcon());
								prendre.setHorizontalAlignment(SwingConstants.CENTER);
                                /* je vérifie si la piècece qui est prise est un roi, si oui le jeu est terminé et L'utilisateurs 
								peut choisir si il veut continuer a jouer ou non*/
								if(Plateau.getCase(selectcol, selectli).getPiece() instanceof Roi)
								{									
										for (int li = 0; li < 8; li++) 
											for (int col = 0; col < 8; col++) {
												tab[col][li].setIcon(null);
												Plateau.getCase(col, li).setPiece(null);}}										
								else//si on dépose la piece sur une case vide
								{
									Plateau.getCase(temp.getCol(), temp.getLi()).setPiece(null);
									tab[temp.getCol()][temp.getLi()].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),0));
									tab[selectcol][selectli].setIcon(memicotemp);
									Plateau.getCase(selectcol, selectli).setPiece(mempiecetemp);
									tab[temp.getCol()][temp.getLi()].setIcon(null);
	                                mempiecetemp = null;
									memicotemp = null;
									temp = null;
									CoulCtrl = CoulCtrl.equals("blanc") ? "noir" : "blanc";
									Infojeu.setText("Au tour des pieces " + CoulCtrl);
								}
							}
							else
							{
								//ici on met a zero la case 
								tab[temp.getCol()][temp.getLi()].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0),0));
								mempiecetemp = null;
								memicotemp = null;
								temp = null;
                            }}}}}}
	// affiche l'interface
	public static void main(String[] args) {
		FenetreJeu game = new FenetreJeu();
		game.setVisible(true);
		game.setLocation(100, 130);
		game.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
}
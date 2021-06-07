package JeuxEchec;

public class Echiquier implements Initjeu{
	/**
	 * Tableau des cases sur lesquels se situent les pi�ces
	 */
	private Case[][] zone;
	
	/** 
	 * Constructeur classe Echiquier, cr�e un tableau en 8x8 qui ne contient aucune pi�ce.
	 * @param Prend en parametre la Couleur du cavalier
	 * 
	 */
	public Echiquier() {
		zone= new Case[8][8];
		for (int ctr = 0; ctr <= 7; ctr++)
			for (int ctr1 = 0; ctr1 <= 7; ctr1++)
				zone[ctr][ctr1] = new Case();
			
	}
	public void start() {
		int ligne = 7;
		/*Je fais les instructions deux fois, au premier passage, ligne est �gal � 7 et la Couleur � noir,
		 * et au deuxi�me passage, la Couleur est blanche et la ligne est �gal � 0.
		 */
		for (String Coul = "noir" ; !Coul.equals("blanc"); Coul = "blanc", ligne = 0){
			//On initialise les pi�ces de la premi�re rang� (fou , cavalier etc...)
			zone[0][ligne].setPiece(new Tour(Coul));
			zone[1][ligne].setPiece(new Cavalier(Coul));
			zone[2][ligne].setPiece(new Fou(Coul));
			zone[3][ligne].setPiece(new Reine(Coul));
			zone[4][ligne].setPiece(new Roi(Coul));
			zone[5][ligne].setPiece(new Fou(Coul));
			zone[6][ligne].setPiece(new Cavalier(Coul));
			zone[7][ligne].setPiece(new Tour(Coul));
			//Je change de ligne, d�pendament de la Couleur que je suis en train de traiter.
			ligne += Coul.equals("noir") ? -1 : 1;
			//On initialise tout les pions.
			for (int ctr = 0; ctr <= 7; ctr++)
				zone[ctr][ligne].setPiece(new Pion(Coul));
		}
	}
	public Case getCase(int colonne, int ligne) {
		return zone[colonne][ligne];
	}
	public boolean posscatch(Deplacement deplacement) {
		//On v�rifie si la pi�ce est un pion ou non
		if(zone[deplacement.getDepart().getCol()][deplacement.getDepart().getLi()].getPiece() instanceof Pion)
		{
			//Initialise les variables et savoir la couleur de la pi�ce de d�but et de fin
			Case Arrive = zone[(int)deplacement.getArrivee().getCol()][(int)deplacement.getArrivee().getLi()];
			String CoulDepart = zone[(int)deplacement.getDepart().getCol()][(int)deplacement.getDepart().getLi()].getPiece().getCoul();
			
			//v�rifie si la pi�ce de fin existe et si la couleur est contraire � celle du d�but
			if(Arrive.estPris(CoulDepart.equals("blanc") ? "noir" : "blanc"))
				/*Je v�rifie si le d�placement est valide, 
				 *Le d�placement est valide si le produits du d�placement x et y donne 1 si la Coul de d�part est noir
				 *ou -1 si la pi�ce de d�part est blanche. 
				 */
				return (deplacement.getDepY() * Math.abs(deplacement.getDepX()) == (CoulDepart.equals("noir") ? 1 : -1));
		}
		return false;
		
	}
	/**
	 * Methode chemin possible, verifie si la piece peut faire le deplacement. Pour ce faire il verifie si le chemin
	 * est libre entre le depart et l'arrive.
	 * @param Deplacement d'une piece
	 * @return vrai ou faux si la piece peut faire le deplacement ou non
	 */
	public boolean dep(Deplacement deplacement) {
		Piece pieceDepart = zone[(int)deplacement.getDepart().getCol()][(int)deplacement.getDepart().getLi()].getPiece();
		
		/*deux condition fondamentale, que la case d'arriv�es sois libre ou qu'elle poss�de une pi�ce de Couleur
		contraire � celle de la pi�ce de d�part*/
		if (!zone[(int)deplacement.getArrivee().getCol()][(int)deplacement.getArrivee().getLi()].estPris(pieceDepart.getCoul().equals("blanc") ? "blanc" : "noir")
				| deplacement.is0()){
			if (!(pieceDepart instanceof Cavalier)){
				if(!(pieceDepart instanceof Pion)){
					//Je v�rifie que le d�placement est sup�rieur � un.
					if(!(Math.abs(deplacement.getDepX()) - Math.abs(deplacement.getDepY()) <= 1
							&& Math.abs(deplacement.getDepX()) + Math.abs(deplacement.getDepY()) <= 1)){

						/*bonX et bonY seront sois 0,  1 ou -1, ils indiquent l'incr�mentation que qu'on devra utiliser pour les valeurs X et Y pour 
						  v�rifier toute les cases entre le d�part et l'arriv�*/
						int bonX = deplacement.getDepX() == 0 ? 0 : (int)(deplacement.getArrivee().getCol() - deplacement.getDepart().getCol())
								/Math.abs((int)(deplacement.getArrivee().getCol() - deplacement.getDepart().getCol()));
				
						int bonY = deplacement.getDepY() == 0 ? 0 : (int)(deplacement.getArrivee().getLi() - deplacement.getDepart().getLi())
								/Math.abs((int)(deplacement.getArrivee().getLi() - deplacement.getDepart().getLi()));

						//V�rifie toutes les cases entre le d�but et la fin
						for (int ctrX = (int)deplacement.getDepart().getCol() + bonX, ctrY = (int)deplacement.getDepart().getLi() + bonY;
							ctrX != (int)deplacement.getArrivee().getCol() | ctrY != (int)deplacement.getArrivee().getLi();
							ctrX += bonX, ctrY += bonY){
							if (zone[ctrX][ctrY].estPris()){
								return false;
							}
						}
						return true;}
					else
						/*Si le d�placement est �gal il est automatiquement valide car il a pass� les pr�cedents test. Puisque
						le d�placement est de 1, je n'ai pas besoin de v�rifier les cases entre le d�part et l'arriv�*/
						return true;}
				else
					//Si c'est un pion, on v�rifie si la case est libre.
					return !zone[(int)deplacement.getArrivee().getCol()][(int)deplacement.getArrivee().getLi()].estPris();}
			else
				//renvoie true parce qu'un cavalier peut sauter par dessus les pi�ces
				return true;}
		else
			//D�placement ne marche pas si la case de fin a une pi�ce de meme couleur que la pi�ce du d�but
			return false;}
		
}

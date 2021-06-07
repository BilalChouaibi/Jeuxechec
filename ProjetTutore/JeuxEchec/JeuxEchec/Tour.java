package JeuxEchec;

public class Tour extends Piece {
	/** 
	 * Constructeur classe cavalier
	 * @param Prend en parametre la couleur de la tour
	 * 
	 */
	public Tour(String Couleur) {
		super("Tour", Couleur);
	}


	/**
	 * Methode permettant de vérifier la validité du déplacement du roi
	 * @return true ou false si le deplacement du roi est valide
	 * 
	 */
	public boolean Verifdep(Deplacement deplacement) {
		/*
		 * 
		 * 
		 */
		return deplacement.getDepX() * deplacement.getDepY() == 0 && !deplacement.is0();
	}

}

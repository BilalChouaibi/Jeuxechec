package JeuxEchec;

public class Roi extends Piece{
	
	/** 
	 * Constructeur classe roi
	 * 
	 * 
	 */
	public Roi(String Couleur) {
		super("Roi", Couleur);
	}


	/**
	 * Methode permettant de vérifier la validité du déplacement du roi
	 * @return true ou false si le deplacement du roi est valide
	 * 
	 */
	public boolean Verifdep(Deplacement deplacement) {
		/*La somme des déplacements d'un roi ne doivent jamais dépassé 2
		 * 
		 * 
		 */
		return Math.abs(deplacement.getDepX()) * Math.abs(deplacement.getDepY()) <= 1
		&& Math.abs(deplacement.getDepX()) - Math.abs(deplacement.getDepY()) <= 1
		&& Math.abs(deplacement.getDepX()) - Math.abs(deplacement.getDepY()) >= -1
			&& !deplacement.is0();
	}
}

package JeuxEchec;

public abstract class Piece {

	/**
	 * nom de la pièce selon les conventions
	 */
	private String nom;
	/**
	 * Couleur de la pièce
	 */
	private String Coul;

	/** constructeur permettant d'initialiser le nom et la Couleur d'une Piece
	 * 
	 * @param prend en parametre le nom de la piece
	 * @param prend en parametre la Couleur de la piece
	 */
	public Piece(String nom, String Coul) {
		setNom(nom);
		setCoul(Coul);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCoul() {
		return Coul;
	}

	public void setCoul(String Coul) {
		if ((Coul == "noir") || (Coul == "blanc"))
			this.Coul = Coul;
	}



	/** 
	 * méthode abstraite a implementer dans les sous-classe, va servir a verifier la validite du deplacement des piece
	 * @param Deplacement de la piece
	 * @return true ou false dependamment de la validitée du deplacement
	 */

	public abstract boolean Verifdep(Deplacement dep);

}

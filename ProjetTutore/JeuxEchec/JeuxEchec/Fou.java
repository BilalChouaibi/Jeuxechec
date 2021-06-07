package JeuxEchec;

public class Fou extends Piece{
	/** 
	 * Constructeur classe fou
	 * @param Prend en parametre la couleur du fou
	 * 
	 */
	public Fou(String Couleur) {
		super("Fou", Couleur);
	}
	


	/**
	 * Methode estValide, sert a verifier la validite du deplacement d'un fou
	 * @return true ou false si le deplacement du fou est valide
	 * @param Deplacement piece
	 */
	public boolean Verifdep(Deplacement dep) {
		/*Le mouvement du fou est une diagonale, le résultat devra toujours être 0
		 * 
		 */
		return Math.abs(dep.getDepX()) - Math.abs(dep.getDepY()) == 0 && !dep.is0();
		
	}
}

package JeuxEchec;

public class Reine extends Piece{
	
	/** 
	 * Constructeur classe reine
	 * 
	 * 
	 */
	public Reine(String Couleur) {
		super("Reine", Couleur);
	}
		
	/**
	 * Methode permettant de verifier la validit� du d�placement
	 * @return true ou false si le deplacement du fou est valide
	 * 
	 */
	public boolean Verifdep(Deplacement deplacement) {
		/*Le d�placement de la reine est soit en diagonal ou soit rectiligne
		 * Je j'utilise donc les m�thodes du fou et de la tour pour v�rifier celle de la reine.
		 */
		
		return (Math.abs(deplacement.getDepX()) - Math.abs(deplacement.getDepY()) == 0 
				| deplacement.getDepX() * deplacement.getDepY() == 0) && !deplacement.is0();
	}
}

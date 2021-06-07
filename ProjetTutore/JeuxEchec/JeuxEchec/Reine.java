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
	 * Methode permettant de verifier la validité du déplacement
	 * @return true ou false si le deplacement du fou est valide
	 * 
	 */
	public boolean Verifdep(Deplacement deplacement) {
		/*Le déplacement de la reine est soit en diagonal ou soit rectiligne
		 * Je j'utilise donc les méthodes du fou et de la tour pour vérifier celle de la reine.
		 */
		
		return (Math.abs(deplacement.getDepX()) - Math.abs(deplacement.getDepY()) == 0 
				| deplacement.getDepX() * deplacement.getDepY() == 0) && !deplacement.is0();
	}
}

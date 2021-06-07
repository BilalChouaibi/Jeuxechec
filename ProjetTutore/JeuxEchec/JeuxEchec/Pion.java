package JeuxEchec;
/**Verifie si le deplacement du cavalier est valide
 * 
 */


public class Pion extends Piece {
	
	/** 
	 * Constructeur classe pion
	 * 
	 * 
	 */
	public Pion(String Couleur) {
		super("Pion", Couleur);
	}



	/**
	 * Methode Verifdep qui sert a savoir si le deplacement est possible  
	 */
	public boolean Verifdep(Deplacement dep) {
		/*
		 * vérifie que le deplacement en X est nul, après avec la couleur du pion on vérifie en Y est égal à 1 ou 2 par rapport à la position du pion
		 * 
		 */
		if (dep.getDepX() == 0)
			if (this.getCoul().equals("noir")){
				/*
				 * si Déplacement en Y est <= à 2, si la ligne du début n'est pas égal à 1, si le déplacement n'est pas < 0(pion recule pas)
				 * 
				 */  
				return dep.getDepY() <= (dep.getDepart().getLi() == 1 ? 2 : 1) && dep.getDepY() > 0;
			}
			else 
				return dep.getDepY() >= (dep.getDepart().getLi() == 6 ? -2 : -1) && dep.getDepY() < 0;
		return false;				
	}
}

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
		 * v�rifie que le deplacement en X est nul, apr�s avec la couleur du pion on v�rifie en Y est �gal � 1 ou 2 par rapport � la position du pion
		 * 
		 */
		if (dep.getDepX() == 0)
			if (this.getCoul().equals("noir")){
				/*
				 * si D�placement en Y est <= � 2, si la ligne du d�but n'est pas �gal � 1, si le d�placement n'est pas < 0(pion recule pas)
				 * 
				 */  
				return dep.getDepY() <= (dep.getDepart().getLi() == 1 ? 2 : 1) && dep.getDepY() > 0;
			}
			else 
				return dep.getDepY() >= (dep.getDepart().getLi() == 6 ? -2 : -1) && dep.getDepY() < 0;
		return false;				
	}
}

package JeuxEchec;


public class Deplacement {
	
	/**
	 * Deplacement sur l'axe des X
	 */
	private double depX;
	
	/**
	 * Deplacement sur l'axe des Y
	 */
	private double depY;
	
	/**
	 * Coordonnee de la case de fin
	 */
	private Position arrivee;
	
	/**
	 * Coordonnee de la case du d�but
	 */
	private Position depart;
	

	/**Constructeur d'un objet d�placement, calcul les d�placement sur les axes X et Y. Ces valeurs ne sont pas donn� de
	 * mani�re absolue car le pion � besoin de connaitre la direction dans laquelle il se d�place.
	 * @param En param�tre prend case du d�but et case de fin
	 */
	public Deplacement(Position depart, Position arrivee)
	{
		this.arrivee = arrivee;
		this.depart = depart;
		this.depX = arrivee.getCol() - depart.getCol();
		this.depY = arrivee.getLi() - depart.getLi();
	}


	public double getDepX() {
		return depX;
	}

	public double getDepY() {
		return depY;
	}
	
	public Position getArrivee() {
		return arrivee;
	}

	public Position getDepart() {
		return depart;
	}
	
	//On v�rifie le d�placement (null ou pas)
	public boolean is0(){
		return depX == 0 && depY == 0;
	}
	
}

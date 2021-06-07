package JeuxEchec;

public class Case {
	/**
	 * �tat de la case
	 */
	private Piece piece;
	
	/**
	 * Constructeur par defaut
	 */
	public Case()
	{
		
	}
	
	/**
	 * Constructeur parametre
	 */
	public Case(Piece piece)
	{
		this.piece = piece;
	}
	
	/**
	 * V�rification de l'�tat de la case et si elle est vide rien n'est retourn�
	 */
	public Piece getPiece() {
		return piece;
	}
	
	/**
	 * permet de placer une piece sur une case
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * pour savoir si il y a une piece
	 */
	public boolean estPris()
	{
		return (piece != null);	
	}
	
	/**
	Permet de savoir si une piece de couleur noir ou blanc est sur la case
	 */
	public boolean estPris(String couleur)
	{
		if (piece == null)
			return false;
		else
			return (piece.getCoul().equals(couleur));
	}
	
}

package JeuxEchec;

public class Position {
	/**
	 * Numero ligne
	 */
	private int ligne; 
	/**
	 * Numero colonne
	 */
	private int colonne; 

	/*
	 * 
	 * num�ro de colonne correspond � X et num�ro de ligne correspond � Y
	 * 
	 */
	/**
	 * Constructeur classe position, sert a initialiser les deux parametre d'une postion (ligne, colonne)
	 * 
	 * 
	 * 
	 *            
	 * 
	 *            
	 */
	public Position(int colonne, int ligne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public int getLi() {
		return ligne;
	}

	public int getCol() {
		return colonne;
	}

	public void setLi(int ligne) {
		this.ligne = ligne;
	}

	public void setCol(int colonne) {
		this.colonne = colonne;
	}

	public boolean equals(Position pos) {
		return pos.ligne == this.ligne
				&& pos.getCol() == this.getCol();
	}

}
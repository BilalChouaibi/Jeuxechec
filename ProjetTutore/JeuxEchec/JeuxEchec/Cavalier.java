package JeuxEchec;

public class Cavalier extends Piece {

	public Cavalier(String Couleur) {
		super("Cavalier", Couleur);
	}

	public boolean Verifdep(Deplacement dep) {
		/*
		 * Si le r�sultat est �gal � 2 ou � 0,5 on aura bien un mouvement en L
		 */
		return (Math.abs(dep.getDepX() / dep.getDepY())) == 2|(Math.abs(dep.getDepX() / dep.getDepY())) == .5;
	}
}

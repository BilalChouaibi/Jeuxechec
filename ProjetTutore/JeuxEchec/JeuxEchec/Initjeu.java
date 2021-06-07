package JeuxEchec;

public interface Initjeu {
	public abstract void start();
	public abstract Case getCase(int li, int col);
	public abstract boolean dep (Deplacement deplacement);
	public abstract boolean posscatch(Deplacement deplacement);
}

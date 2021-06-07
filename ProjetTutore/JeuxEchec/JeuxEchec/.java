package JeuxEchec;

public interface Initpartie 
{
	
	public abstract void start();
	public abstract Case getCase(int li, int col);
	public abstract boolean cheminPossible (Deplacement deplacement);
	public abstract boolean captureParUnPionPossible(Deplacement deplacement);
}

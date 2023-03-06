package jeu;

public class Mage extends Personnage {
	private int sort;
	public Mage( final String s, final int n, final Element un) {
		super(s,n,un);
		sort = 0;
	}
	public Mage( final String s, final Element un) {
		this(s,100,un);
	}
	@Override
	public String toString() {
		if ( sort == 0)
			return super.toString();
		else
			return super.toString() + "sort=" + sort + "*";
	}
	public void apprendUnNouveauSort(int valeur) {
		if ( valeur > sort) sort = valeur;
	}
	public int attaque() {
		return super.attaque() + sort;
	}
}

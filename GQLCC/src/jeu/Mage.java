package jeu;

public class Mage extends Personnage {
	private int sort;
	public Mage( final String s, final int n, final Element un) {
		super(s,n,un);
		setSort(0);
	}
	public Mage( final String s, final Element un) {
		this(s,100,un);
	}
	@Override
	public String toString() {
		if ( getSort() == 0)
			return super.toString();
		else
			return super.toString() + "sort=" + getSort() + "*";
	}
	public void apprendUnNouveauSort(int valeur) {
		if ( valeur > getSort()) setSort(valeur);
	}
	public int attaque() {
		return super.attaque() + getSort();
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}

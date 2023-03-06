package jeu;

public class Arme extends Element {
	public Arme( final String s, final int n) {
		super(s,n);
	}
	public int attaque() { 
		return valeur(); 
	}
	public int defense() {
		return 0;
	}
	@Override
	public boolean eligible() { return valeur() > 20; }
	@Override
	public boolean equals(Object o) {
		return super.equals(o) && o instanceof Arme;
	}
}

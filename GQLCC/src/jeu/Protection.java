package jeu;

public class Protection extends Element {
	public Protection( final String s, final int n) {
		super(s,n);
	}
	public int attaque() { 
		return 0; 
	}
	public int defense() {
		return valeur();
	}
	@Override
	public boolean eligible() { return true; }
	@Override
	public boolean equals(Object o) {
		return super.equals(o) && o instanceof Protection;
	}
}

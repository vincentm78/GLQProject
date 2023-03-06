package jeu;

import java.util.Objects;

public abstract class Element {
	private final String nom;
	private final int valeur;
	protected Element( final String s, final int n) {
		nom = Objects.requireNonNull(s);
		valeur = n;
	}
	public abstract boolean eligible();
	@Override
	public String toString() {
		return nom + "(" + valeur + ")";
	}
	protected int valeur() { return valeur; }
	public abstract int attaque();
	public abstract int defense();
	public boolean equals(final Object o) {
		if (o == this) return true;
		if (! (o instanceof Element)) return false;
		return valeur ==((Element)o).valeur && nom.equals(((Element)o).nom);
	}
}

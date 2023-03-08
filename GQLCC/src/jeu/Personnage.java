package jeu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public abstract class Personnage implements Cloneable {
	private final String nom;
	private final int sante;
	protected final Element premier;
	private ArrayList<Element> sac;
	protected static Set<String> noms;
	static {
		noms = new HashSet<String>();
	}
	public Personnage( final String s, final int n, final Element un) {
		nom = Objects.requireNonNull(s, "Le parametre 's' est null dans le constructeur de " + getClass().getSimpleName());
		premier = Objects.requireNonNull(un, "Le parametre 'un' est null dans le constructeur de "+ getClass().getSimpleName());
		if (! noms.add(s)) 
			throw new IllegalArgumentException("Un personnage avec le nom " + s + " existe déjà");
		sante = n;
		sac = new ArrayList<>();
	}
	public boolean prend(final Element e) {
		if (e.eligible()) { sac.add(e); return true; }
		return false;
	}
	@Override
	public String toString() {
		return getNom() + "*" + getSante() + "*D:" + premier +"*";
	}
	public int attaque() {
		return premier.attaque();
	}
	public int defense() {
		return getSante() + premier.defense() ; 
	}
	public ArrayList sac() {
		return new ArrayList<>(sac);
	}
	public String combat(final Personnage autre) {
		int points1 = defense();
		int points2 = autre.defense();
		while (points1 > 0 && points2 > 0) {
			points2 -= attaque();
			points1 -= autre.attaque();
		}
		if ( points1 > points2 && points1 > 0 ) return getNom();
		if ( points2 > points1 && points2 > 0) return autre.getNom();
		return null;
	}
	@Override
	public Personnage clone() {
		Personnage clone = null;
		try {
			clone = (Personnage) super.clone();
			clone.sac = (ArrayList<Element>) sac.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(); // code inatteignable
		}
		return clone;
	}
	@Override
	public boolean equals(final Object o) {
		if ( o == this) return true;
		if ( ! ( o instanceof Personnage)) return false;
		return getNom().equals(((Personnage)o).getNom()) ;
	}
	public String getNom() {
		return nom;
	}
	public int getSante() {
		return sante;
	}

}

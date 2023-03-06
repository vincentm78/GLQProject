package jeu;

import java.util.Objects;

public class Guerrier extends Personnage {
	private final Element deuxieme;
	private final int attaque;
	private final int defense;
	private static final int bonusAttaque = 2;
	public Guerrier( final String s, final int n, final Arme un, final Element deux) {
		super(s,n,un);
		if ( Objects.isNull(deux)) noms.remove(s);
		deuxieme = Objects.requireNonNull(deux, "Le parametre 'deux' est null dans le constructeur de "+ getClass().getSimpleName());
		int bonus = 0; 
		if (deuxieme.equals(premier)) 
			bonus = bonusAttaque; 
		attaque = super.attaque() + deuxieme.attaque() + bonus;
		defense = super.defense() + deuxieme.defense();
	}
	@Override
	public String toString() {
		return super.toString() + "G:" + deuxieme + "*";
	}
	public int attaque() {
		return attaque;
	}
	public int defense() {
		return defense; 
	}
}

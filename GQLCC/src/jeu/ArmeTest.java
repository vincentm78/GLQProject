package jeu;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArmeTest {

    @Test
    public void testAttaque() {
        Arme arme = new Arme("Epée", 30);
        assertEquals(30, arme.attaque());
    }

    @Test
    public void testDefense() {
        Arme arme = new Arme("Hache", 25);
        assertEquals(0, arme.defense());
    }

    @Test
    public void testEligible() {
        Arme arme1 = new Arme("Arc", 10);
        assertFalse(arme1.eligible());

        Arme arme2 = new Arme("Lance", 25);
        assertTrue(arme2.eligible());
    }

    @Test
    public void testEquals() {
        Arme arme1 = new Arme("Dague", 15);
        Arme arme2 = new Arme("Dague", 15);
        Arme arme3 = new Arme("Epée", 20);

        assertTrue(arme1.equals(arme2));
        assertFalse(arme1.equals(arme3));
    }
}

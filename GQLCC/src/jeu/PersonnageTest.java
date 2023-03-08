package jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("Tests pour les classes Personnage, Mage et Guerrier")
public class PersonnageTest {

    private Personnage p1;
    private Personnage p2;
    private Personnage p3;
    private Personnage p4;
    private Arme e1;
    private Arme e2;
    private Arme e3;
    private Element e4;
    private Element e5;

    @BeforeEach
    void setUp() {
        e1 = new Arme("Epée", 5);
        e2 = new Arme("Hache", 8);
        e3 = new Arme("Sabre", 5);
        e4 = new Protection("Bouclier", 12);
        e5 = new Protection("Casque", 20);
        
        p1 = new Mage("Merlin", 100, e1);
        p2 = new Guerrier("Arthur", 150, e2, e4);
        //p3 = new Guerrier("Jack", 150, e3 , e5);
        //p4 = new Mage("Arthur", 150, e3);
    }

        @Test
        @DisplayName("Test de la méthode prend() pour un élément éligible")
        void testPrendElementEligible() {
            assertTrue(p1.prend(e3));
            assertEquals(Arrays.asList(e3), p1.sac());
        }

        @Test
        @DisplayName("Test de la méthode prend() pour un élément non éligible")
        void testPrendElementNonEligible() {
            assertFalse(p2.prend(e1));
            assertTrue(p2.sac().isEmpty());
        }

        @Test
        @DisplayName("Test de la méthode attaque()")
        void testAttaque() {
            assertEquals(e1.attaque(), p1.attaque());
        }

        @Test
        @DisplayName("Test de la méthode defense()")
        void testDefense() {
            assertEquals(100 + e1.defense(), p1.defense());
        }

        @Test
        @DisplayName("Test de la méthode combat() quand p1 gagne")
        void testCombatGagne() {
            String gagnant = p1.combat(p2);
            assertEquals(p1.getNom(), gagnant);
        }

        @Test
        @DisplayName("Test de la méthode combat() quand p2 gagne")
        void testCombatPerdu() {
            String gagnant = p2.combat(p1);
            assertEquals(p2.getNom(), gagnant);
        }

        @Test
        @DisplayName("Test de la méthode clone()")
        void testClone() {
            Personnage clone = p1.clone();
            assertTrue(clone instanceof Mage);
            assertNotSame(p1, clone);
            assertEquals(p1.getNom(), clone.getNom());
            assertEquals(p1.getSante(), clone.getSante());
            assertEquals(p1.premier, clone.premier);
            assertEquals(p1.sac(), clone.sac());
        }

        @Test
        @DisplayName("Test de la méthode equals() avec des objets égaux")
        void testEqualsTrue() {
        	Personnage p1 = new Guerrier("Arthur", 100, new Arme("Epée", 5), new Protection("Casque", 20));
            Personnage p2 = new Guerrier("Arthur", 100, new Arme("Epée", 5), new Protection("Casque", 20));
            
            // Act + Assert
            assertTrue(p1.equals(p2));
            assertTrue(p2.equals(p1));
        }
}
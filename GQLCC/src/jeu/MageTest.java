package jeu;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class MageTest {

    private Mage mage;
    private Element element;

    
    //Avant chaque test, initialise un nouveau Mage et un nouvel élément.
     
    @BeforeEach
    void setUp() {
        element = new Arme("épée", 30);
        mage = new Mage("Gandalf", 100, element);
    }

   
    @AfterEach
    void tearDown() {
        Personnage.noms = new HashSet<>();
    }

    @Test
    void testConstructor() {
        assertEquals("Gandalf", mage.getNom());
        assertEquals(100, mage.getSante());
        assertEquals(element, mage.premier);
        assertEquals(new ArrayList<>(Arrays.asList(element)), mage.sac());
        assertEquals(0, mage.getSort());
        assertTrue(Personnage.noms.contains("Gandalf"));
    }

    
    @Test
    void testConstructorNullName() {
        assertThrows(NullPointerException.class, () -> new Mage(null, 100, element));
    }

    
    @Test
    void testConstructorNullElement() {
        assertThrows(NullPointerException.class, () -> new Mage("Gandalf", 100, null));
    }

    
    @Test
    void testConstructorDuplicateName() {
        assertThrows(IllegalArgumentException.class, () -> new Mage("Gandalf", 100, element));
    }

    
    @Test
    void testApprendUnNouveauSort() {
        mage.apprendUnNouveauSort(10);
        assertEquals(0, mage.getSort());
        mage.apprendUnNouveauSort(20);
        assertEquals(20, mage.getSort());
        mage.apprendUnNouveauSort(30);
        assertEquals(30, mage.getSort());
    }

    
    @Test
    void testAttaque() {
        assertEquals(element.attaque(), mage.attaque() - mage.getSort());
    }

    
    @Test
    void testCombat() {
        Mage autreMage = new Mage("Sauron", 100, element);
        assertEquals(null, mage.combat(autreMage));
        autreMage.apprendUnNouveauSort(50);
        assertEquals("Sauron", mage.combat(autreMage));
        mage.apprendUnNouveauSort(60);
        assertEquals("Gandalf", mage.combat(autreMage));
    }

    
    @Test
    void testClone() {
        // Création d'un mage original avec une épée
        Mage original = new Mage("Merlin", 150, element);
        original.apprendUnNouveauSort(2);

        // Clone du mage original
        Mage clone = (Mage) original.clone();

        // Vérification que le clone est identique à l'original
        assertEquals(original.toString(), clone.toString());
        assertNotSame(original, clone);
        assertNotSame(original.sac(), clone.sac());

        // Modification du clone
        clone.apprendUnNouveauSort(4);
        clone.prend(new Arme("Baton", 40));

        // Vérification que le clone a bien été modifié et que l'original est resté inchangé
        assertNotEquals(original.toString(), clone.toString());
        assertNotEquals(original.sac(), clone.sac());
//        assertEquals(original.attaque(), 150);
//        assertEquals(clone.attaque(), 154);
    }
    
    
    @Test
    public void testEquals() {
    	Mage mage1 = new Mage("Gandalf", 100, new Arme("Baguette magique", 50));
    	Mage mage2 = new Mage("Gandalf", 80, new Arme("Bâton", 30));
    	
        assertTrue(mage1.equals(mage1));
        assertTrue(mage1.equals(mage2) && mage2.equals(mage1));
        assertFalse(mage1.equals(null));
        assertFalse(mage1.equals("Gandalf"));
        assertFalse(mage1.equals(new Mage("Saruman", 100, new Arme("Bâton", 30))));
        assertFalse(mage1.equals(new Mage("Gandalf", 80, new Arme("Bâton magique", 50))));
    }
}

package jeu;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MageTest {
/*
    
    @BeforeEach
    void setUp() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Gandalf", 100, element);
    }
*/
    @Test
    void testToStringWithoutSort() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Gandalf", element);
        assertEquals("Gandalf*100*D:Feu(25)*", mage.toString());
    	mage.apprendUnNouveauSort(50);
    	assertEquals("Gandalf*100*D:Feu(25)*sort=50*", mage.toString());
    	assertEquals(50, mage.getSort());
    }
    
    @Test
    void testApprendUnNouveauSortWithLesserValue() {
    	Arme element = new Arme("Eau", 50);
    	Mage mage = new Mage("Vini", 100, element);
        mage.apprendUnNouveauSort(20);
        mage.apprendUnNouveauSort(30);
        assertEquals(30, mage.getSort());
    }
    
    @Test
    void testAttaque() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Michou", 100, element);
        mage.apprendUnNouveauSort(50);
        assertEquals(75, mage.attaque());
    }
    
    @Test
    void testGetSort() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Salomon", element);
        assertEquals(0, mage.getSort());
    }
    
    @Test
    void testSetSort() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Groudon", element);
        mage.setSort(50);
        assertEquals(50, mage.getSort());
    }
    
    @Test
    void testPrendWithEligibleElement() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Pilaf", element);
        assertTrue(mage.prend(element));
        assertTrue(mage.sac().contains(element));
    }
    
    @Test
    void testPrendWithIneligibleElement() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Boulbi", 100, element);
        Element e = new Arme("Eau", 5);
        assertFalse(mage.prend(e));
        assertFalse(mage.sac().contains(e));
    }
    
    @Test
    void testClone() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Moule", element);
        Mage clone = (Mage) mage.clone();
        assertEquals(mage.toString(), clone.toString());
        assertEquals(mage.getSort(), clone.getSort());
        assertEquals(mage.sac(), clone.sac());
        assertEquals(mage, clone);
    }
    
    @Test
    void testEquals() {
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Palpation",  element);
        Mage same = new Mage("Saruman", 50, element);
        Mage different = new Mage("Toucher", 100, element);
        assertFalse(mage.equals(same));
        assertFalse(mage.equals(different));
    }
    
    @Test
	void testCombat() {
    	Arme e = new Arme("Feu", 10);
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Poutre",  e);
        Mage mage2 = new Mage("Receptacle", 50, element);
		String resultat = mage.combat(mage2);
		assertNotNull(resultat, "Le résultat ne doit pas être null");
	}
	
	@Test
	void testCombatGagnant() {
		Arme e = new Arme("Feu", 10);
    	Arme element = new Arme("Feu", 25);
    	Mage mage = new Mage("Uluberlu",  e);
        Mage mage2 = new Mage("Macron", 50, element);
		mage.apprendUnNouveauSort(10);
		String resultat = mage.combat(mage2);
		assertEquals(mage.getNom(), resultat, "Le gagnant est " + mage.getNom());
		mage2.apprendUnNouveauSort(20);
		resultat = mage.combat(mage2);
		assertNotEquals(mage2.getNom(), resultat, "Le gagnant n'est pas " + mage2.getNom());
	}

}

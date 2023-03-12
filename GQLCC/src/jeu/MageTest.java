package jeu;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MageTest {

    
    @Mock
	private Arme element;
	@Mock
	private Protection protection;

	@BeforeEach
	void initialisation() {
		element = mock(Arme.class);
		protection = mock(Protection.class);
	}

    @Test
    void testToStringWithoutSort() {
    	
    	Mage mage = new Mage("Gandalf", element);
    	when(element.toString()).thenReturn("Feu(25)");
        assertEquals("Gandalf*100*D:Feu(25)*", mage.toString());
    	mage.apprendUnNouveauSort(50);
    	assertEquals("Gandalf*100*D:Feu(25)*sort=50*", mage.toString());
    	assertEquals(50, mage.getSort());
    }
    
    @Test
    void testApprendUnNouveauSortWithLesserValue() {
    	Mage mage = new Mage("Vini", 100, element);
        mage.apprendUnNouveauSort(20);
        mage.apprendUnNouveauSort(30);
        assertEquals(30, mage.getSort());
    }
    
    @Test
    void testAttaque() {
    	when(element.attaque()).thenReturn(25);
    	Mage mage = new Mage("Michou", 100, element);
        mage.apprendUnNouveauSort(50);
        assertEquals(75, mage.attaque());
    }
    
    @Test
    void testGetSort() {
    	Mage mage = new Mage("Salomon", element);
        assertEquals(0, mage.getSort());
    }
    
    @Test
    void testSetSort() {
    	Mage mage = new Mage("Groudon", element);
        mage.setSort(50);
        assertEquals(50, mage.getSort());
    }
    
    @Test
    void testPrendWithEligibleElement() {
    	when(element.eligible()).thenReturn(true);
    	Protection p = mock(Protection.class);
    	Mage mage = new Mage("Pilaf", p);
        assertTrue(mage.prend(element));
        assertTrue(mage.sac().contains(element));
    }
    
    @Test
    void testPrendWithIneligibleElement() {
    	when(element.eligible()).thenReturn(false);
    	Protection p = mock(Protection.class);
    	Mage mage = new Mage("Boulbi", 100, p);
        assertFalse(mage.prend(element));
        assertFalse(mage.sac().contains(element));
    }
    
    @Test
    void testClone() {
    	Mage mage = new Mage("Moule", element);
        Mage clone = (Mage) mage.clone();
        assertEquals(mage.toString(), clone.toString());
        assertEquals(mage.getSort(), clone.getSort());
        assertEquals(mage.sac(), clone.sac());
        assertEquals(mage, clone);
    }
    
    @Test
    void testEquals() {
    	Mage mage = new Mage("Mortae",  element);
        Mage same = new Mage("Saruman", 50, element);
        Mage different = new Mage("Arkman", 100, element);
        assertFalse(mage.equals(same));
        assertFalse(mage.equals(different));
    }
    
    @Test
	void testCombat() {
    	when(element.attaque()).thenReturn(10);
		when(element.defense()).thenReturn(0);
    	Mage mage = new Mage("Poutre",  element);
        Mage mage2 = new Mage("Filou", 50, element);
		String resultat = mage.combat(mage2);
		assertNotNull(resultat, "Le résultat ne doit pas être null");
	}
	
	@Test
	void testCombatGagnant() {
		Arme e = mock(Arme.class);
		when(e.attaque()).thenReturn(10);
		when(e.defense()).thenReturn(0);
		when(element.attaque()).thenReturn(25);
		when(element.defense()).thenReturn(0);
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

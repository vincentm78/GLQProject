package jeu;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;

@TestMethodOrder(MethodOrderer.Random.class)
public class GuerrierTest {
	
	@Mock
	private Arme arme;
	@Mock
	private Protection protection;

	@BeforeEach
	void initialisation() {
		arme = mock(Arme.class);
		protection = mock(Protection.class);
	}
	
	
	@Test
	void testConstructeur() {
		new Guerrier("Guerrier", 100, arme, protection);
		new Guerrier("Tartenpion2", 100, arme, arme);
		assertThrows(IllegalArgumentException.class, () -> new Guerrier("Tartenpion2", 100, arme, null));
	}
	
	@Test
	void testToString() {
		
		when(arme.toString()).thenReturn("Epée(50)");
		when(protection.toString()).thenReturn("Bouclier(10)");
		Guerrier guerrier = new Guerrier("Tartuf", 100, arme, protection);
		assertEquals("Tartuf*100*D:Epée(50)*G:Bouclier(10)*", guerrier.toString());
	}
	
	@Test
	void testAttaque() {

		when(arme.attaque()).thenReturn(50);
		when(protection.attaque()).thenReturn(0);
		Guerrier guerrier = new Guerrier("Pipeline", 100, arme, protection);
		assertEquals(50, guerrier.attaque());
	}
	
	@Test
	void testDefense() {
		when(arme.defense()).thenReturn(0);
		when(protection.defense()).thenReturn(10);
		Guerrier guerrier = new Guerrier("Gertrude", 100, arme, protection);
		assertEquals(110, guerrier.defense());
	}
	
	@Test
	void testCombat() {
		when(arme.attaque()).thenReturn(10);
		when(arme.defense()).thenReturn(0);
		when(protection.attaque()).thenReturn(0);
		when(protection.defense()).thenReturn(0);
		Guerrier guerrier = new Guerrier("Mario", 110, arme, protection);
		Guerrier autreGuerrier = new Guerrier("Lancelot", 100, arme, protection);
		assertEquals("Mario", guerrier.combat(autreGuerrier));
		assertEquals(null, guerrier.combat(guerrier.clone()));
	}
	
	
	@Test
	void testSacPrend() {
		Guerrier guerrier = new Guerrier("Bowser", 100, arme, protection);
		Element e = mock(Element.class);
        assertFalse(guerrier.prend(e));
        assertFalse(guerrier.sac().contains(e));
	}
	
	
	@Test
	void testEquals() {
		Guerrier guerrier = new Guerrier("Wario", 100, arme, protection);
		Guerrier different = new Guerrier("Waluidji", 100, arme, protection);
        assertFalse(guerrier.equals(different));
        assertNotEquals(guerrier, different);
        assertTrue(guerrier.equals(guerrier));
        assertFalse(guerrier.equals(arme));
	}
}

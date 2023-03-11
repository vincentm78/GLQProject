package jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class GuerrierTest {
	

	@Test
	void testConstructeur() {
		new Guerrier("Guerrier", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		new Guerrier("Tartenpion2", 100, new Arme("Epée", 50), new Arme("Epée", 50));
		assertThrows(NullPointerException.class, () -> new Guerrier(null, 100, new Arme("Epée", 50), null));
		assertThrows(NullPointerException.class, () -> new Guerrier("Guerrier", 100, null, null));
		assertThrows(IllegalArgumentException.class, () -> new Guerrier("Guerrier", 100, new Arme("Epée", 50), new Protection("Bouclier", 10)));
	}
	
	@Test
	void testToString() {
		Guerrier guerrier = new Guerrier("Tartuf", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		assertEquals("Tartuf*100*D:Epée(50)*G:Bouclier(10)*", guerrier.toString());
	}
	
	@Test
	void testAttaque() {
		Guerrier guerrier = new Guerrier("Pipeline", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		assertEquals(50, guerrier.attaque());
	}
	
	@Test
	void testDefense() {
		Guerrier guerrier = new Guerrier("Gertrude", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		assertEquals(110, guerrier.defense());
	}
	
	@Test
	void testCombat() {
		Guerrier guerrier = new Guerrier("Mario", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		Guerrier autreGuerrier = new Guerrier("Lancelot", 100, new Arme("Hache", 30), new Protection("Casque", 20));
		assertEquals("Mario", guerrier.combat(autreGuerrier));
		assertEquals(null, guerrier.combat(guerrier.clone()));
	}
	
	
	@Test
	void testSacPrend() {
		Guerrier guerrier = new Guerrier("Bowser", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		Element e = new Arme("Eau", 5);
        assertFalse(guerrier.prend(e));
        assertFalse(guerrier.sac().contains(e));
	}
	
	
	@Test
	void testEquals() {
		Guerrier guerrier = new Guerrier("Wario", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
		Guerrier different = new Guerrier("Waluidji", 100, new Arme("Epée", 50), new Protection("Bouclier", 10));
        assertFalse(guerrier.equals(different));
        assertNotEquals(guerrier, different);
	}
}

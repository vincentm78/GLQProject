package jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProtectionTest {
	
	/*Protection protection; 
	
	@BeforeEach
	private void setup() {
		protection = new Protection("Bouclier", 10);
	}
	*/
	@Test
	
	void testConstructeur() {
		Protection protection = new Protection("Bouclier", 10);
		assertEquals("Bouclier(10)", protection.toString());
		assertEquals(10, protection.defense());
	}
	
	@Test
	void testEligible() {
		Protection protection = new Protection("Bouclier", 10);
		assertTrue(protection.eligible());
	}
	
	@Test
	void testEquals() {
		Protection protection1 = new Protection("Bouclier", 10);
		Protection protection2 = new Protection("Bouclier", 10);
		Protection protection3 = new Protection("Casque", 5);
		assertEquals(protection1, protection2);
		assertNotEquals(protection1, protection3);
	}
	
	@Test
	void testAttaque() {
		Protection protection = new Protection("Bouclier", 10);
		assertEquals(0, protection.attaque());
	}
	
	@Test
	void testDefense() {
		Protection protection = new Protection("Bouclier", 10);
		assertEquals(10, protection.defense());
	}
}

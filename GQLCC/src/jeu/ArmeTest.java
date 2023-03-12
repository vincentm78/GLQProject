package jeu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ArmeTest {

	Arme arme;
	
	@BeforeEach
	public void setUp() {
		this.arme = new Arme("Epée", 50);
	}
	
	@ParameterizedTest
	@CsvSource({"-5,-5","20,20","60,60","100,100"})
	void testConstructeur(Integer i, Integer i2) {
		assertEquals(new Arme("Marteau", i).attaque(), i2);
	}
	
    @Test
    public void testConstruction() {
        
        assertEquals(50, arme.valeur());
    }

    @Test
    public void testAttaque() {
        assertEquals(50, arme.attaque());
    }

    @Test
    public void testDefense() {
        assertEquals(0, arme.defense());
    }

    @Test
    public void testEligible() {
        Arme arme1 = new Arme("Hache", 15);
        assertFalse(arme1.eligible());
        assertTrue(arme.eligible());
    }

    @Test
    public void testEquals() {
        Arme arme2 = new Arme("Epée", 50);
        Arme arme3 = new Arme("Hache", 50);
        assertTrue(arme.equals(arme2));
        assertFalse(arme.equals(arme3));
    }
    
    
    @Test
    public void testToString() {
    	arme.toString();
    }
}

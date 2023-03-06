package jeu;

import org.junit.Test;
import static org.junit.Assert.*;

public class ElementTest {

    @Test
    public void testEligible() {
        Element e = new Element("Feu", 10) {
            @Override
            public boolean eligible() {
                return true;
            }

            @Override
            public int attaque() {
                return 5;
            }

            @Override
            public int defense() {
                return 2;
            }
        };
        assertTrue(e.eligible());
    }

    @Test
    public void testToString() {
        Element e = new Element("Eau", 20) {
            @Override
            public boolean eligible() {
                return false;
            }

            @Override
            public int attaque() {
                return 3;
            }

            @Override
            public int defense() {
                return 4;
            }
        };
        assertEquals("Eau(20)", e.toString());
    }

    @Test
    public void testEquals() {
        Element e1 = new Element("Terre", 30) {
            @Override
            public boolean eligible() {
                return true;
            }

            @Override
            public int attaque() {
                return 4;
            }

            @Override
            public int defense() {
                return 3;
            }
        };
        Element e2 = new Element("Terre", 30) {
            @Override
            public boolean eligible() {
                return true;
            }

            @Override
            public int attaque() {
                return 4;
            }

            @Override
            public int defense() {
                return 3;
            }
        };
        Element e3 = new Element("Eau", 20) {
            @Override
            public boolean eligible() {
                return false;
            }

            @Override
            public int attaque() {
                return 3;
            }

            @Override
            public int defense() {
                return 4;
            }
        };
        assertTrue(e1.equals(e2));
        assertFalse(e1.equals(e3));
    }
}

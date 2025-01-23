package fr.esiee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeviseTest {

    private Devise m12CHF;
    private Devise m14CHF;
    private Devise m14USD;

    @BeforeEach
    void setUp() {
        m12CHF = new Devise(12, "CHF");
        m14CHF = new Devise(14, "CHF");
        m14USD = new Devise(14, "USD");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Je suis APRES exécution d'une méthode de test");
    }

    @Test
    void getQuantite() {
        int qte = m12CHF.getQuantite();
        assertEquals(12, qte, "La quantité doit être 12");
    }

    @Test
    void testEquals() {
        assertTrue(m12CHF.equals(m12CHF), "m12CHF doit être égal à lui-même");
        assertFalse(m12CHF.equals(m14CHF), "m12CHF ne doit pas être égal à m14CHF");
        assertFalse(m14CHF.equals(m14USD), "m14CHF ne doit pas être égal à m14USD");
    }

    @Test
    void testAdd() throws MonnaieDifferenteException {
        Devise expected = new Devise(26, "CHF");
        Devise result = m12CHF.add(m14CHF);
        assertEquals(expected, result, "La somme de 12CHF et 14CHF doit être 26CHF");
    }

    @Test
    void testAddDifferentCurrency() {
        assertThrows(MonnaieDifferenteException.class, () -> {
            m12CHF.add(m14USD);
        }, "Une exception doit être levée lorsque les monnaies sont différentes");
    }
}
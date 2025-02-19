package fr.esiee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortefeuilleTest {

    private Portefeuille portefeuille;
    private Devise m5EUR;
    private Devise m10EUR;
    private Devise m12CHF;
    private Devise m14CHF;

    @BeforeEach
    void setUp() {
        portefeuille = new Portefeuille();
        m5EUR = new Devise(5, "EUR");
        m10EUR = new Devise(10, "EUR");
        m12CHF = new Devise(12, "CHF");
        m14CHF = new Devise(14, "CHF");
    }

    @Test
    void testAjoutDevise() throws MonnaieDifferenteException {
        // Ajouter 5 EUR, puis ajouter encore 5 EUR
        portefeuille.ajouteDevise(m5EUR);
        portefeuille.ajouteDevise(m5EUR);

        // Le portefeuille devrait maintenant contenir 10 EUR
        assertEquals(10, portefeuille.getContenu().get("EUR").getQuantite());
    }

    @Test
    void testAjoutDeviseDifférente() throws MonnaieDifferenteException {
        // Ajouter EUR et CHF
        portefeuille.ajouteDevise(m5EUR);
        portefeuille.ajouteDevise(m12CHF);

        // Vérifier que les deux devises sont présentes
        assertTrue(portefeuille.getContenu().containsKey("EUR"));
        assertTrue(portefeuille.getContenu().containsKey("CHF"));
    }

    @Test
    void testToString() throws MonnaieDifferenteException {
        // Ajouter plusieurs devises
        portefeuille.ajouteDevise(m5EUR);
        portefeuille.ajouteDevise(m12CHF);

        // Vérifier que toString() affiche correctement les devises
        String expected = "5 EUR\n12 CHF\n";
        assertEquals(expected, portefeuille.toString());
    }
}

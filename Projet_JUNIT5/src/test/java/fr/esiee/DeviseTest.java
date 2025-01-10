package fr.esiee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviseTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getQuantite() {
        Devise euro = new Devise(100, "euro");
        int qte = euro.getQuantite();
        Assertions.assertEquals(100, qte, "la bonne valeur ");
    }
}
package Test;

import org.junit.jupiter.api.Test;
import pizzeriaPanucci.CartaDiDebito;

import static org.junit.jupiter.api.Assertions.*;

class CartaDiDebitoTest {
    CartaDiDebito CartaTest = new CartaDiDebito("Mario","1234567890123456", "867", "02/2023");
    @Test
    void paga() {
        assertEquals(true, CartaTest.paga(2) );
    }
}
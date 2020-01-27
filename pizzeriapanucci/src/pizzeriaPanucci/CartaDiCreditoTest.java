package pizzeriaPanucci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaDiCreditoTest {
    CartaDiCredito cartaTest = new CartaDiCredito("Mastercard", "1234567890123456", "345", "03/2022");

    @Test
    void paga() {
        assertEquals(true, cartaTest.paga(5));
    }

}
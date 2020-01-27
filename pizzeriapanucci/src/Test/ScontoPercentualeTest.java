package Test;

import org.junit.jupiter.api.Test;
import pizzeriaPanucci.ScontoPercentuale;

import static org.junit.jupiter.api.Assertions.*;

class ScontoPercentualeTest {

    @Test
    void calcolaImportoScontato() {
        //test valore sopra soglia
        ScontoPercentuale scontoPer = new ScontoPercentuale("scontoTest", 10, 10);
        float expected = 8.9f;
        assertEquals(expected,scontoPer.calcolaImportoScontato(11));

        //test valore sotto soglia
        float expectedSame = 10;
        assertEquals(expectedSame,scontoPer.calcolaImportoScontato(9));

        //test valore = soglia
        assertEquals(expectedSame,scontoPer.calcolaImportoScontato(10));

    }

}
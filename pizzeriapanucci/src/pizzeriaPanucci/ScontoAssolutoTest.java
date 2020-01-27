package pizzeriaPanucci;

import static org.junit.jupiter.api.Assertions.*;


class ScontoAssolutoTest {


    @org.junit.jupiter.api.Test
    void calcolaImportoScontato() {

        //test valore sopra soglia
        ScontoAssoluto scontoAss = new ScontoAssoluto("scontoTest", 10, 2);
        int expected = 9;
        assertEquals(expected,scontoAss.calcolaImportoScontato(11));

        //test valore sotto soglia
        assertEquals(expected,scontoAss.calcolaImportoScontato(9));

        //test valore = soglia
        int expectedEq = 10;
        assertEquals(expectedEq, scontoAss.calcolaImportoScontato(10));

    }
}


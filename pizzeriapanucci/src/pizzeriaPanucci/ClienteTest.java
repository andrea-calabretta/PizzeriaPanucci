package pizzeriaPanucci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Cliente clienteTest = new Cliente("Andrea", "Calabretta", "calabretta@gmail.com", "Via Tal dei tali");

    @Test
    void getNome() {
        assertEquals("Andrea", clienteTest.getNome());
    }

    @Test
    void getCognome() {
        assertEquals("Calabretta", clienteTest.getCognome());
    }

    @Test
    void getEmail() {
        assertEquals("calabretta@gmail.com", clienteTest.getEmail());
    }

    @Test
    void getIndirizzo() {
        assertEquals("Via Tal dei tali", clienteTest.getIndirizzo());
    }
}
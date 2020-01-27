package Test;

import org.junit.jupiter.api.Test;
import pizzeriaPanucci.Cliente;
import pizzeriaPanucci.Comanda;
import pizzeriaPanucci.Ingrediente;
import pizzeriaPanucci.Pizza;

import java.nio.channels.Pipe;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ComandaTest {
    Cliente clienteTest = new Cliente("Mario", "Rossi","mariorossi@gmail.com",  "Via Icaro 21");
    Date date = new Date(); //inizializzo la data alla data attuale
    Comanda comandaTest = new Comanda(clienteTest,clienteTest.getIndirizzo(), date);




    @Test
    void getDataPrenotazione() {
        assertEquals(date, comandaTest.getDataPrenotazione());
    }


    @Test
    void getIndirizzoConsegna() {
        assertEquals("Via Icaro 21", comandaTest.getIndirizzoConsegna());
    }

    @Test
    void getCliente() {
        assertEquals(clienteTest, comandaTest.getCliente());

    }

    @Test
    void calcolaTotale() {
        Ingrediente uovo = new Ingrediente("uovo", 0.5f);
        Ingrediente salsa = new Ingrediente("salsa", 1);

        Pizza p = new Pizza("Margherita");
        p.addIngrediente(uovo);
        p.addIngrediente(salsa);

        float expected = 6;
        comandaTest.addPizza(p, 4);
        assertEquals(expected, comandaTest.calcolaTotale() );



    }

    @Test
    void effettuaPagamento() {
        String[] paypalTest1 = {"Enrico", "Bianco"};
        assertEquals(true, comandaTest.effettuaPagamento("paypal", paypalTest1));
        //Ora Testiamo un formato sbagliato di Paypal
        String[] paypalTest2 = {"Enrico", "Bianco", "parametroInPiù"};
        assertEquals(false, comandaTest.effettuaPagamento("paypal", paypalTest2));

        //Ora testiamo le carte di credito
        String[] cartaCreditoTest1 = {"Andrea", "1234567890123456", "324", "12/2025"};
        assertEquals(true, comandaTest.effettuaPagamento("cartacredito", cartaCreditoTest1));
        //Ora Testiamo un formato sbagliato di Paypal
        String[] carteCreditoTest2 = {"Andrea", "1234567890123456", "324", "12/2025", "parametroInPiù"};
        assertEquals(false, comandaTest.effettuaPagamento("cartacredito", carteCreditoTest2));

    }

    @Test
    void associaSconto() {

        Ingrediente uovo = new Ingrediente("uovo", 0.5f);
        Ingrediente salsa = new Ingrediente("salsa", 1);

        Pizza p = new Pizza("Margherita");
        p.addIngrediente(uovo);
        p.addIngrediente(salsa);

        comandaTest.addPizza(p, 70);
        float expected = 100f;
        assertEquals(expected, comandaTest.associaSconto());


    }
}
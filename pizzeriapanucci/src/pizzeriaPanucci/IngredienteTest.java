package pizzeriaPanucci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredienteTest {
    Ingrediente ingr = new Ingrediente("Salsa", 0.5f);

    @Test
    void getNome() {
        assertEquals("salsa", ingr.getNome());
    }

    @Test
    void getCostoIngrediente() {
        assertEquals(0.5f , ingr.getCostoIngrediente());
    }

    @Test
    void getIngrediente() {
        assertEquals("nome=salsa, prezzo="+0.5f, ingr.getIngrediente());
    }
}
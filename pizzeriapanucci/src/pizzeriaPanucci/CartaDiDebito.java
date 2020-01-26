package pizzeriaPanucci;

public class CartaDiDebito extends Carta {

    public CartaDiDebito(String nome, String cognome, String cvv, String scadenza) {
        super(nome, cognome, cvv, scadenza);
    }

    @Override
    public boolean paga(float importoDaPagare) {
        return true;
    }
}

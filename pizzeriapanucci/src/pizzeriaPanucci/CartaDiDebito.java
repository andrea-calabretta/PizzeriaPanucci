package pizzeriaPanucci;

public class CartaDiDebito extends Carta {

    public CartaDiDebito(String nome, String numero, String cvv, String scadenza) {
        super(nome, numero, cvv, scadenza);
    }

    @Override
    public boolean paga(float importoDaPagare) {
        return true;
    }
}

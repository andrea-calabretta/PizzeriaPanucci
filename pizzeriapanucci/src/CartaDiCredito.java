public class CartaDiCredito extends Carta {

    public CartaDiCredito(String nome, String numero, String cvv, String scadenza) {
        super(nome, numero, cvv, scadenza);
    }

    @Override
    public boolean paga(float importoDaPagare) {
        return true;
    }
}

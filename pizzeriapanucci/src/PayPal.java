public class PayPal implements MetodoPagamento{
    private String username;
    private String password;

    public PayPal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean paga(float importoDaPagare) {
        return true;
    }
}

package pizzeriaPanucci;

public abstract class Carta implements MetodoPagamento{
    private String nome;
    private String numero;
    private String cvv;
    private String scadenza;

    public Carta(String nome, String numero, String cvv, String scadenza) {
        this.nome = nome;
        this.numero= numero;
        this.cvv = cvv;
        this.scadenza = scadenza;
    }
}

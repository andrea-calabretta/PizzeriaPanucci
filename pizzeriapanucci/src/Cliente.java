import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private List<Comanda> elencoComande;


    public Cliente(String nome, String cognome, String email, String indirizzo) {
        this.nome=nome;
        this.cognome = cognome;
        this.email=email;
        this.indirizzo=indirizzo;
        this.elencoComande = new LinkedList<Comanda>();

    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public List<Comanda> getElencoComande() {
        return elencoComande;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }

    public void confermaComanda(Comanda comandaCorrente) {
        this.elencoComande.add(comandaCorrente);
    }
}

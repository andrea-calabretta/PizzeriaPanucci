import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;


    public Cliente(String nome, String cognome, String email, String indirizzo) {
        this.nome=nome;
        this.cognome = cognome;
        this.email=email;
        this.indirizzo=indirizzo;
        id = count.incrementAndGet();
    }


    public int getId(){
        return id;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}

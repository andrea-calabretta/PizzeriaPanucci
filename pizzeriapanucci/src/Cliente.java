public class Cliente {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;


    public Cliente(String nome, String cognome, String email, String indirizzo) {
        this.nome=nome;
        this.cognome = cognome;
        this.email=email;
        this.indirizzo=indirizzo;

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
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}

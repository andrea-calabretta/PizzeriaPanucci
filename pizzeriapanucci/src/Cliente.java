public class Cliente {
    private String nome;
    private String cognome;
    private String email;


    public Cliente(String nome, String cognome, String email) {
        this.nome=nome;
        this.cognome = cognome;
        this.email=email;
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
}

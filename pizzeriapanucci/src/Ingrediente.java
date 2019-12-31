public class Ingrediente {
    private String nome;
    private double prezzo;
    private int quantita;

    public Ingrediente(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo=prezzo;
        this.quantita=quantita;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", quantità=" + quantita +
                '}';
    }
}

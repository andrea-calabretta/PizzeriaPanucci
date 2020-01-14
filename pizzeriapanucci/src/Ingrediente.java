public class Ingrediente {
    private String nome;
    private float costoIngrediente;
    private int quantita;

    public Ingrediente(String nome, float costoIngrediente, int quantita) {
        this.nome = nome;
        this.costoIngrediente=costoIngrediente;
        this.quantita=quantita;
    }

    public String getNome() {
        return nome;
    }

    public double getCostoIngrediente() {
        return costoIngrediente;
    }

    public int getQuantita() {
        return quantita;
    }


    public String getIngrediente() {
        return "Ingrediente{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + costoIngrediente +
                ", quantità=" + quantita +
                '}';
    }
}

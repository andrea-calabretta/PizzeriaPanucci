public class Ingrediente {
    private String nome;
    private float prezzo;


    public Ingrediente(String nome, float prezzo) {
        this.nome = nome;
        this.prezzo= prezzo;
    }

    public String getNome() {
        return nome;
    }

    public float getCostoIngrediente() {
        return prezzo;
    }


    @Override
    public String toString() {
        return "Ingrediente{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    public String getIngrediente() {
        return "Ingrediente{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}

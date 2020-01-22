import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private int id;
    private String nome;
    private List <Ingrediente> ingredienti;
    private float importo;

    public Pizza(String nome) {
        this.nome=nome;
        this.ingredienti = new LinkedList<Ingrediente>();
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingrediente> elencoIngredienti() {
        return this.ingredienti;
    }

    public float getPrezzo() {
        this.importo = 0;
        for(Ingrediente i : this.ingredienti)
            this.importo+=i.getCostoIngrediente();
        return this.importo;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredienti.add(ingrediente);
    }

    @Override
    public String toString() {
        String elencoIngredienti="";
        for (Ingrediente i: ingredienti){
            elencoIngredienti+=i.getIngrediente();
        }
        return "Pizza{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingredienti=" + elencoIngredienti+
                '}';
    }
}

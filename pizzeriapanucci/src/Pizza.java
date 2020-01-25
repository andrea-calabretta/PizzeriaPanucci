import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private int id;
    private String nome;
    private List <Ingrediente> ingredientiPizza;
    private float importo;

    public Pizza(String nome) {
        this.nome=nome;
        this.ingredientiPizza = new LinkedList<Ingrediente>();
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
        return this.ingredientiPizza;
    }

    public float getImporto() {
        this.importo = 0;
        for(Ingrediente i : this.ingredientiPizza)
            this.importo+=i.getCostoIngrediente();
        return this.importo;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredientiPizza.add(ingrediente);
    }

    @Override
    public String toString() {
        String elencoIngredienti="";
        for (Ingrediente i: ingredientiPizza){
            elencoIngredienti+=i.getIngrediente();
        }
        return "Pizza{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingredienti=" + elencoIngredienti+
                '}';
    }
}

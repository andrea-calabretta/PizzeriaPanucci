import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private int id;
    private String nome;
    private List <Ingrediente> ingredienti;

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
        Ingrediente ingrediente = null;
        for(Ingrediente i : this.ingredienti)
            i.toString();
        return ingredienti;
    }

    public float getPrezzo() {
        float prezzoPizza= 0;
        for(Ingrediente i : this.ingredienti)
            prezzoPizza+=i.getCostoIngrediente();
        return prezzoPizza;
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

package pizzeriaPanucci;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Pizza {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int idIngrediente;
    private int id;
    private String nome;
    private HashMap<Integer, Ingrediente> ingredientiPizza;
    private float importo;

    public Pizza(String nome) {
        this.nome=nome;
        this.ingredientiPizza=new HashMap<Integer, Ingrediente>();
        idIngrediente=count.incrementAndGet();
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

    public HashMap<Integer, Ingrediente> elencoIngredienti() {
        return this.ingredientiPizza;
    }

    public float getImporto() {
        this.importo = 0;
        ingredientiPizza.forEach((key, value) -> {
            Ingrediente i = value;
            this.importo+=i.getCostoIngrediente();
        });
        return this.importo;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        int idingrediente = count.incrementAndGet();
        if(contains(ingrediente)==false) {
            ingredientiPizza.put(idingrediente,ingrediente);
        }
    }


    public void removeIngrediente(Integer idIngrediente) {
        Ingrediente ingrediente = ingredientiPizza.get(idIngrediente);
        if(contains(ingrediente)==true) {
            ingredientiPizza.remove(idIngrediente);
        }
    }



    public boolean contains(Ingrediente ingrediente){
        if(ingredientiPizza.containsValue(ingrediente)) return true;

        else return false;
    }
    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingredienti=" + this.ingredientiPizza.toString()+
                '}';
    }


}

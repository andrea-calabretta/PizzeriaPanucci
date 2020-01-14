import java.util.HashMap;
import java.util.List;

public class Menu {
    private HashMap<Integer,Pizza> listPizza;

    public Menu() {
        this.listPizza = new HashMap<Integer,Pizza>();
    }

    public HashMap<Integer,Pizza> getPizzeDisponibili() {
        return listPizza;
    }

    public void put(int key, Pizza pizza){
        listPizza.put(key, pizza);
    }

    public Pizza getPizza(int idPizza){
         Pizza pizza=listPizza.get(idPizza);
         return pizza;
    }

    public List<Ingrediente> elencoIngredienti(Pizza pizza) {
        List<Ingrediente> ingredienti= pizza.elencoIngredienti();
        return ingredienti;
    }
}

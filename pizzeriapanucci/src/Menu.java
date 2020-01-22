import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Menu {
    private static Menu instance;
    private static final Object lock = Menu.class;
    private HashMap<Integer,Pizza> listPizza;

    private Menu() { }

    public static Menu getIstance(){
        synchronized (lock){
            if (instance == null){
                instance = new Menu();
                instance.listPizza = new HashMap<Integer,Pizza>();
            }
        }
        return instance;
    }


    public HashMap<Integer,Pizza> getPizzeDisponibili() {
        return listPizza;
    }

    public void put(int key, Pizza pizza){
        listPizza.put(key, pizza);
    }

    public Pizza findPizza(int idPizza){
         Pizza pizza=listPizza.get(idPizza);
         return pizza;
    }

    public List<Ingrediente> elencoIngredienti(Pizza pizza) {
        List<Ingrediente> ingredienti= pizza.elencoIngredienti();
        return ingredienti;
    }
}





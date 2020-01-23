import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Menu {
    private static Menu instance;
    private static final Object lock = Menu.class;
    private HashMap<Integer,Pizza> listPizza;
    private HashMap<Integer, Ingrediente> listIngredientiDisponibili;

    private Menu() { }

    public static Menu getIstance(){
        synchronized (lock){
            if (instance == null){
                instance = new Menu();
                instance.listPizza = new HashMap<Integer,Pizza>();
                instance.listIngredientiDisponibili = new HashMap<Integer, Ingrediente>();
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

    public Ingrediente nuovoIngrediente(String nome, float prezzo){
        Ingrediente ingrediente = new Ingrediente(nome, prezzo);
        return ingrediente;

    }

    public void addIngrediente(Integer ID, Ingrediente ingrediente){
        listIngredientiDisponibili.put(ID, ingrediente);

    }

    public Pizza nuovaPizza(String nome){
        Pizza pc = new Pizza(nome);
        return pc;
    }

    public HashMap <Integer,Ingrediente> getListIngredientiDisponibili(){
        return this.listIngredientiDisponibili;
    }

    public void addToPizza(Pizza pizza, Integer idIngrediente){
        Ingrediente ingrediente = listIngredientiDisponibili.get(idIngrediente);
        pizza.addIngrediente(ingrediente);
    }



    //è Admin che conferma la pizza
    public void confermaPizza(Integer idPizza, Pizza pizza){
    listPizza.put(idPizza, pizza);
    }
}





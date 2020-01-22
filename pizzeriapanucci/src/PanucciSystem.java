import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PanucciSystem {
    /* istanza singleton di BookBoutique */
    private static PanucciSystem singleton;

    private List<Cliente> listaClienti;
    private List<Comanda> Comande;
    private Comanda ComandaCorrente;
    private Menu m;

    /*
     *********************
     * GET ISTANZA SINGLETON E COSTRUTTORE
     *********************
     */

    public static PanucciSystem getIstanza(){
        if (singleton == null){
            singleton = new PanucciSystem();
            singleton.listaClienti = new LinkedList<Cliente>();
            singleton.Comande = new LinkedList<Comanda>();
            singleton.m = new Menu();
            singleton.updateInitialData();
        }

        return singleton;
    }


    private PanucciSystem() {

    }

    private void updateInitialData(){
        caricaClienti();
        caricaPizzeMenu();
    }

    //tutte le carica sono provvisorie

    private void caricaClienti(){
        Cliente c1= new Cliente("marco", "polo", "marcopolo@gmail.com", "via marco polo");
        c1.setId(1);
        this.listaClienti.add(c1);
        Cliente c2= new Cliente("alfredo", "messina", "alfredomessina@gmail.com", "via alfredo messina");
        c2.setId(2);
        this.listaClienti.add(c2);
    }

    private void caricaPizzeMenu(){
        //NOTA: Ha senso mettere quantità in Ingrediente? Si vedrà negli altri casi d'uso
        Ingrediente funghi=new Ingrediente("funghi", (float) 2.5, 1);
        Ingrediente pomodoro=new Ingrediente("pomodoro", (float) 1.5, 1);
        Ingrediente formaggio=new Ingrediente("formaggio", (float) 1.5, 1);
        Ingrediente uovo=new Ingrediente("uovo", (float) 1.5, 1);

        //Aggiungeremo un costo fisso di manodopera per ogni pizza?
        Pizza p1=new Pizza("capricciosa");
        p1.setId(1);
        p1.addIngrediente(funghi);
        p1.addIngrediente(pomodoro);
        p1.addIngrediente(uovo);

        m.put(1, p1);
        Pizza p2=new Pizza("margherita");
        p2.setId(2);
        p2.addIngrediente(formaggio);

        m.put(2,p2);
    }




    public List<Cliente> getListaClienti() {
        return listaClienti;
    }

    public List<Comanda> getElencoComande() {
        return Comande;
    }

    public Comanda getComandaCorrente() {
        return ComandaCorrente;
    }

    public Menu getMenu() {
        return m;
    }

    public Cliente getCliente(int id){
        for (Cliente c:listaClienti){
            if(c.getId()==id) return c;
        }
        return null;
    }


    /* ************************************************************************************ */
    /* **************************** USE CASE 1 : GESTISCI COMANDA ***************************** */
    /* ************************************************************************************ */

    /**
     * Crea una nuovo comanda inizialmente priva di pizze ordinate
     *
     * @return la nuova comanda
     */
    public Comanda nuovaComanda(String indirizzoConsegna, Date DataPrenotazione){
        this.ComandaCorrente = new Comanda(indirizzoConsegna, DataPrenotazione);
        return this.ComandaCorrente;
    }


    public HashMap<Integer,Pizza> elencoPizze(){
        HashMap<Integer,Pizza> pizzeDisponibili=m.getPizzeDisponibili();
        return pizzeDisponibili;
    }


    public Pizza selectPizza (int idPizza){
        Pizza pizza=m.getPizza(idPizza);
        return pizza;
    }

    public List<Ingrediente> elencoIngredienti(Pizza pizza){
        List<Ingrediente> elencoIngredienti = m.elencoIngredienti(pizza);
        return elencoIngredienti;

    }

    public void confermaPizza(Pizza pizza){
        this.ComandaCorrente.addPizza(pizza);
    }

    public float calcolaImporto(){
        return this.ComandaCorrente.calcolaTotale();
    }


    public void confermaComanda(Cliente cliente){
        cliente.confermaComanda(ComandaCorrente);
        this.Comande.add(ComandaCorrente);
    }



}

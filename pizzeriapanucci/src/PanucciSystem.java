import java.util.List;

public class PanucciSystem {
    private List<Cliente> listaClienti;
    private List<Comanda> ElencoComande;
    private Comanda ComandaCorrente;
    private Menu menu;

    public PanucciSystem(List<Cliente> listaClienti, List<Comanda> elencoComande, Comanda comandaCorrente, Menu menu) {
        this.listaClienti = listaClienti;
        ElencoComande = elencoComande;
        ComandaCorrente = comandaCorrente;
        this.menu = menu;
    }


    public List<Cliente> getListaClienti() {
        return listaClienti;
    }

    public List<Comanda> getElencoComande() {
        return ElencoComande;
    }

    public Comanda getComandaCorrente() {
        return ComandaCorrente;
    }

    public Menu getMenu() {
        return menu;
    }
}

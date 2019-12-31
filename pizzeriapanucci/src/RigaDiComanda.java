public class RigaDiComanda {
    private Pizza pizza;
    private int quantita;
    private double subtotale;

    public RigaDiComanda(Pizza pizza, int quantita) {
        this.pizza = pizza;
        this.quantita = quantita;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getSubtotale() {
        return subtotale;
    }
}
